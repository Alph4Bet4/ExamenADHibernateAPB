package alumno.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.*;

public class HqlEsqueleto {
	SessionFactory sf = Hibernateconexion.getSessionFactory();

	// Mapeo:
	public void imprimirProveedores() {
		Session session = sf.openSession();

		List<Proveedor> listaProveedor = session.createQuery("From Proveedor", Proveedor.class).list();

		for (Proveedor proveedor : listaProveedor) {
			System.out.println("ID: " + proveedor.getId());
			System.out.println("Nombre: " + proveedor.getNombre());
			System.out.println("Proveedor_Concesionario ID: " + proveedor.getConcesionario());
		}

		session.close();
	}

	public void imprimirConcesionario() {
		Session session = sf.openSession();

		List<Concesionario> listaConcesionario = session.createQuery("From Concesionario", Concesionario.class).list();

		for (Concesionario concesionario : listaConcesionario) {
			System.out.println("ID: " + concesionario.getId());
			System.out.println("Nombre: " + concesionario.getNombre());
			System.out.println("Proveedor_Concesionario ID: " + concesionario.getProveedor());
			System.out.println("Coche: " + concesionario.getCoche());
		}

		session.close();
	}

	public void imprimirCoche() {
		Session session = sf.openSession();

		List<Coche> listaCoche = session.createQuery("From Coche", Coche.class).list();

		for (Coche coche : listaCoche) {
			System.out.println("ID: " + coche.getId());
			System.out.println("Marca: " + coche.getMarca());
			System.out.println("Antiguedad: " + coche.getMarca());
			System.out.println("ID_Concesionario: " + coche.getConcesionario());
			System.out.println("Deportivo: " + coche.getDeportivo());
		}

		session.close();
	}

	public void imprimirDeportivo() {
		Session session = sf.openSession();
		List<Deportivo> listaDeportivo = session.createQuery("From Deportivo", Deportivo.class).list();

		for (Deportivo deportivo : listaDeportivo) {
			System.out.println(deportivo.toString());
		}

		session.close();
	}

	// Persistencia
	public void nuevoCoche(Coche c, int concesionarioPertenece) {
		Session session = sf.openSession();
		Transaction transiccion = session.beginTransaction();
		
		try {
			Concesionario concesionarioAlPertenece = session.get(Concesionario.class, concesionarioPertenece);
			
			c = new Coche(c.getId(), c.getMarca(), c.getAntiguedad(), c.getPrecio(), concesionarioAlPertenece, null);
			
			session.persist(c);
			
			transiccion.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Ese coche ya existe");
		}
	}

	public void nuevoConcesionarioConNuevosCoches(Concesionario concesionario, ArrayList<Coche> coches) {
		Session session = sf.openSession();
		Transaction transaccion = session.beginTransaction();
		concesionario = new Concesionario();
		
		session.persist(concesionario);
		
		for (Coche coche : coches) {
			session.persist(coche);
		}
		
		transaccion.commit();
		session.close();
		
	}

	public void eliminarConcesionario(int id) {
		Session session = sf.openSession();
		Transaction transaccion = session.beginTransaction();

		Concesionario concesionarioABorrar = session.get(Concesionario.class, id);

		Set<Coche> cochesABorrar = concesionarioABorrar.getCoche();

		for (Coche coche : cochesABorrar) {
			session.remove(coche);
		}
		
		transaccion.commit();
		session.remove(concesionarioABorrar);

		transaccion.commit();
		session.close();
	}

	// HQL
	public void cochePrecioAntiguad(int precio, int antiguedad) {
		List<Coche> coches = null;
		Session session = sf.openSession();

		String hql = "FROM Coche as c WHERE c.precio >=:precioPasado AND c.antiguedad <=:antiguedadPasada";
		Query<Coche> consulta = session.createQuery(hql, Coche.class);
		consulta.setParameter("precioPasado", precio);
		consulta.setParameter("antiguedadPasada", antiguedad);

		coches = consulta.getResultList();

		System.out.println(coches.toString());
		session.close();

	}

	public void cochePrecioMedioPorMarca() {
		Session session = sf.openSession();

		String hql = "SELECT c.marca, AVG(c.precio) FROM Coche as c GROUP BY c.marca";

		Query<Object[]> consulta = session.createQuery(hql, Object[].class);
		List<Object[]> listaCoches = consulta.getResultList();

		for (Object[] object : listaCoches) {
			System.out.println("Para la marca: " + object[0] + " el precio medio es: " + object[1]);
			
		}
		
		session.close();
	}

}

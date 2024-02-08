package alumno.hql;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.*;

public class Hibernateconexion {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();

				addClasses(configuration); // Cambia en cada proyecto

				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				System.out.println("Error" + e);
			}
		}
		return sessionFactory;
	}

	private static void addClasses(Configuration configuration) {
		configuration.addClass(Deportivo.class);
		configuration.addClass(Coche.class);
		configuration.addClass(Concesionario.class);
		configuration.addClass(Proveedor.class);
	}
}

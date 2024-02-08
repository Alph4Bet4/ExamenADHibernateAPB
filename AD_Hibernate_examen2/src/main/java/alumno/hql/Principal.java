package alumno.hql;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Adrián Pérez Blanco");

		var hqlEsqueleto = new HqlEsqueleto();

		// MAPEO 1-4 HECHO
		hqlEsqueleto.imprimirProveedores();
		hqlEsqueleto.imprimirConcesionario();
		hqlEsqueleto.imprimirCoche();
		hqlEsqueleto.imprimirDeportivo(); 

		// Persistencia 5-7
		// 5 HECHO
		Coche coche = null;
		hqlEsqueleto.nuevoCoche(coche, 1);
		//6 HECHO
		Concesionario concesionario = null; 
		ArrayList<Coche> coches = null;
		hqlEsqueleto.nuevoConcesionarioConNuevosCoches(concesionario, coches); 
		//7
		hqlEsqueleto.eliminarConcesionario(2); // NO HECHO
		//HQL 8-9 HECHO
		hqlEsqueleto.cochePrecioAntiguad(1, 1);
		hqlEsqueleto.cochePrecioMedioPorMarca();

	}

}

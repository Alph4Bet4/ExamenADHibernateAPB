/**
 * 
 */
package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class Proveedor {
	int id;
	String nombre;
	Set<Concesionario> concesionario = new HashSet<Concesionario>();
	
	public Proveedor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Concesionario> getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Set<Concesionario> concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre +"]";
	}

	
	
}

/**
 * 
 */
package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class Concesionario {
	int id;
	String nombre;
	Set<Proveedor> proveedor = new HashSet<Proveedor>();
	Set<Coche> coche = new HashSet<Coche>();

	public Concesionario() {
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

	public Set<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(Set<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	public Set<Coche> getCoche() {
		return coche;
	}

	public void setCoche(Set<Coche> coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}

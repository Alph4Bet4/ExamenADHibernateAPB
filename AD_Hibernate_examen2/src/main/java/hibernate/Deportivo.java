/**
 * 
 */
package hibernate;

/**
 * 
 */
public class Deportivo {
	int id;
	int cilindrada;
	Coche coche;
	
	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Deportivo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Deportivo [id=" + id + ", cilindrada=" + cilindrada + "]";
	}
	
	
}

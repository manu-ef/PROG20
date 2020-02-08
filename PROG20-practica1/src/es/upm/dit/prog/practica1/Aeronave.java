package es.upm.dit.prog.practica1;

public class Aeronave {
	
	// Definicion de variables
	private String id;
	private Vector pos0;
	private double t0;
	private Vector pos;
	private double t;
	
	// Constructor
	public Aeronave(String id, Vector pos0, double t0, Vector pos, double t) {
		this.id = id;
		this.pos0 = pos0;
		this.t0 = t0;
		this.pos = pos;
		this.t = t;
	}
	
	// Metodos modificadores
	public void setId(String id) {
		
	}
	public void setPos(Vector pos) {
		
	}
	
	// Metodos accesores
	public String getId() {
		return this.id;
	}
	public Vector getPos0() {
		return this.pos0;
	}
	public double getT0() {
		return this.t0;
	}
	public Vector getPos() {
		return this.pos;
	}
	public double getT() {
		return this.t;
	}
	
	// Metodos equals y toString
	@Override
	public String toString() {
		return "Aeronave [id=" + id + ", pos0=" + pos0 + ", t0=" + t0 + ", pos=" + pos + ", t=" + t + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeronave other = (Aeronave) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	// getVelocidad
	public Vector getVelocidad() {
		
		Vector vectorVelocidad = new Vector(id);
		
		return
	}
}

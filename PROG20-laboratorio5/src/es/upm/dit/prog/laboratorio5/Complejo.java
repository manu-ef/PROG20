/**
 * 
 */
package es.upm.dit.prog.laboratorio5;

/**
 * @author juancarlosduenaslopez
 *
 */
public class Complejo {
	private double r;
	private double i;
	
	public Complejo(double r, double i) {
		super();
		this.r = r;
		this.i = i;
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double mod() {
		return Math.sqrt((this.r * this.r) + (this.i * this.i));
	}
	
	public double arc() {
		return Math.atan2(this.i, this.r);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(i);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(i) != Double.doubleToLongBits(other.i))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Complejo [r=" + r + ", i=" + i + "]";
	}
	
	public Complejo opuesto() {
		return new Complejo (-this.r, -this.i);
	}
	
	public Complejo conjugado() {
		return new Complejo (this.r, -this.i);
	}
	
	public Complejo suma (Complejo c) {
		return new Complejo (this.r + c.r, this.i + c.i);
	}
	
	public Complejo multiplica (Complejo c) {
		return new Complejo ((this.r * c.r) - (this.i * c.i), (this.r * c.i) + (this.i * c.r));
	}
	
	public Complejo divide (Complejo c) {
		return new Complejo (((this.r * c.r) + (this.i * c.i)) / ((c.r * c.r) + (c.i * c.i)), 
				((this.i * c.r) - (this.r * c.i)) /  ((c.r * c.r) + (c.i * c.i)));
	}
	
}

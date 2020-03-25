package es.upm.dit.prog.laboratorio4;

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

	@Override
	public String toString() {
		return "Complejo [r=" + r + ", i=" + i + "]";
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

	public double modulo() {
		double sumaCuadrados = this.r*this.r + this.i*this.i;
		return Math.sqrt(sumaCuadrados);
	}
	
	public double angulo() {
		return Math.atan2(i, r);
	}
	
	public Complejo opuesto() {
		return new Complejo (-this.r, -this.i);
	}
	public Complejo conjugado() {
		return new Complejo (this.r, -this.i);
	}
	
	public Complejo suma(Complejo sumando) {
		return new Complejo(this.r + sumando.r, this.i + sumando.i);
	}
	
	public Complejo multiplica(Complejo factor) {
		double r = this.r*factor.r - this.i*factor.i;
		double i = this.i*factor.r + this.r*factor.i;
		return new Complejo(r, i);
	}
	/*
	public Complejo divide(Complejo divisor) {
		double r = ;
		double i = ;
		return new Complejo(r, i);
	}
	*/
}

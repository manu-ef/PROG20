package es.upm.dit.prog.laboratorio3;

public class ElementoRadiactivo {
	
	private String id;
	private double lambda;
	
	public ElementoRadiactivo (String id, double lambda) {
		this.id = id;
		this.lambda = lambda;
	}

	@Override
	public String toString() {
		return "ElementoRadiactivo [id=" + id + ", lambda=" + lambda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lambda);
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
		ElementoRadiactivo other = (ElementoRadiactivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(lambda) != Double.doubleToLongBits(other.lambda))
			return false;
		return true;
	}
	
	public double getVidaMedia() {
		double tau = (Math.log(2))/(lambda);
		return tau;
	}
	
	public double getProporcionDesintegrados(double t) {
		double proporcion = 1 - Math.exp(- lambda * t);
		return proporcion;
	}
	
}

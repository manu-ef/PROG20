
package es.upm.dit.prog.laboratorio2;

public class AngryBird {

	private static final double g = 9.80665;
	private String id;
	private double v;
	private double angulo;
	
	// Constructor
	public AngryBird(String id, double moduloV, double angulo) {
		this.id = id;
		this.v = moduloV;
		this.angulo = angulo;
	}
	
	// Getters
	public String getId() {
		return this.id;
	}
	
	public double getV() {
		return this.v;
	}
	
	public double getAngulo() {
		return this.angulo;
	}
	
	// Setters
	public void setId(String nuevoId) {
		this.id = nuevoId;
	}
	
	public void setV(double nuevoV) {
		this.v = nuevoV;
	}
	
	public void setAngulo(double nuevoAngulo) {
		this.angulo = nuevoAngulo;
	}
	
	// Metodos propios
	public double getTiempoHMax() {
		double vY = this.v * Math.sin(this.angulo);
		return vY/g;
	}
	
	public double getTiempo() {
		return 2 * getTiempoHMax();
	}
	
	public double getAltura() {
		double vY = this.v * Math.sin(this.angulo);
		return (vY * vY)/(2 * g);
	}
	
	public double getDistancia() {
		double vY =this.v * Math.sin(this.angulo);
		double vX = this.v * Math.cos(this.angulo);
		return 2 * vX * vY / g;
	}
}

package es.upm.dit.prog.laboratorio4;

public class Personaje {
	private String nombre;
	private int salud;
	private int saludMaxima;
	private int ataque;
	public Personaje (String nombre, int saludMaxima, int ataque) {
		this.nombre = nombre;
		this.salud = saludMaxima;
		this.saludMaxima = saludMaxima;
		this.ataque = ataque;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getSalud() {
		return salud;
	}

	public int getSaludMaxima() {
		return saludMaxima;
	}

	public int getAtaque() {
		return ataque;
	}

	public void ataca (int saludDeOtro) {
		int pupa = this.ataque;
		saludDeOtro = saludDeOtro - pupa;
		// este metodo no tiene ningun efecto sobre los objetos		
	}	
	
	public boolean estaVivo () {
		return salud > 0;	
	}
	
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre +  ", salud=" + salud + "/" + saludMaxima+ ", ataque="
				+ ataque + "]";
	}

}

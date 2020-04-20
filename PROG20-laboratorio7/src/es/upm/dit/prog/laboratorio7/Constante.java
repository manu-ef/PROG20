package es.upm.dit.prog.laboratorio7;

public class Constante implements GeneradorNumeros {

	private int c;
	public Constante(int c) {
		this.c = c;
	}
	
	@Override
	public int getSiguienteNumero() {
		// TODO Auto-generated method stub
		return this.c;
	}

	@Override
	public String getNombreGenerador() {
		// TODO Auto-generated method stub
		return "Constante";
	}

	@Override
	public int getUltimoNumero() {
		// TODO Auto-generated method stub
		return this.c;
	}

}

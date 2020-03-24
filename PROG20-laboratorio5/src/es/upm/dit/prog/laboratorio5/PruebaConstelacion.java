package es.upm.dit.prog.laboratorio5;

public class PruebaConstelacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complejo[] cs = new Complejo[10];
		for (int i = 0; i < cs.length-1; i++) {
			cs[i] = new Complejo (i, i);
		}
		cs[cs.length -1] = null;
		Constelacion c = new Constelacion (cs);
		
		System.out.println(c.getCentro());
		System.out.println(c.cercano(new Complejo(1.8, 2)));
	}

}

package es.upm.dit.prog.practica1;

import static org.junit.Assert.assertEquals;

public class PruebaAeronave11 {
	
	public void testAeronave() {
		Vector pos0 = new Vector(0,0,0);
		int t = 0;
		Aeronave a = new Aeronave ("A01", pos0, t, pos0, t);
		System.out.println(a);
		System.out.println("a.getId()=" + a.getId()
			+ "\n***correcto=" + (a.getId().equals("A01")));
		System.out.println("a.getPos()=" + a.getPos()
		    + "\n***correcto=" + (a.getPos().equals(pos0)));
		System.out.println("a.getPos0()=" + a.getPos0()
	    	+ "\n***correcto=" + (a.getPos0().equals(pos0)));
		System.out.println("a.getT()=" + a.getT()
	    	+ "\n***correcto=" + (a.getT() == t));
		System.out.println("a.getT0()=" + a.getT0()
    		+ "\n***correcto=" + (a.getT0() == t));
		System.out.println("a.getVelocidad().modulo()=" + a.getVelocidad().modulo()
			+ "\n***correcto=" + (a.getVelocidad().modulo() == 0.0));
		 
	}
	
	public void testEquals () {
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		Aeronave a2 = new Aeronave ("A01", pos0, t, pos0, t);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println("a1.equals(a2)=" + a1.equals(a2)
			+ "\n***correcto=" + (a1.equals(a2)));
		a2.setId("A02");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println("a1.equals(a2)=" + a1.equals(a2)
			+ "\n***correcto=" + (! a1.equals(a2)));
	}
	
	public void testMover() {
		// mover en el mismo tiempo
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (10, 10, 10);
		Vector pos2 = new Vector (20, 20, 20);
		Vector pos3 = new Vector (30, 30, 30);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		System.out.println(a1);
		a1.mover(pos1, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos1,0);a1.getPos()=" + a1.getPos()
			+ "\n***correcto=" + (a1.getPos().equals(pos1) && a1.getPos0().equals(pos0)));
		a1.mover(pos2, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos2,0);a1.getPos()=" + a1.getPos()
			+ "\n***correcto=" + (a1.getPos().equals(pos2) && a1.getPos0().equals(pos0)));

		// mover en tiempo posterior
		t = t + 10;
		a1.mover(pos3, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos3,10);a1.getPos()=" + a1.getPos()
			+ "\n***correcto=" + (a1.getPos().equals(pos3) && a1.getPos0().equals(pos2)));
	}
	
	public void testVelocidad() {
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (10, 10, 10);
		Vector pos2 = new Vector (20, 20, 20);
		Vector pos3 = new Vector (30, 30, 30);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		// mover t=0
		System.out.println(a1);
		a1.mover(pos1, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos1,0);a1.getVelocidad()=" + a1.getVelocidad()
			+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(0,0,0))));
		// mover t=0
		a1.mover(pos2, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos2,0);a1.getgetVelocidad()=" + a1.getVelocidad()
			+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(0,0,0))));
		// mover t=10 -velocidad positiva
		t = t + 10;
		a1.mover(pos3, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos3,10);a1.getVelocidad()=" + a1.getVelocidad()
			+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(1,1,1))));
		// mover t=20 -velocidad negativa
		t = t + 10;
		a1.mover(pos2, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos2,20);a1.getVelocidad()=" + a1.getVelocidad()
			+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(-1,-1,-1))));
		// mover t=30 -velocidad nula
		t = t + 10;
		a1.mover(pos2, t);
		System.out.println(a1);
		System.out.println("a1.mover(pos2,20);a1.getVelocidad()=" + a1.getVelocidad()
			+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(0,0,0))));
	}
	
	public PruebaAeronave11() {
	}
	
	public static void main(String[] args) {
		PruebaAeronave11 p = new PruebaAeronave11();
		p.testAeronave();
		p.testEquals();
		p.testMover();
		p.testVelocidad();
	}

}

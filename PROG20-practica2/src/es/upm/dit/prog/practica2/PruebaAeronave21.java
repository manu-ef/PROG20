package es.upm.dit.prog.practica2;

import static org.junit.Assert.assertEquals;

public class PruebaAeronave21 {
	
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
	
	public PruebaAeronave21() {
	}
	
	public void testMover2() {
		System.out.println("-----TEST MOVER 2-----");
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (10, 10, 10);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		t = t + 10;
		a1.mover(pos1, t);
		System.out.println("testMover2 " + a1);
		// mover(t), dt > 0
		t = t + 10;
		a1.mover(t);
		System.out.println("testMover2 " + a1 
				+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(1,1,1)) 
						&& (a1.getPos().equals(new Vector(20,20,20)))));		
		// mover(t), dt = 0
		t = t + 0;
		a1.mover(t);
		System.out.println("testMover2 " + a1 
				+ "\n***correcto=" + (a1.getVelocidad().equals(new Vector(1,1,1)) 
						&& (a1.getPos().equals(new Vector(20,20,20)))));		
	}
	
	public void testCompatible() {
		System.out.println("-----TEST COMPATIBLE-----");
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (100, 100, 100);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		t = t + 10;
		a1.mover(pos1, t);
		// velocidad 0, en distancia, fuera
		t = t + 10;
		a1.mover(pos1, t); 
		// igual posicion ahora
		Vector p11 = new Vector(100, 100, 100);
		System.out.println("testCompatible " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t)));
		// posicion en rango ahora
		p11 = new Vector(110, 110, 110);
		System.out.println("testCompatible " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t)));
		// posicion fuera de rango ahora
		p11 = new Vector(150, 110, 110);
		System.out.println("testCompatible " + a1 + " con " + p11 
				+ "\n***correcto=" + (! a1.compatibleCon(p11, t)));
		// posicion en rango futuro
		p11 = new Vector(110, 110, 110);
		System.out.println("testCompatible t=" + (t + 100) + " " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t+100)));
	}
	
	public void testCompatible2() {
		
		// vel > 0
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (100, 100, 100);
		Vector pos2 = new Vector (200, 200, 200);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		t = t + 10;
		a1.mover(pos1, t);
		t = t + 10;
		a1.mover(pos2, t); // pos2=200,200,200, t=20, v=10,10,10
		// dt = 0, igual posicion ahora
		Vector p11 = new Vector(200, 200, 200);
		System.out.println("testCompatible2 " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t)));
		// dt = 0, posicion en rango ahora
		p11 = new Vector(210, 210, 210);
		System.out.println("testCompatible2 " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t)));
		// dt = 0, posicion fuera de rango ahora
		p11 = new Vector(250, 210, 210);
		System.out.println("testCompatible2 " + a1 + " no con " + p11 
				+ "\n***correcto=" + (! a1.compatibleCon(p11, t)));
		// dt = 10, posicion en rango futuro
		t = t + 10;
		p11 = new Vector(310, 310, 310);
		System.out.println("testCompatible t=" + t + " " + a1 + " con " + p11 
				+ "\n***correcto=" + (a1.compatibleCon(p11, t)));
		// dt = 10, posicion fuera de rango futuro
		p11 = new Vector(350, 300, 300);
		System.out.println("testCompatible t=" + t + " " + a1 + " no con " + p11 
				+ "\n***correcto=" + (! a1.compatibleCon(p11, t+100)));
	}
	
	public void testAmenazadaPor() {
		System.out.println("-----TEST AMENAZADA POR-----");
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (100, 100, 200);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		// otra null
		System.out.println("testAmenazadaPor nula " + t + " " + a1 + "no con nula"
				+ "\n***correcto=" + (!a1.amenazadaPor(null)));
		// this v=0 no hay amenaza
		Aeronave a2 = new Aeronave ("A02", pos0, t, pos0, t);
		t = t + 10;
		a1.mover(t);
		a2.mover(pos1, t);
		System.out.println("testAmenazadaPor v=0 t=" + t + " " + a1 + " " + a2
				+ "\n***correcto=" + (!a1.amenazadaPor(a2)));
	}
	
	public void testAmenazadaPor2() {
		// v=10,10,10
		System.out.println("-----TEST AMENAZADA POR 2 -----");
		int t = 0;
		Vector pos0 = new Vector(0,0,0);
		Vector pos1 = new Vector (100, 100, 100);
		Aeronave a1 = new Aeronave ("A01", pos0, t, pos0, t);
		t = t + 10;
		a1.mover(pos1, t); 		
		// dentro area, fuera altura
		Vector pos2 = new Vector(100,100, 6000);
		Aeronave a2 = new Aeronave ("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (!a1.amenazadaPor(a2)));
		// limite futuro 550,550,z+-200 
		pos2 = new Vector(500,500,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (a1.amenazadaPor(a2)));
		pos2 = new Vector(550,550,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (!a1.amenazadaPor(a2)));
		// limite pasado -50,-50,z+-200
		pos2 = new Vector(-50,-40,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (a1.amenazadaPor(a2)));
		pos2 = new Vector(-50,-60,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (!a1.amenazadaPor(a2)));
		// limite lateral ? 400,100,z
		pos2 = new Vector(400,100,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (a1.amenazadaPor(a2)));
		pos2 = new Vector(500,-100,200);
		a2 = new Aeronave("A02", pos0, t-10, pos2, t);
		System.out.println("testAmenazadaPor2 " + a1 + " " + a2
				+ "\n***correcto=" + (!a1.amenazadaPor(a2)));
		// fuera area,  dentro altura
		// dentro area, dentro altura, delante
		// dentro area, dentro altura, detrás
		// dentro area, dentro altura, lateral
	}
	
	
	public static void main(String[] args) {
		PruebaAeronave21 p = new PruebaAeronave21();
		p.testAeronave();
		p.testEquals();
		p.testMover();
		p.testVelocidad();
		p.testMover2();
		p.testCompatible();
		p.testCompatible2();
		p.testAmenazadaPor();
		p.testAmenazadaPor2();
	}

}

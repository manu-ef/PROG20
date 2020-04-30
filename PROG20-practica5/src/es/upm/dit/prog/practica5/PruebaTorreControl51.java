package es.upm.dit.prog.practica5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PruebaTorreControl51 {
		
	public PruebaTorreControl51() {
	}
		
	public boolean assertEquals(List<Aeronave> expected, List<Aeronave> obtained) {
		if (expected.size() != obtained.size())
			return false;
		for (int i = 0; i < expected.size(); i++)
			if (! expected.get(i).equals(obtained.get(i)))
				return false;
		return true;
	}
	
	public void testAddGetAeronaves(){
		try {
			TorreControl tc = new TorreControl();
			System.out.println("testAddAeronave 0 " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(new ArrayList<Aeronave>(), tc.getAeronaves(new SelectorAeronaveTrue())));
			
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("A0" + (i+1), new Vector(0,0,0), 0, new Vector(100*i,100*i,100*i), i);
				tc.addAeronave(as[i]);
			}
			System.out.println("testAddAeronave 10 " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(as), tc.getAeronaves(new SelectorAeronaveTrue())));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddAeronave o testGetAeronaves.");
		}
	}

	public void testAddGetAeronaves2(){
		try {
			TorreControl tc = new TorreControl();
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("A0" + (i+1), new Vector(0,0,0), 0, new Vector(100*i,100*i,100*i), i);
				tc.addAeronave(as[i]);
			}
			Aeronave a11 = new Aeronave("A11" + 0, new Vector(0,0,0), 0, new Vector(100*11, 100*11, 100*11), 11);
			Aeronave[] nuevo = new Aeronave[] {
					as[0], as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9], a11
			};
			tc.addAeronave(a11);
			System.out.println("testAddAeronave 11 " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(nuevo), tc.getAeronaves(new SelectorAeronaveTrue())));
			Aeronave a12 = new Aeronave("A12" + 0, new Vector(0,0,0), 0, new Vector(100*11, 100*11, 100*11), 12);
			nuevo = new Aeronave[] {
					as[0], as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9], a11, a12
			};
			tc.addAeronave(a12);
			System.out.println("testAddAeronave 12 " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(nuevo), tc.getAeronaves(new SelectorAeronaveTrue())));
		}
		catch (Exception e) {
			System.out.println("Fallo (2) detectado en testAddAeronave o testGetAeronaves");
		}
	}

	public void testAddDeteccion(){
		try {
			// nueva, hay sitio
			TorreControl tc = new TorreControl();
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("AUTO" + i
						, new Vector(100*i,100*i,100*i), 0
						, new Vector(100*(i+1),100*(i+1),100*(i+1)), 10+i);
				tc.addDeteccion(as[i].getPos(), 10+i);
			}
			System.out.println("testAddDeteccion " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(as), tc.getAeronaves(new SelectorAeronaveTrue())));

			// nueva, siempre hay sitio
			Aeronave a11 = new Aeronave("AUTO10", new Vector(1000,1000,1000), 0, new Vector(100*11, 100*11, 100*11), 20);
			tc.addDeteccion(a11.getPos(), a11.getT());
			Aeronave[] nuevo = new Aeronave[] {
					as[0], as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9], a11
			};
			System.out.println("testAddDeteccion " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(nuevo), tc.getAeronaves(new SelectorAeronaveTrue())));

			// mueve
			for (int i = 0; i < nuevo.length; i++) {
				Vector pos = new Vector(nuevo[i].getPos().getX()+10, nuevo[i].getPos().getY()+10
						,nuevo[i].getPos().getZ()+10);
				tc.addDeteccion(pos, nuevo[i].getT() + 10);
			}
			System.out.println("testAddDeteccion " + tc.getAeronaves(new SelectorAeronaveTrue()).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(nuevo), tc.getAeronaves(new SelectorAeronaveTrue())));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddDeteccion.");
		}
	}

	
	public void testGetAmenazadas(){
		try {
			TorreControl tc = new TorreControl();
			Aeronave a0 = new Aeronave("AUTO0", new Vector(90,90,100), 9, new Vector(100,100,100), 10);
			Aeronave a1 = new Aeronave("AUTO1", new Vector(100,410,110), 9, new Vector(100,400,110), 10);
			Aeronave a2 = new Aeronave("AUTO2", new Vector(400,100,120), 9, new Vector(400,100,120), 10);
			Aeronave a3 = new Aeronave("AUTO3", new Vector(805,0,100), 9, new Vector(800,0,110), 10);
			tc.addDeteccion(a0.getPos0(),a0.getT0());
			tc.addDeteccion(a1.getPos0(),a1.getT0());
			tc.addDeteccion(a2.getPos0(),a2.getT0());
			tc.addDeteccion(a3.getPos0(),a3.getT0());
			tc.addDeteccion(a0.getPos(),a0.getT());
			tc.addDeteccion(a1.getPos(),a1.getT());
			tc.addDeteccion(a2.getPos(),a2.getT());
			tc.addDeteccion(a3.getPos(),a3.getT());
			Aeronave []as = new Aeronave [] {a0,a1,a2,a3};
			Aeronave [] amenazadas = new Aeronave [] {a0, a1};
			SelectorAeronave s = new SelectorAeronaveAmenazada(tc.getAeronaves(new SelectorAeronaveTrue()));
			System.out.println("testGetAmenazadas "
			+ tc.getAeronaves(s).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(amenazadas), tc.getAeronaves(s)));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testGetAmenazadas.");
		}
	}

	public void testGetAmenazasA(){
		try {
			TorreControl tc = new TorreControl();
			Aeronave a0 = new Aeronave("AUTO0", new Vector(90,90,100), 9, new Vector(100,100,100), 10);
			Aeronave a1 = new Aeronave("AUTO1", new Vector(100,410,110), 9, new Vector(100,400,110), 10);
			Aeronave a2 = new Aeronave("AUTO2", new Vector(400,100,120), 9, new Vector(400,100,120), 10);
			Aeronave a3 = new Aeronave("AUTO3", new Vector(805,0,100), 9, new Vector(800,0,110), 10);
			tc.addDeteccion(a0.getPos0(),a0.getT0());
			tc.addDeteccion(a1.getPos0(),a1.getT0());
			tc.addDeteccion(a2.getPos0(),a2.getT0());
			tc.addDeteccion(a3.getPos0(),a3.getT0());
			tc.addDeteccion(a0.getPos(),a0.getT());
			tc.addDeteccion(a1.getPos(),a1.getT());
			tc.addDeteccion(a2.getPos(),a2.getT());
			tc.addDeteccion(a3.getPos(),a3.getT());
			Aeronave []as = new Aeronave [] {a0,a1,a2,a3};
			Aeronave []amenazadas = new Aeronave [] {a0, a1};
			Aeronave []asDe0 = new Aeronave [] {a1, a2};
			Aeronave []asDe1 = new Aeronave [] {a0};
			Aeronave []asDe2 = new Aeronave [] {};
			Aeronave []asDe3 = new Aeronave [] {};
			System.out.println("testGetAmenazasA " + a0
			+ tc.getAeronaves(new SelectorAeronaveAmenazaA(a0)).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(asDe0), tc.getAeronaves(new SelectorAeronaveAmenazaA(a0))));
			System.out.println("testGetAmenazasA " + a1
			+ tc.getAeronaves(new SelectorAeronaveAmenazaA(a1)).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(asDe1), tc.getAeronaves(new SelectorAeronaveAmenazaA(a1))));
			System.out.println("testGetAmenazasA " + a2
			+ tc.getAeronaves(new SelectorAeronaveAmenazaA(a2)).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(asDe2), tc.getAeronaves(new SelectorAeronaveAmenazaA(a2))));
			System.out.println("testGetAmenazasA " + a3
			+ tc.getAeronaves(new SelectorAeronaveAmenazaA(a3)).toString()
			+ "\n***correcto=" + assertEquals(Arrays.asList(asDe3), tc.getAeronaves(new SelectorAeronaveAmenazaA(a3))));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testGetAmenazasA.");
		}
	}

	public static void main(String[] args) {
		PruebaTorreControl51 p = new PruebaTorreControl51();
		p.testAddGetAeronaves();
		p.testAddGetAeronaves2();
		p.testAddDeteccion();
		p.testGetAmenazadas();
		p.testGetAmenazasA();
	}

}

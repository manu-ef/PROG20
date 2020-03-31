package es.upm.dit.prog.practica3;

import java.util.Arrays;

public class PruebaTorreControl31 {
		
	public PruebaTorreControl31() {
	}
	
	public boolean assertArrayEquals(Aeronave[] expected, Aeronave[] obtained) {
		if (expected.length != obtained.length)
			return false;
		for (int i = 0; i < expected.length; i++)
			if (! expected[i].equals(obtained[i]))
				return false;
		return true;
	}

	public void testAddAeronave(){
		try {
			System.out.println("-----testAddAeronave-----");
			TorreControl tc = new TorreControl();
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("A0" + (i+1), new Vector(0,0,0), 0, new Vector(100*i,100*i,100*i), i);
				tc.addAeronave(as[i]);
			}
			for (int i = 0; i < as.length; i++) {
				System.out.println("testAddAeronave " + i + ":\n***correcto= " + as[i].equals(tc.getDetectado(i)));
			}
			as[0]= new Aeronave("A0bis", new Vector(0,0,0), 0, new Vector(99999,99999,99999), 99);
			tc.addAeronave(as[0]);
			for (int i = 0; i < as.length; i++) {
				System.out.println("testAddAeronave bis " + i + ":\n***correcto= " + as[i].equals(tc.getDetectado(i)));
			}
			
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddAeronave " + e);
		}
	}
	

	public void testAddGetAeronaves(){
		try {
			System.out.println("-----testAddGetAeronaves-----");
			TorreControl tc = new TorreControl();
			System.out.println("testAddGetAeronaves 0 " + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(new Aeronave[0], tc.getAeronaves()));
			
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("A0" + (i+1), new Vector(0,0,0), 0, new Vector(100*i,100*i,100*i), i);
				tc.addAeronave(as[i]);
			}
			System.out.println("testAddGetAeronaves 10 " + Arrays.toString(as) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(as, tc.getAeronaves()));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddGetAeronaves " + e);
		}
	}
 
	public void testAddGetAeronaves2(){
		try {
			System.out.println("-----testAddGetAeronaves2-----");
			TorreControl tc = new TorreControl();
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("A0" + (i+1), new Vector(0,0,0), 0, new Vector(100*i,100*i,100*i), i);
				tc.addAeronave(as[i]);
			}
			Aeronave a11 = new Aeronave("A11" + 0, new Vector(0,0,0), 0, new Vector(100*11, 100*11, 100*11), 11);
			Aeronave[] nuevo = new Aeronave[] {
					a11, as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9]
			};
			tc.addAeronave(a11);
			System.out.println("testAddAeronave 11 " + Arrays.toString(nuevo) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(nuevo, tc.getAeronaves()));
			Aeronave a12 = new Aeronave("A12" + 0, new Vector(0,0,0), 0, new Vector(100*11, 100*11, 100*11), 12);
			nuevo = new Aeronave[] {
					a11, a12, as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9]
			};
			tc.addAeronave(a12);
			System.out.println("testAddAeronave 12 " + Arrays.toString(nuevo) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(nuevo, tc.getAeronaves()));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddAeronave o testGetAeronaves " + e);
		}
	}

	public void testAddDeteccion(){
		try {
			System.out.println("-----testAddDetection-----");
			// nueva, hay sitio
			TorreControl tc = new TorreControl();
			Aeronave [] as = new Aeronave[10];
			for (int i = 0; i < as.length; i++) {
				as[i] = new Aeronave("AUTO" + i
						, new Vector(100*i,100*i,100*i), 0
						, new Vector(100*(i+1),100*(i+1),100*(i+1)), 10+i);
				tc.addDeteccion(as[i].getPos(), 10+i);
			}
			System.out.println("testAddDeteccion " + Arrays.toString(as) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(as, tc.getAeronaves()));

			// nueva, no hay sitio
			Aeronave a11 = new Aeronave("AUTO10", new Vector(1000,1000,1000), 0, new Vector(100*11, 100*11, 100*11), 20);
			tc.addDeteccion(a11.getPos(), a11.getT());
			Aeronave[] nuevo = new Aeronave[] {
					a11, as[1], as[2], as[3], as[4], as[5], as[6], as[7], as[8], as[9]
			};
			System.out.println("testAddDeteccion " + Arrays.toString(nuevo) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(nuevo, tc.getAeronaves()));

			// mueve
			for (int i = 0; i < nuevo.length; i++) {
				Vector pos = new Vector(nuevo[i].getPos().getX()+10, nuevo[i].getPos().getY()+10
						,nuevo[i].getPos().getZ()+10);
				tc.addDeteccion(pos, nuevo[i].getT() + 10);
			}
			System.out.println("testAddDeteccion " + Arrays.toString(nuevo) + Arrays.toString(tc.getAeronaves())
			+ "\n***correcto=" + assertArrayEquals(nuevo, tc.getAeronaves()));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testAddDeteccion " + e);
		}
	}

	
	public void testGetAmenazadas(){
		try {
			System.out.println("-----testGetAmenazadas-----");
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
			Aeronave[] amenazadas = new Aeronave[] {a0, a1};
			System.out.println("testGetAmenazadas "
			+ Arrays.toString(tc.getAmenazadas())
			+ "\n***correcto=" + assertArrayEquals(amenazadas, tc.getAmenazadas()));
		}
		catch (Exception e) {
			System.out.println("Fallo detectado en testGetAmenazadas " + e);
		}
	}
	
	public static void main(String[] args) {
		PruebaTorreControl31 p = new PruebaTorreControl31();
		p.testAddAeronave();
		p.testAddGetAeronaves();
		p.testAddGetAeronaves2();
		p.testAddDeteccion();
		p.testGetAmenazadas();
	}


}

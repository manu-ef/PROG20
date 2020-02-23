
package es.upm.dit.prog.laboratorio2;

public class PruebaCapituloSerie {

	public static void main(String[] args) {

		CapituloSerie p1 = new CapituloSerie("Los Simpson", 1, 10);
		CapituloSerie p2 = new CapituloSerie("Juego de Tronos", 1, 5);
		CapituloSerie p3 = p2;

		System.out.println("p1 antes = " + p1);
		System.out.println("p2 antes = " + p2);
		System.out.println("p3 antes = " + p3);

		System.out.println("p1 y p2 son el mismo objeto = " + (p1==p2) );
		System.out.println("p1 y p2 son objetos iguales = " + p1.equals(p2) );
		System.out.println("p1 y p3 son el mismo objeto = " + (p1==p3) );
		System.out.println("p1 y p3 son objetos iguales = " + p1.equals(p3) );
		System.out.println("p3 y p2 son el mismo objeto = " + (p3==p2) );
		System.out.println("p3 y p2 son objetos iguales = " + p3.equals(p2) );
	
		p1 = p2;
		p2 = null;
	
		System.out.println("p1 despues = " + p1);
		System.out.println("p2 despues = " + p2);
		System.out.println("p3 despues = " + p3);
	
		System.out.println("p1 y p2 son el mismo objeto = " + (p1==p2) );
		System.out.println("p1 y p2 son objetos iguales = " + p1.equals(p2) );
		System.out.println("p1 y p3 son el mismo objeto = " + (p1==p3) );
		System.out.println("p1 y p3 son objetos iguales = " + p1.equals(p3) );
		System.out.println("p3 y p2 son el mismo objeto = " + (p3==p2) );
		System.out.println("p3 y p2 son objetos iguales = " + p3.equals(p2) );
	}

}

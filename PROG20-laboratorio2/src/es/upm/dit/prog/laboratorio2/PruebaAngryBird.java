
package es.upm.dit.prog.laboratorio2;

import java.util.Scanner;

public class PruebaAngryBird {

	private static final double g = 9.80665;
	
	/**
	 * @param args No se usan
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca la velocidad inicial de disparo (real, cuidado con la coma decimal) = ");
		double velocidad = sc.nextDouble();
		
		System.out.print("Introduzca el angulo de disparo (real, cuidado con la coma decimal) = ");
		double angulo = sc.nextDouble();
		
		AngryBird ab = new AngryBird("Cerdito", velocidad, angulo); 
		System.out.println(ab.toString());
		
		System.out.println("Tiempo = " + ab.getTiempo());
		System.out.println("Altura maxima = "+ ab.getAltura());
		System.out.println("Distancia = " + ab.getDistancia());
		
	}
}

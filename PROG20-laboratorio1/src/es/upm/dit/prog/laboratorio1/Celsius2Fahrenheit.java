package es.upm.dit.prog.laboratorio1;

import java.util.Scanner;

public class Celsius2Fahrenheit {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escriba el valor en Celsius: ");
		
		double c = sc.nextDouble();
		double f = ((9 * c)/5) + 32;
		
		System.out.println("El valor en grados Celsius: " + c + " ºC");
		System.out.println("El valor en grados Fahrenheit: " + f + " ºF");
	}

}

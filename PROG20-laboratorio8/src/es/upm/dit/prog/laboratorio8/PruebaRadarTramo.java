package es.upm.dit.prog.laboratorio8;

import java.util.*;

public class PruebaRadarTramo {

	public static void main (String args[]) throws Exception {

		// Si este tramo (de 120 m)  se recorre en menos de 3,6 segundos, significa
		// que se ha superado el limite de velocidad de 120 km/h
		RadarTramo t = new RadarTramo("M35-km6.7", 120, 120);


		String v1 = new String ("1234 ABC");
		String v2 = new String ("5678 DEF");
		String v3 = new String ("4321 CBA");
		String v4 = new String ("8765 FED");

		System.out.println ("Entran cuatro vehiculos en el tramo");
		t.entra(v1);
		t.entra(v2);
		t.entra(v3);
		t.entra(v4);
		System.out.println ("Vehiculos en el tramo");
		for (String s : t.getVehiculosTramo())
			System.out.println(s);
		System.out.println ("Vehiculos multados");
		for (String s : t.getVehiculosMultados())
			System.out.println(s);
		//t.borraVehiculosMultados();

		System.out.println ("\nEsperamos un segundo y sale un vehiculo");
		Thread.sleep(1000);
		t.sale(v4);
		System.out.println ("Vehiculos en el tramo");
		for (String s : t.getVehiculosTramo())
			System.out.println(s);
		System.out.println ("Vehiculos multados");
		for (String s : t.getVehiculosMultados())
			System.out.println(s);
		//t.borraVehiculosMultados();

		System.out.println ("\nEsperamos otro segundo y sale otro vehiculo");
		Thread.sleep(1000);
		t.sale(v1);
		System.out.println ("Vehiculos en el tramo");
		for (String s : t.getVehiculosTramo())
			System.out.println(s);
		System.out.println ("Vehiculos multados");
		for (String s : t.getVehiculosMultados())
			System.out.println(s);
		//t.borraVehiculosMultados();

		System.out.println ("\nEsperamos dos segundos mas y salen los dos vehiculos restantes");
		Thread.sleep(2000);
		t.sale(v2);
		t.sale(v3);
		System.out.println ("Vehiculos en el tramo");
		for (String s : t.getVehiculosTramo())
			System.out.println(s);
		System.out.println ("Vehiculos multados");
		for (String s : t.getVehiculosMultados())
			System.out.println(s);
		t.borraVehiculosMultados();


	}
}

package es.upm.dit.prog.laboratorio3;

public class PruebaElementoRadiactivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElementoRadiactivo e1 = new ElementoRadiactivo("Uranio 235", 3.1229827968e-17);
		System.out.println(e1 + " " + e1.getVidaMedia());
		e1 = new ElementoRadiactivo("Uranio 238", 4.919326974e-18);
		System.out.println(e1 + " Vida media=" + e1.getVidaMedia());
		System.out.println(e1 + " Desintegrados en t= 10000 =" + e1.getProporcionDesintegrados(10000));
		
		e1 = new ElementoRadiactivo("Rubidio 87", 4.5040067466e-19);
		System.out.println(e1 + " Vida media=" + e1.getVidaMedia());
		System.out.println(e1 + " Desintegrados en t= 10000 =" + e1.getProporcionDesintegrados(10000));
		
		e1 = new ElementoRadiactivo("Calcio 41", 2.133937177e-13);
		System.out.println(e1 + " Vida media=" + e1.getVidaMedia());
		System.out.println(e1 + " Desintegrados en t= 10000 =" + e1.getProporcionDesintegrados(10000));
		
		e1 = new ElementoRadiactivo("Radio 226", 1.3720070489e-11);
		System.out.println(e1 + " Vida media=" + e1.getVidaMedia());
		System.out.println(e1 + " Desintegrados en t= 10000 =" + e1.getProporcionDesintegrados(10000));
		
		e1 = new ElementoRadiactivo("Cesio 137", 7.309462229e-10);
		System.out.println(e1 + " Vida media=" + e1.getVidaMedia());
		System.out.println(e1 + " Desintegrados en t= 10000 =" + e1.getProporcionDesintegrados(10000));
		
		
	}

}

package es.upm.dit.prog.laboratorio4;

public class PruebaComplejo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complejo[] cs = {new Complejo(0,0), new Complejo(-10, -10), new Complejo(0, -10), new Complejo(-10, 0)};

		System.out.println(cs[0] + " Opuesto=" + cs[0].opuesto() + " Conjugado= " + cs[0].conjugado());		
		System.out.println(cs[1] + " Opuesto=" + cs[1].opuesto() + " Conjugado= " + cs[1].conjugado());		
		System.out.println(cs[2] + " Opuesto=" + cs[2].opuesto() + " Conjugado= " + cs[2].conjugado());		
		System.out.println(cs[3] + " Opuesto=" + cs[3].opuesto() + " Conjugado= " + cs[3].conjugado());		
		
		System.out.println(cs[0].suma(cs[0]));
		System.out.println(cs[0].suma(cs[1]));
		System.out.println(cs[0].suma(cs[2]));
		System.out.println(cs[0].suma(cs[3]));
		System.out.println(cs[1].suma(cs[1]));
		System.out.println(cs[1].suma(cs[2]));
		System.out.println(cs[1].suma(cs[3]));
		System.out.println(cs[2].suma(cs[2]));
		System.out.println(cs[2].suma(cs[3]));
		System.out.println(cs[3].suma(cs[3]));
		
		System.out.println(cs[0].multiplica(cs[0]));
		System.out.println(cs[0].multiplica(cs[1]));
		System.out.println(cs[0].multiplica(cs[2]));
		System.out.println(cs[0].multiplica(cs[3]));
		System.out.println(cs[1].multiplica(cs[1]));
		System.out.println(cs[1].multiplica(cs[2]));
		System.out.println(cs[1].multiplica(cs[3]));
		System.out.println(cs[2].multiplica(cs[2]));
		System.out.println(cs[2].multiplica(cs[3]));
		System.out.println(cs[3].multiplica(cs[3]));
		
		/*
		System.out.println(cs[0].divide(cs[0]));
		System.out.println(cs[0].divide(cs[1]));
		System.out.println(cs[0].divide(cs[2]));
		System.out.println(cs[0].divide(cs[3]));
		System.out.println(cs[1].divide(cs[1]));
		System.out.println(cs[1].divide(cs[2]));
		System.out.println(cs[1].divide(cs[3]));
		System.out.println(cs[2].divide(cs[2]));
		System.out.println(cs[2].divide(cs[3]));
		System.out.println(cs[3].divide(cs[3]));
		
		System.out.println(cs[1].multiplica(cs[3]).divide(cs[2]));
		System.out.println(cs[1].multiplica(cs[3].divide(cs[2])));
		
		System.out.println(cs[1].divide(cs[3]).multiplica(cs[2]));
		System.out.println(cs[1].divide(cs[3].multiplica(cs[2])));
		*/
		
	}

}

package es.upm.dit.prog.laboratorio4;

public class PruebaPersonaje {

	public static void main(String[] args) {
		Personaje batman = new Personaje ("Batman", 450, 50);
		Personaje superman = new Personaje ("Superman", 500, 45);
		for (int i = 0; i < 20 && superman.estaVivo() && batman.estaVivo(); i++) {

			System.out.println ("***Lucha***");

			batman.ataca(superman.getSalud());
			superman.ataca(batman.getSalud());
			
			System.out.println (batman);
			System.out.println (superman);
			
			// espera 1 segundo a seguir la lucha
			try{
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
		
	}

}

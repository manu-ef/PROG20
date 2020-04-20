package es.upm.dit.prog.laboratorio7;

public class PruebaGeneradores {

	public static void main(String[] args) throws Exception {
		
		GeneradorNumeros [] gs = new GeneradorNumeros[10];
		gs[0] = new Constante(33);
		gs[1] = new Constante(44);
/*		gs[2] = new Contador();
		gs[3] = new Contador();
		gs[4] = new Aleatorio(6);
		gs[5] = new Aleatorio(100);
		gs[6] = new SerieAritmetica(0, 10);
		gs[7] = new SerieAritmetica(10, 100);
		gs[8] = new SerieGeometrica(1, 2);
		gs[9] = new SerieGeometrica(10, 10);
*/		
		
				
		for (int i = 0; i < gs.length; i++) {
			if (gs[i] == null)
				continue;
			System.out.println(gs[i].getNombreGenerador());
			System.out.println(gs[i].getSiguienteNumero());
			System.out.println(gs[i].getSiguienteNumero());
			System.out.println(gs[i].getSiguienteNumero());
			System.out.println(gs[i].getUltimoNumero());
		}
				
				
	}

}

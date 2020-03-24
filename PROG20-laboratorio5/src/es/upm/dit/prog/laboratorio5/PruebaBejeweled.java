package es.upm.dit.prog.laboratorio5;

public class PruebaBejeweled {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		int[][] tablero = {{1,2,3,3,3,5,2,1},
							{1,1,1,1,1,3,4,5},
							{2,3,4,5,6,7,8,9},
							{1,2,2,2,3,1,2,3},
							{4,4,4,4,4,4,4,4},
							{5,3,4,3,4,2,2,2},
							{1,5,4,3,2,1,3,2},
							{2,3,4,4,4,4,4,4}
							};
		Bejeweled b = new Bejeweled (tablero);
		System.out.println(b);
		b.actualizar();
		System.out.println(b);
		
	}

}

package es.upm.dit.prog.laboratorio3;

public class DiaSemana {
	
	private int getM (int a, int m) {
		int[] mesRegular = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		int[] mesBisiesto = {0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
		
		if ((a%4 == 0) && ((a%100 != 0) || (a%400 == 0) )) {
			return mesBisiesto[m-1];
		} else {
			return mesRegular[m-1];
		}
	}
	
	public String getDiaSemana (int anno, int mes, int dia) {
		String[] diaSemana= {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves","Viernes", "Sabado"};
		int annoAnterior = anno - 1;
		int d = (annoAnterior%7 + ((annoAnterior)/4 - 3 * ((annoAnterior/100) + 1)/4)%7 + getM(anno, mes) + dia%7)%7;
		
		return diaSemana[d];
	}
}

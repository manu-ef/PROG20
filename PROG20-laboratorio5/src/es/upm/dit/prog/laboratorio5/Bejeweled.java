/**
 *
 */
package es.upm.dit.prog.laboratorio5;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 
 * @version 
 */
public class Bejeweled {

	private int[][] tablero;
	private final static int MAXGEMASDISTINTAS = 5;
	private Random r;
	
	public Bejeweled(int [][] tablero) {
		this.tablero = tablero;
		this.r = new Random();
	}
	
	@Override
	public String toString() {
		String res = "---------------------\n";
		for (int i = tablero.length-1; i >= 0; i --) {
			for (int j = 0; j < tablero[i].length; j++) {
				res += tablero[i][j]+ " ";
			}
			res += "\n";
		}
		return res + "---------------------\n";
	}

	public void copiarFila(int from, int to) {
		for (int i = 0; i < this.tablero[from].length; i ++) {
			this.tablero[to][i] = this.tablero[from][i];
		}
	}
	
	public void addUltimaFila() {
		for (int i = 0; i < this.tablero[this.tablero.length -1].length; i ++) {
			this.tablero[this.tablero.length -1][i] = this.r.nextInt(MAXGEMASDISTINTAS-1) +1;
		}
	}
	
	public int maxIguales (int fila) throws Exception {
		if((fila < 0) || (fila >= this.tablero.length)) {
			throw new Exception("Error en la fila");
		}
		int max = 1;
		int repetidos = 1;
		for(int i = 1; i < this.tablero[fila].length; i++) {
			if(this.tablero[fila][i] != this.tablero[fila][i-1]) {
				repetidos = 1;
			} else {
				repetidos++;
				if (repetidos > max) {
					max = repetidos;
				}
				// System.out.println("Repetidos " + repetidos);
			}
		}
		return max;
	}

	public void eliminarFila(int fila) throws Exception {
		// Comprobar fila
		if((fila < 0) || (fila >= this.tablero.length)) {
			throw new Exception("Error en la fila");
		}
	
		// Compactar las filas anteriores
		for(int i = fila + 1; i < this.tablero.length; i++) {
			this.copiarFila(i, i-1);
		}
		// addUltimaFila mientras sea necesario
		this.addUltimaFila();
		while (this.maxIguales(this.tablero.length-1) >= 3) {
			this.addUltimaFila();
		}
	}
	
	
	public void actualizar() throws Exception {
		for (int i = 0; i < this.tablero.length; i++) {
			while (this.maxIguales(i) >= 3) {
				this.eliminarFila(i);
			}
		}	
	}
	
	
	
	/**
	 * getter que devuelve el numero de filas del tablero
	 * @return numero de filas del tablero
	 */
	public int getFilasTablero(){
		return tablero.length;
	}

	/**
	 * getter que devuelve el numero de columnas del tablero
	 * @return numero de columnas del tablero
	 */
	public int getColumnasTablero(){
		return tablero[0].length;
	}

}

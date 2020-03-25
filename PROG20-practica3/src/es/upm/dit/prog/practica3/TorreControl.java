package es.upm.dit.prog.practica3;

import java.util.Arrays;

public class TorreControl {
	
	// Constantes
	private static final int n = 10;
	
	// Definicion de variables
	private Aeronave[] detectados;
	private int totalDetectadas;
	
	// Constructor
	public TorreControl() {
		this.detectados[n] = null;
		this.totalDetectadas = 0;
	}
	
	// Metodo toString
	@Override
	public String toString() {
		return "TorreControl [detectados=" + Arrays.toString(detectados) + ", totalDetectadas=" + totalDetectadas + "]";
	}
	
	// Metodo addAeronave
	public void addAeronave(Aeronave ae) {
		if (ae != null) {
			for (int i = 0; i < this.detectados.length; i++) {
				int posicionAntigua = 0;
				Aeronave aeronaveAntigua = this.detectados[posicionAntigua];
				if (this.detectados[i] == null) {
					this.detectados[i] = ae;
				} else {
					if (this.detectados[i].getT() < aeronaveAntigua.getT()) {
						aeronaveAntigua = this.detectados[i];
						posicionAntigua = i;
					}
				this.detectados[posicionAntigua] = ae;
				}
			}
		}
	}
	
	// Metodo getDetectado
	public Aeronave getDetectado(int i) {
		return this.detectados[i];
	}
	
	
}

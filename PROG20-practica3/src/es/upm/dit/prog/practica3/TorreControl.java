package es.upm.dit.prog.practica3;

import java.util.Arrays;

public class TorreControl {
	
	// Constantes
	private final int N = 10;
	
	// Definicion de variables
	private Aeronave[] detectados;
	private int totalDetectadas;
	
	// Constructor
	public TorreControl() {
		this.detectados = new Aeronave[N];
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
			for (int i = 0; i < this.detectados.length;i++) {
				if (this.detectados[i] == null) {
					this.detectados[i] = ae;
					return;
				} else {
					int n = 0;
					double max = this.detectados[0].getT();
					for(int j = 0; j < this.detectados.length; j++) {
						if (this.detectados[j] != null && max < this.detectados[j].getT()) {
							n = j;
						}
					}
					this.detectados[n] = ae;
				}
			}
		}
	}
	
	// Metodo getDetectado
	public Aeronave getDetectado(int i) {
		return this.detectados[i];
	}
	
	
}

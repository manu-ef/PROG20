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
				}
			}
			int n = 0;
			double max = this.detectados[0].getT();
			for(int j = 0; j < this.detectados.length; j++) {
				if ((this.detectados[j] != null) && (max > this.detectados[j].getT())) {
					n = j;
					max = this.detectados[j].getT();
				}
			}
			this.detectados[n] = ae;
			return;
		} else {
			return;
		}
	}
	
	// Metodo getDetectado
	public Aeronave getDetectado(int i) {
		return this.detectados[i];
	}
	
	// Metodo getAeronaves
	public Aeronave[] getAeronaves() {
		// Contamos el numero de celdas distintas de null
		int celdas = 0;
		for (int i = 0; i < this.detectados.length; i++) {
			if (this.detectados[i] != null) {
				celdas++;
			}
		}
		// Creamos un array con las celdas distintas de null
		Aeronave[] aeronaves = new Aeronave[celdas];
		celdas = 0;
		// Recorremos de nuevo this.array para copiar las celdas distintas de null al array
		for (int j = 0; j < this.detectados.length; j++) {
			if (this.detectados[j] != null) {
				aeronaves[celdas] = this.detectados[j];
				celdas++;
			}
		}
		// Devolvemos el array
		Aeronave[] aeronavesNull = new Aeronave [0];
		if (this.detectados == null) {
			return aeronavesNull;
		} else {
			return aeronaves;
		}
	}
	
	// Metodo getCompatibles
	public Aeronave[] getCompatibles(Vector pos, double t) {
		int celdas = 0;
		for (int i = 0; i < this.detectados.length; i++) {
			if (this.detectados[i] != null) {
				celdas++;
			}
		}
		Aeronave[] aeronaves = new Aeronave[celdas];
		celdas = 0;
		for (int j = 0; j < this.detectados.length; j++) {
			if (this.detectados[j] != null && this.detectados[j].compatibleCon(pos, t)) {
				aeronaves[celdas] = this.detectados[j];
				celdas++;
			}
		}
		Aeronave[] aeronavesNull = new Aeronave [0];
		if (this.detectados == null) {
			return aeronavesNull;
		} else {
			return aeronaves;
		}
	}
	
	// Metodo addDeteccion
	public void addDeteccion(Vector pos, double t) {
		
	}
	
	// Metodo getAmenazadas
	public Aeronave[] getAmenazadas() {
		Aeronave[] ae = new Aeronave[0];
		return ae;
	}
	
}

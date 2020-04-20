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
		Aeronave[] aeronavesNull = new Aeronave[0];
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
			if (this.detectados[i] != null && this.detectados[i].compatibleCon(pos, t)) {
				celdas++;
			}
		}
		Aeronave[] compatibles = new Aeronave[celdas];
		celdas = 0;
		for (int j = 0; j < this.detectados.length; j++) {
			if (this.detectados[j] != null && this.detectados[j].compatibleCon(pos, t)) {
				compatibles[celdas] = this.detectados[j];
				celdas++;
			}
		}
		Aeronave[] aeronavesNull = new Aeronave[0];
		if (this.detectados == null) {
			return aeronavesNull;
		} else {
			return compatibles;
		}
	}
	
	// Metodo addDeteccion
	public void addDeteccion(Vector pos, double t) {
		if (this.getCompatibles(pos, t).length > 0) {
			getCompatibles(pos, t)[0].mover(pos, t);
		} else {
			Aeronave auto = new Aeronave ("AUTO" + this.totalDetectadas, pos, t, pos, t);
			this.addAeronave(auto);
			this.totalDetectadas++;
		}
	}
	
	// Metodo amenaza
	private boolean amenazada(Aeronave ae) {
		boolean amenazada = false;
		for (int i = 0; i < this.detectados.length; i++) {
			if (this.detectados[i] != null && amenazada == false) {
				amenazada = ae.amenazadaPor(this.detectados[i]);
			}
		}
		return amenazada;
	}
	
	// Metodo getAmenazadas
	public Aeronave[] getAmenazadas() {
		int celdas = 0;
		for (int i = 0; i < this.detectados.length; i++) {
			if (this.detectados[i] != null && this.amenazada(this.detectados[i])) {
				celdas++;
			}
		}
		Aeronave[] amenazadas = new Aeronave[celdas];
		celdas = 0;
		for (int j = 0; j < this.detectados.length; j++) {
			if (this.detectados[j] != null && this.amenazada(this.detectados[j])) {
				amenazadas[celdas] = this.detectados[j];
				celdas++;
			}
		}
		Aeronave[] aeronavesNull = new Aeronave[0];
		if (this.detectados == null) {
			return aeronavesNull;
		} else {
			return amenazadas;
		}
	}
	
}

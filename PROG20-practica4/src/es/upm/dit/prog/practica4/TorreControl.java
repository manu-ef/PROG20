package es.upm.dit.prog.practica4;

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
	public Aeronave[] getAeronaves(SelectorAeronave s) {
		Aeronave[] aeronavesNull = new Aeronave[0];
		if (s == null) {
			return aeronavesNull;
		} else {
			int celdas = 0;
			for(int i = 0; i < this.detectados.length; i++) {
				if(s.seleccionar(this.detectados[i]) == true) {
					celdas++;
				}
			}
			Aeronave[] aeronaves = new Aeronave[celdas];
			celdas = 0;
			for(int i = 0; i < this.detectados.length; i++) {
				if(s.seleccionar(this.detectados[i]) == true) {
					aeronaves[celdas] = this.detectados[i];
					celdas++;
				}
			}
			return aeronaves;
		}
		
	}
	
	// Metodo addDeteccion
	public void addDeteccion(Vector pos, double t) {
		SelectorAeronaveCompatible s = new SelectorAeronaveCompatible(pos, t);
		if (this.getAeronaves(s).length > 0) {
			this.getAeronaves(s)[0].mover(pos, t);
		} else {
			Aeronave auto = new Aeronave ("AUTO" + this.totalDetectadas, pos, t, pos, t);
			this.addAeronave(auto);
			this.totalDetectadas++;
		}
	}
	
/*	// Metodo amenaza
	private boolean amenazada(Aeronave ae) {
		boolean amenazada = false;
		for (int i = 0; i < this.detectados.length; i++) {
			if (this.detectados[i] != null && this.detectados[i] != ae && amenazada == false) {
				amenazada = ae.amenazadaPor(this.detectados[i]);
			}
		}
		return amenazada;
	}
*/	
	// Metodo accesor
	public Aeronave[] getDetectados() {
		return this.detectados;
	}
}

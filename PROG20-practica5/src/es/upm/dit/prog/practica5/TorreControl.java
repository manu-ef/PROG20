package es.upm.dit.prog.practica5;

import java.util.*;

public class TorreControl {
	
	private List<Aeronave> detectados;
	private int totalDetectadas;
	
	public TorreControl() {
		this.detectados = new ArrayList<Aeronave>();
		this.totalDetectadas = 0;
	}
	
	public List<Aeronave> getDetectados(){
		return this.detectados;
	}

	@Override
	public String toString() {
		return "TorreControl [detectados=" + detectados + ", totalDetectadas=" + totalDetectadas + "]";
	}
	
	public void addAeronave(Aeronave ae) {
		this.detectados.add(ae);
	}
	
	public List<Aeronave> getAeronaves(SelectorAeronave s){
		List<Aeronave> aeronaves = new ArrayList<Aeronave>();
		for (int i = 0; i < this.detectados.size(); i++) {
			if (s.seleccionar(this.detectados.get(i))) {
				aeronaves.add(this.detectados.get(i));
			}
		}
		return aeronaves;
	}
	
	public void addDeteccion(Vector v, double t) {
		SelectorAeronaveCompatible s = new SelectorAeronaveCompatible(v, t);
		if (this.getAeronaves(s).size() > 0) {
			this.getAeronaves(s).get(0).mover(v, t);
		} else {
			Aeronave auto = new Aeronave ("AUTO" + this.totalDetectadas, v, t, v, t);
			this.addAeronave(auto);
			this.totalDetectadas++;
		}
	}
}

package es.upm.dit.prog.practica4;

public class SelectorAeronaveCompatible implements SelectorAeronave {

	private Vector pos;
	private double t;
	
	public SelectorAeronaveCompatible(Vector pos, double t) {
		this.pos = pos;
		this.t = t;
	}
	
	public boolean seleccionar(Aeronave ae) {
		if (ae != null && ae.compatibleCon(this.pos, this.t)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

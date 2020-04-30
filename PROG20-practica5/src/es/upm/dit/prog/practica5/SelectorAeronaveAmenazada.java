package es.upm.dit.prog.practica5;

import java.util.*;

public class SelectorAeronaveAmenazada implements SelectorAeronave {

	private List<Aeronave> aeronaves;
	
	public SelectorAeronaveAmenazada(List<Aeronave> as) {
		this.aeronaves = new ArrayList<Aeronave>(as);
	}
	
	public boolean seleccionar(Aeronave otra) {
		if (otra != null) {
			boolean ifTrue = false;
			for (int i = 0; i < this.aeronaves.size(); i++) {
				if(otra.amenazadaPor(this.aeronaves.get(i)) && !this.aeronaves.get(i).equals(otra)) {
					ifTrue = true;
					break;
				} else {
					i++;
				}
			}
			return ifTrue;
		} else {
			return false;
		}
	}

}

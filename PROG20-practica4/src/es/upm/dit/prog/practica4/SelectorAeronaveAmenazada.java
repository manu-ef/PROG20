package es.upm.dit.prog.practica4;

public class SelectorAeronaveAmenazada implements SelectorAeronave {

	private Aeronave[] aeronaves;
	
	public SelectorAeronaveAmenazada(Aeronave[] as) {
		this.aeronaves = as;
	}
	
	public boolean seleccionar(Aeronave otra) {
		if (otra != null) {
			boolean ifTrue = false;
			for (int i = 0; i < this.aeronaves.length; i++) {
				if(otra.amenazadaPor(this.aeronaves[i]) && !this.aeronaves[i].equals(otra)) {
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

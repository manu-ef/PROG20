package es.upm.dit.prog.practica5;

public class SelectorAeronaveAmenazaA implements SelectorAeronave {

	private Aeronave a;
	public SelectorAeronaveAmenazaA(Aeronave a) {
		this.a = a;
	}
	
	public boolean seleccionar(Aeronave otra) {
		if(otra != null && !this.a.equals(otra) && this.a.amenazadaPor(otra) == true) {
			return true;
		} else {
			return false;
		}
	}

}

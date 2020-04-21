package es.upm.dit.prog.practica4;

public class SelectorAeronaveTrue implements SelectorAeronave {

	public boolean seleccionar(Aeronave ae) {
		return (ae != null);
	}

}

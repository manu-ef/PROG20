package es.upm.dit.prog.laboratorio8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RadarTramo {
	
	private String nombre;
	private double length;
	private double vmax;
	private Map <String, Long> vehiculos;
	private ArrayList <String> multados;
	
	public RadarTramo(String nombre, double length, double vmax) {
		this.nombre = nombre;
		this.length = length;
		this.vmax = vmax;
		this.vehiculos = new HashMap <String, Long>();
		this.multados = new ArrayList <String>();
	}
	
	public void entra(String v) {
		this.vehiculos.put(v, System.currentTimeMillis());
	}
	
	public Collection <String> getVehiculosTramo() {
		return this.vehiculos.keySet();
	}
	
	public void sale(String v) {
		if (!this.vehiculos.containsKey(v)) // si no esta, hemos terminado
			return;
		long tActual = System.currentTimeMillis();
		long tInicial = this.vehiculos.get(v);
		this.vehiculos.remove(v);
		
		double vel = this.length/(tActual-tInicial); // m/ms
		double limite = this.vmax/(60*60); // limite en m/ms
		if (vel > limite) {
			this.multados.add(v);
		}
	}
	
	public Collection <String> getVehiculosMultados() {
		ArrayList <String> r = new ArrayList<String>();
		r.addAll(multados);
		return r;
	}
}

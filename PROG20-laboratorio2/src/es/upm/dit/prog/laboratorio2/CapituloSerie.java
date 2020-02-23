package es.upm.dit.prog.laboratorio2;

public class CapituloSerie {

	private String serie;
	private int temporada;
	private int episodio;
	
	public CapituloSerie (String serie, int temporada, int episodio) {
		this.serie = serie;
		this.temporada = temporada;
		this.episodio = episodio;
	}
	
	public String toString() {
		return "Serie: " + this.serie + " temporada: " + this.temporada + " episodio: " + this.episodio + ".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + episodio;
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + temporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CapituloSerie other = (CapituloSerie) obj;
		if (episodio != other.episodio)
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (temporada != other.temporada)
			return false;
		return true;
	}
	
	
}

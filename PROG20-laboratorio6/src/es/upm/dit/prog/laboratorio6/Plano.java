
package es.upm.dit.prog.laboratorio6;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Clase usada para representar el plano de una ciudad.
 *
 * Se indica la situacion y la altura de sus edificios.
 *
 * @author Mi Nombre
 *
 * @version 12/04/2018 11:30
 */
public class Plano {

	/**
	 * El nombre de la Ciudad
	 */
	private String nombre;

	/**
	 * Altura de los edificios existentes en la ciudad.
	 *
	 * Este array almacena la altura de los edificios. Ejemplo: datos[2][3] es la
	 * altura del edificio situado en x=2, y=3.
	 *
	 * El primer indice esta asociado al eje X y el segundo indice esta asociado al
	 * eje Y.
	 *
	 * A la hora de pintar y escribir el mapa, el centro de coordenadas sera la
	 * esquina superior izquierda, con el eje X avanzando hacia la derecha en
	 * horizontal, y el eje Y avanzando hacia abajo en vertical.
	 */
	private int[][] alturas;

	/**
	 * Crea una ciudad del tamano indicado y sin edificios.
	 *
	 * @param nombre
	 *            Nombre de la ciudad.
	 * @param anchura
	 *            Anchura del mapa de la ciudad, o tamano en el eje X.
	 * @param profundidad
	 *            Profundidad del plano de la ciudad, o tamano en el eje Y.
	 */
	public Plano(String nombre, int anchura, int profundidad) {
		this.nombre = nombre;
		this.alturas = new int[anchura][profundidad];
	}

	/**
	 * Devuelve el nombre de la ciudad.
	 *
	 * @return Devuelve el nombre de la ciudad.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve un array de dos dimensiones con las alturas de los edificios.
	 *
	 * @return Devuelve un array con las alturas de los edificios.
	 */
	public int[][] getAlturas() {
		int[][] copia = new int[alturas.length][];
		for (int x = 0; x < alturas.length; x++) {
			copia[x] = new int[alturas[x].length];
			for (int y = 0; y < alturas[x].length; y++) {
				copia[x][y] = alturas[x][y];
			}
		}
		return copia;
	}

	
	public void setAlturas(int[][] alturas) throws Exception {
		if (alturas == null)
			throw new Exception ("setAlturas: parametro nulo");
		if ((alturas.length<1) || (alturas[0].length <1))
			throw new Exception ("setAlturas: tamano no adecuado");
		for (int i=0; i < alturas.length; i++)
			if (alturas[i].length!= alturas[0].length)
				throw new Exception ("setAlturas: matriz no rectangular");
		for (int i=0; i < alturas.length; i++)
			for (int j=0; j < alturas[i].length; j++)
				if (alturas[i][j] < 0)
					throw new Exception ("setAlturas: altura negativa");
		
		this.alturas = new int[alturas.length][alturas[0].length];
		for (int i=0; i < alturas.length; i++)
			for (int j=0; j < alturas[i].length; j++)
				this.alturas[i][j] = alturas[i][j];
	}
	
	/**
	 * Destruye todos los edificios existentes en la ciudad y crea edificios nuevos
	 * con alturas aleatorias.
	 *
	 * @param semilla
	 *            Este valor indica que ciudad desea construirse. Para cada valor de
	 *            la semilla se construira una ciudad diferente.
	 */
	public void creaCiudad(long semilla) {

		Random r = new Random(semilla);
		for (int x = 0; x < alturas.length; x++) {
			for (int y = 0; y < alturas[x].length; y++) {
				if (r.nextFloat() > 0.3) { // posibilidad de crear un edificio
					alturas[x][y] = r.nextInt(25);
				} else { // posibilidad de no construir
					alturas[x][y] = 0;
				}
			}
		}
	}

	/**
	 * Destruye todos los edificios existentes en la ciudad y crea aleatoriamente
	 * edificios nuevos. Cada vez que se llame a este metodo se crea una ciudad
	 * totalmente diferente.
	 */
	public void creaCiudad() {
		creaCiudad(new Date().getTime());
	}

	/**
	 * Determina si la coordenada (x,y) dada esta dentro de la ciudad.
	 *
	 * @param x
	 *            Coordenada X.
	 * @param y
	 *            Coordenada Y.
	 *
	 * @return Devuelve true si (x,y) esta dentro de la ciudad.
	 */
	public boolean dentro(int x, int y) {
		return false;
	}

	/**
	 * Devuelve la altura del edificio situado en la posicion dada.
	 *
	 * @param x
	 *            Coordenada X de la posicion del edificio.
	 * @param y
	 *            Coordenada Y de la posicion del edificio.
	 *
	 * @return Devuelve la altura del edificio situado en la posicion dada. Si la
	 *         posicion (x,y) esta situada fuera del plano, devuelve cero.
	 */
	public int getAltura(int x, int y) {
		return -1;
	}

	/**
	 * Consulta si en la posicion dada hay un edificio.
	 *
	 * @param x
	 *            Coordenada X de la posicion a consultar.
	 * @param y
	 *            Coordenada Y de la posicion a consultar.
	 *
	 * @return Devuelve false si la posicion (x,y) esta fuera del mapa, o si la
	 *         altura en esa posicion es 0. Devuelve true si la altura en esa
	 *         posicion es distinta de cero.
	 *
	 */
	public boolean hayEdificio(int x, int y) {
		return false;
	}

	/**
	 * Construye un edificio en la posicion (x,y) dada. La altura del edificio debe
	 * ser altura.
	 *
	 * Si en la posicion dada ya hay un edificio, este se destruye, y luego se
	 * construye el nuevo edificio.
	 *
	 * @param x
	 *            Coordenada X de la posicion donde construir el edificio.
	 * @param y
	 *            Coordenada Y de la posicion donde construir el edificio.
	 * @param altura
	 *            Altura del edificio a construir.
	 *
	 * @throws Exception
	 *             Lanza una excepcion si la posicion (x,y) dada esta fuera de los
	 *             limites de la ciudad. Tambien lanza una excepcion si la altura
	 *             dada es negativa.
	 */
	public void construyeEdificio(int x, int y, int altura) throws Exception {
		return;
	}

	/**
	 * Destruye el edificio situado en la posicion dada. Si en la posicion dada no
	 * hay edificio, no hay que hacer nada.
	 *
	 * @param x
	 *            Coordenada X de la posicion del edificio.
	 * @param y
	 *            Coordenada Y de la posicion del edificio.
	 *
	 * @throws Exception
	 *             Lanza una excepcion si la posicion (x,y) dada esta fuera de los
	 *             limites de la ciudad.
	 */
	public void destruyeEdificio(int x, int y) throws Exception {
		return;
	}

	/**
	 * Explora el mapa buscando si existe algun edificio con la altura dada.
	 *
	 * @return Devuelve true si en el plano existe algun edificio con altura igual a
	 *         la dada. Si no existe ningun edificio de esa altura, entonces
	 *         devuelve false.
	 *
	 */
	public boolean existeEdificio(int altura) {
		for (int x = 0; x < alturas.length; x++) {
			for (int y = 0; y < alturas[x].length; y++) {
				if (alturas[x][y] == altura)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Cuenta el numero de edificios existentes en la ciudad.
	 *
	 * @return El numero de edificios existentes en la ciudad.
	 */
	public int cuentaEdificios() {
		return -1;
	}

	/**
	 * Busca el edificio mas alto y devuelve su altura.
	 *
	 * @return La altura del edificio mas alto de la ciudad. Si no hay edificios,
	 *         devuelve 0.
	 */
	public int alturaMaxima() {
		return -1;
	}

	/**
	 * Busca el edificio mas bajo y devuelve su altura.
	 *
	 * @return La altura del edificio mas bajo de la ciudad. Si no hay edificios,
	 *         devuelve 0.
	 */
	public int alturaMinima() {
		return -1;
	}

	/**
	 * Calcula la altura media de los edificios de la ciudad.
	 *
	 * @return La altura media de los edificios de la ciudad.
	 */
	public double alturaMedia() {
		return -1.0;
	}


	/**
	 * Recorta los edificio altos. A todos los edificios que superen la altura dada,
	 * se les cortaran los pisos superiores para que no superen la altura maxima
	 * indicada.
	 *
	 * @param altura
	 *            Altura maxima que no pueden superar los edificios. Si la altura
	 *            dada es negativa, entonces se limitara la altura a cero.
	 *
	 * @return Devuelve el numero de edificios que han sido recortados para
	 *         ajustarse a la altuma maxima indicada.
	 */
	public int limitaAltura(int altura) {
		return -1;
	}
	
	/**
	 * Cuenta el numero de edificios existentes en la ciudad que no esten pegados a
	 * otro edificio.
	 *
	 * @return El numero de edificios existentes en la ciudad que no esten pegados a
	 *         otro edificio.
	 */
	public int cuentaEdificiosAislados() {
		return -1;
	}

	/**
	 * Crea una carretera desde la posicion (x0,y0) hasta la posicion (x1,y1). Se
	 * destruiran todos los edificios situados entre estos dos puntos.
	 *
	 * @param x0
	 *            Coordenada X de la posicion donde empieza la carretera.
	 * @param y0
	 *            Coordenada Y de la posicion donde empieza la carretera.
	 * @param x1
	 *            Coordenada X de la posicion donde termina la carretera.
	 * @param y1
	 *            Coordenada X de la posicion donde termina la carretera.
	 *
	 * @throws Exception
	 *             Se lanza una excepcion si las coordenada dadas estan situadas
	 *             fuera de la ciudad.
	 */
	public void creaCarretera(int x0, int y0, int x1, int y1) throws Exception {
		return;
	}

	/**
	 * Devuelve un String describiendo el plano.
	 *
	 * @return Devuelve un String describiendo el plano.
	 */
	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("[ " + nombre + ": ");

		for (int y = 0; y < alturas[0].length; y++) {
			for (int x = 0; x < alturas.length; x++)
				sb.append(alturas[x][y] + " ");
			sb.append(" / ");
		}
		sb.append("]");

		return sb.toString();
	}

	/**
	 * Escribe por pantalla el plano de la ciudad, indicando la altura de los
	 * edificios.
	 *
	 * Escribe el mapa situando en origen de coordenadas arriba y a la izquierda. El
	 * eje X es el horizontal y el eje Y es el vertical.
	 *
	 * @param titulo
	 *            Titulo para identificar el plano que se ha escrito
	 */
	public void escribe(String titulo) {

		System.out.println(nombre + " - " + titulo);

		// Borde superior
		for (int x = 0; x < alturas.length; x++)
			System.out.print("---");
		System.out.println("-----> Eje X");

		for (int y = 0; y < alturas[0].length; y++) {
			System.out.print("|");
			for (int x = 0; x < alturas.length; x++) {
				System.out.printf("%3d", alturas[x][y]);
			}
			System.out.println(" |");
		}

		// borde inferior
		for (int x = 0; x < alturas.length; x++)
			System.out.print("---");
		System.out.println("---");
		System.out.println("|\nV Eje Y");
	}

	/**
	 * Escribe por pantalla las estadisticas de los edificios.
	 */
	public void estadisticas() {

		System.out.println("Estadisticas de " + nombre + ":");
		System.out.println("          superficie = " + alturas.length * alturas[0].length);
		System.out.println("        altura media = " + alturaMedia());
		System.out.println("       altura minima = " + alturaMinima());
		System.out.println("       altura maxima = " + alturaMaxima());
		System.out.println(" numero de edificios = " + cuentaEdificios());
		System.out.println("  edificios aislados = " + cuentaEdificiosAislados());
	}

	/**
	 * @param args
	 *            Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Plano p = new Plano("PROG 2019", 20, 15);
				p.creaCiudad(1);

				p.escribe("Ciudad original");
				new PlanoGrafico(p, "Ciudad original");
				p.estadisticas();

				try {
					// TODO: ANADIR AQUI LAS LLAMADAS A LOS METODOS A PROBAR

					System.out.println("*************** Dentro (3,4) = " + p.dentro(3, 4));
					System.out.println("*************** Dentro (33,4) = " + p.dentro(33, 4));
					p.limitaAltura(15);
					p.construyeEdificio(2, 0, 20);
					p.destruyeEdificio(0, 1);
					p.creaCarretera(0, 0, 19, 14);

					p.creaCarretera(0, 14, 19, 0);
					p.creaCarretera(10, 14, 10, 0);
					p.creaCarretera(12, 14, 12, 0);

				} catch (Exception exc) {
					System.err.println("Se ha producido un error: " + exc.getMessage());
					System.exit(1);
				}

				p.escribe("Ciudad remodelada");
				new PlanoGrafico(p, "Ciudad remodelada");
				p.estadisticas();
			}
		});

	}
}

/**
 * Crea una ventana donde dibuja un mapa y sus edificios.
 */
class PlanoGrafico extends JFrame {

	static final long serialVersionUID = 1L;

	final static Color colorCesped = new Color(0, 130, 0);
	final static Color colorPared = new Color(225, 190, 110);
	final static Color colorParedSombra = colorPared.darker();
	final static Color colorParedSoleada = colorPared.brighter();
	final static Color colorSuelo = Color.lightGray.brighter();
	final static Color colorBorde = Color.lightGray;

	// Copia del array de alturas del Plano.
	private int[][] datos;

	/**
	 * Construye un objeto PlanoGrfico para dibujar el plano pasado como parametro.
	 *
	 * @param p
	 *            Referencia alplano a dibujar.
	 */
	public PlanoGrafico(Plano p, String title) {

		datos = p.getAlturas();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(300, 300));

		setBackground(new Color(220, 255, 255));

		getContentPane().add("North", new JLabel(title + " - " + p.getNombre(), SwingConstants.CENTER));

		getContentPane().add("Center", new JPanel() {

			static final long serialVersionUID = 1L;

			double factor_profundidad = 2;
			double factor_altura = 2;

			private Point proyeccion2D(double x, double y, double z) {

				double escalax = (double) (getWidth() - 30) / (datos[0].length / factor_profundidad + datos.length);

				double escalay = (double) (getHeight() - 150) / (datos[0].length / factor_profundidad);

				int vx = 10 + (int) ((x - y / factor_profundidad + datos[0].length / factor_profundidad) * escalax);
				int vy = getHeight() - 20
						+ (int) ((y / factor_profundidad - datos[0].length / factor_profundidad) * escalay
								- z * factor_altura);

				return new Point(vx, vy);
			}

			private void pintaTerreno(Graphics g) {

				g.setColor(colorBorde);
				g.setFont(g.getFont().deriveFont(10f));

				Point p;

				// Eje de Coordenadas X
				for (int x = 0; x < datos.length; x++) {
					p = proyeccion2D(x + .2, 0, 0);
					g.drawString("" + x, p.x, p.y - 5);
				}
				p = proyeccion2D(datos.length, 0, 0);
				g.drawString("X", p.x + 5, p.y + 5);

				// Eje de Coordenadas Y
				for (int y = 0; y < datos[0].length; y++) {
					p = proyeccion2D(0, y + 0.5, 0);
					g.drawString("" + y, p.x - 12, p.y);
				}
				p = proyeccion2D(0, datos[0].length, 0);
				g.drawString("Y", p.x, p.y + 15);
			}

			private void pintaEdificios(Graphics g) {

				for (int x = 0; x < datos.length; x++) {
					for (int y = 0; y < datos[x].length; y++) {

						if (datos[x][y] > 0) {
							pintaSuelo(g, x, y, colorCesped);
							pintaEdificio(g, x, y, datos[x][y]);
						} else {
							pintaSuelo(g, x, y, colorSuelo);
						}
					}
				}
			}

			private void pintaEdificio(Graphics g, int x, int y, int z) {

				double margin = 0.2;

				// Esquinas del edificio
				Point p1 = proyeccion2D(x + margin, y + 1 - margin, 0);
				Point p2 = proyeccion2D(x + margin, y + 1 - margin, z);
				Point p3 = proyeccion2D(x + 1 - margin, y + 1 - margin, z);
				Point p4 = proyeccion2D(x + 1 - margin, y + 1 - margin, 0);
				Point p5 = proyeccion2D(x + margin, y + margin, z);
				Point p6 = proyeccion2D(x + 1 - margin, y + margin, z);
				Point p7 = proyeccion2D(x + 1 - margin, y + margin, 0);

				// pared frontal
				Polygon pol = new Polygon();
				pol.addPoint(p1.x, p1.y);
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(colorPared);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// Techo
				pol = new Polygon();
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p6.x, p6.y);
				pol.addPoint(p5.x, p5.y);

				g.setColor(colorParedSoleada);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// pared lateral
				pol = new Polygon();
				pol.addPoint(p7.x, p7.y);
				pol.addPoint(p6.x, p6.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(colorParedSombra);
				g.fillPolygon(pol);
				g.setColor(Color.black);
				g.drawPolygon(pol);

				// altura
				g.drawString("" + z, p2.x + 5, p2.y - 5);
			}

			private void pintaSuelo(Graphics g, int x, int y, Color color) {

				// Esquinas del suelo
				Point p1 = proyeccion2D(x, y, 0);
				Point p2 = proyeccion2D(x, y + 1, 0);
				Point p3 = proyeccion2D(x + 1, y + 1, 0);
				Point p4 = proyeccion2D(x + 1, y, 0);

				// Poligono de suelo
				Polygon pol = new Polygon();
				pol.addPoint(p1.x, p1.y);
				pol.addPoint(p2.x, p2.y);
				pol.addPoint(p3.x, p3.y);
				pol.addPoint(p4.x, p4.y);

				g.setColor(color);
				g.fillPolygon(pol);
				g.setColor(colorBorde);
				g.drawPolygon(pol);
			}

			protected void paintComponent(Graphics g) {
				pintaTerreno(g);
				pintaEdificios(g);
			}
		});
		pack();
		setVisible(true);
	}

}

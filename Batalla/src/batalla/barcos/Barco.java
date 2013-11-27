package batalla.barcos;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import batalla.GlobalConstants;
import batalla.tablero.Coordenada;

public abstract class Barco {
	private int tamano;
	private String nombre;
	private String orientacion;
	
	private Coordenada[] barc;
	private int coorX;
	private int coorY;

	private List<Coordenada> posicionesOcupadasBarco;
	public ArrayList<Coordenada> posicionesPerimetralesBarco;

	public Barco(String nombre, int tamano) {
		this.nombre = nombre;
		this.tamano = tamano;
	}

	public int getTamano() {
		return tamano;
	}



	public void setTamano(int tamano) {
		this.tamano = tamano;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getOrientacion() {
		return orientacion;
	}



	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}



	public boolean cabidaTablero(Coordenada c, String o, int tamano) {
		boolean resultado = false;// false: el barco no sale del batalla.tablero
		if (o.equalsIgnoreCase("h")) {// si el barco es horizontal crece sobre
										// las las columnas
			if (c.getCoordenadaY() + tamano > GlobalConstants.ANCHO_MAX_TABLERO) {
				resultado = true;// true el barco sale del batalla.tablero
				System.out
						.println("El barco no cabe en el batalla.tablero. Piense en otra coordenada u orientacion inicial...");
			}
		} else {
			if (c.getCoordenadaX() + tamano > GlobalConstants.ALTO_MAX_TABLERO) {
				resultado = true;
				System.out
						.println("El barco no cabe en el batalla.tablero. Piense en otra coordenada u orientacion inicial...");
			}
		}
		return resultado;
	}

	public boolean comprobarBarco(List<Coordenada> arrayBarco,
			List<Coordenada> arrayFlota, List<Coordenada> arrayPerimetro) {

		boolean resultado = false;// falso= no hay coordenadas coincidentes
		for (Coordenada co : arrayBarco) {
			// el barco no ocupa una posición de otro barco
			for (Coordenada coo : arrayFlota) {
				if (co.getCoordenadaX() == coo.getCoordenadaX()) {
					if (co.getCoordenadaY() == coo.getCoordenadaY()) {
						resultado = true;
					}
				}
			}
			// el barco no ocupa el perímetro de otro barco
			for (Coordenada coor : arrayPerimetro) {
				if (co.getCoordenadaX() == coor.getCoordenadaX()) {
					if (co.getCoordenadaY() == coor.getCoordenadaY()) {
						resultado = true;
					}
				}
			}
		}
		return resultado;
	}

	public List<Coordenada> getPosicionesBarco(Coordenada c, String o) {

		coorX = c.getCoordenadaX();
		coorY = c.getCoordenadaY();

		barc = new Coordenada[tamano];

		for (int i = 0; i < tamano; i++) {
			barc[i] = new Coordenada();
		}

		barc[0].setCoordenadaX(coorX);
		barc[0].setCoordenadaY(coorY);

		orientacion = o;
		for (int i = 1; i < tamano; i++) {
			// si orientacion es horizontal
			if (orientacion.equalsIgnoreCase("h")) {

				coorX = barc[i - 1].getCoordenadaX();
				barc[i].setCoordenadaX(coorX);

				coorY = barc[i - 1].getCoordenadaY() + 1;
				barc[i].setCoordenadaY(coorY);

				if (coorY > GlobalConstants.ALTO_MAX_TABLERO) {
					System.out.println("El barco se sale del batalla.tablero...");
				}
			} else if (orientacion.equalsIgnoreCase("v")) {
				// si orientacion es vertical
				coorX = barc[i - 1].getCoordenadaX() + 1;
				barc[i].setCoordenadaX(coorX);

				coorY = barc[i - 1].getCoordenadaY();
				barc[i].setCoordenadaY(coorY);

				if (coorX > GlobalConstants.ANCHO_MAX_TABLERO) {
					System.out.println("El barco se sale del batalla.tablero...");
				}
			}
		}
		posicionesOcupadasBarco = new ArrayList<Coordenada>();

		for (int i = 0; i < barc.length; i++) {
			posicionesOcupadasBarco.add(barc[i]);
		}
		return posicionesOcupadasBarco;
	}

	public Coordenada[] getBarcoConstruido() {
		return barc;
	}

	public void imprimirBarco() {
		for (int i = 0; i < barc.length; i++) {
			System.out.println("Coordenada [" + i + "] "
					+ barc[i].getCoordenadaX() + "-" + barc[i].getCoordenadaY()
					+ "; ");
		}
		System.out.println("longitud del barco: " + barc.length);
	}

	/*
	 * public List<Coordenada> getPosicionesReservadasBarco(){//NO
	 * posicionesOcupadasBarco= new ArrayList<Coordenada>();
	 * 
	 * for (int i=0;i<barc.length;i++){ posicionesOcupadasBarco.add(barc[i]); }
	 * return posicionesOcupadasBarco; }
	 */

	public ArrayList<Coordenada> getPosicionesPerimetroBarco() {

		int posEncimaX;
		int posDelanteY;
		int posDebajoX;
		int posDetrasY;
		// para barcos horizontales
		Coordenada delanteH = new Coordenada();
		Coordenada detrasH = new Coordenada();
		Coordenada[] encimaH = new Coordenada[barc.length];
		Coordenada[] debajoH = new Coordenada[barc.length];
		// para barcos verticales
		Coordenada encimaV = new Coordenada();
		Coordenada debajoV = new Coordenada();
		Coordenada[] delanteV = new Coordenada[barc.length];
		Coordenada[] detrasV = new Coordenada[barc.length];

		posicionesPerimetralesBarco = new ArrayList<Coordenada>();

		if (orientacion.equalsIgnoreCase("h")) {// para un barco horizontal
			for (int i = 0; i < barc.length; i++) {
				debajoH[i] = new Coordenada();
				encimaH[i] = new Coordenada();
			}

			// si el barco no empieza en la columna 0 del batalla.tablero tiene una
			// posición perimetral delante
			if ((barc[0].getCoordenadaY() != 0)) {
				// posicion delante del barco. Sólo hay una coordenada
				posDelanteY = barc[0].getCoordenadaY() - 1;
				delanteH.setCoordenadaX(barc[0].getCoordenadaX());
				delanteH.setCoordenadaY(posDelanteY);
				posicionesPerimetralesBarco.add(delanteH);
			}
			// si el barco no termina en la última columna del batalla.tablero
			if (barc[barc.length - 1].getCoordenadaY() != GlobalConstants.ANCHO_MAX_TABLERO) {
				// posicion detrás del barco. Sólo hay una coordenada
				posDetrasY = barc[barc.length - 1].getCoordenadaY() + 1;
				detrasH.setCoordenadaX(barc[barc.length - 1].getCoordenadaX());
				detrasH.setCoordenadaY(posDetrasY);
				posicionesPerimetralesBarco.add(detrasH);
			}
			for (int i = 0; i < barc.length; i++) {
				if (barc[0].getCoordenadaX() != 0) {
					// posiciones encima
					posEncimaX = barc[i].getCoordenadaX() - 1;
					encimaH[i].setCoordenadaX(posEncimaX);
					encimaH[i].setCoordenadaY(barc[i].getCoordenadaY());
					posicionesPerimetralesBarco.add(encimaH[i]);
				}
				if (barc[0].getCoordenadaX() != GlobalConstants.ALTO_MAX_TABLERO) {
					// posiciones debajo
					posDebajoX = barc[i].getCoordenadaX() + 1;
					debajoH[i].setCoordenadaX(posDebajoX);
					debajoH[i].setCoordenadaY(barc[i].getCoordenadaY());
					posicionesPerimetralesBarco.add(debajoH[i]);
				}
			}
		} else {// barco vertical
			for (int i = 0; i < barc.length; i++) {
				delanteV[i] = new Coordenada();
				detrasV[i] = new Coordenada();
			}
			// si el barco no empieza en la fila 0 del batalla.tablero tiene una
			// posición perimetral encima
			if ((barc[0].getCoordenadaX() != 0)) {
				posEncimaX = barc[0].getCoordenadaX() - 1;
				encimaV.setCoordenadaX(posEncimaX);
				encimaV.setCoordenadaY(barc[0].getCoordenadaY());
				posicionesPerimetralesBarco.add(encimaV);
			}
			// si el barco no termina en la última fila del batalla.tablero
			if (barc[barc.length - 1].getCoordenadaX() != GlobalConstants.ALTO_MAX_TABLERO) {
				// posicion debajo del barco. Sólo hay una coordenada
				posDebajoX = barc[barc.length - 1].getCoordenadaX() + 1;// se
																		// trabaja
																		// con
																		// la
																		// última
																		// posición
				debajoV.setCoordenadaX(posDebajoX);
				debajoV.setCoordenadaY(barc[barc.length - 1].getCoordenadaY());
				posicionesPerimetralesBarco.add(debajoV);
			}
			for (int i = 0; i < barc.length; i++) {
				if (barc[0].getCoordenadaY() != 0) {
					// posiciones delante
					posDelanteY = barc[i].getCoordenadaY() - 1;
					delanteV[i].setCoordenadaX(barc[i].getCoordenadaX());
					delanteV[i].setCoordenadaY(posDelanteY);
					posicionesPerimetralesBarco.add(delanteV[i]);
				}
				if (barc[0].getCoordenadaY() != GlobalConstants.ANCHO_MAX_TABLERO) {
					// posiciones detras
					posDetrasY = barc[i].getCoordenadaY() + 1;
					detrasV[i].setCoordenadaX(barc[i].getCoordenadaX());
					detrasV[i].setCoordenadaY(posDetrasY);
					posicionesPerimetralesBarco.add(detrasV[i]);
				}
			}
		}
		return posicionesPerimetralesBarco;
	}

	public void imprimirPosProhibidas() {

		Iterator<Coordenada> ite = posicionesOcupadasBarco.iterator();
		System.out.print("Posiciones ocupadas: ");
		while (ite.hasNext()) {
			Coordenada recor = ite.next();
			System.out.print("(" + recor.getCoordenadaX() + ","
					+ recor.getCoordenadaY() + ("); "));
		}
		System.out.println();
		Iterator<Coordenada> it = posicionesPerimetralesBarco.iterator();
		System.out.print("Posiciones perimetrales: ");
		while (it.hasNext()) {
			Coordenada recor = it.next();
			System.out.print("(" + recor.getCoordenadaX() + ","
					+ recor.getCoordenadaY() + "); ");
		}
		System.out.println();
	}

}

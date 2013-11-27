package batalla.jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import batalla.GlobalConstants;
import batalla.barcos.Acorazado;
import batalla.barcos.Barco;
import batalla.barcos.Fragata;
import batalla.barcos.Portaaviones;
import batalla.barcos.Submarino;
import batalla.tablero.Coordenada;
import batalla.tablero.Tablero;

public class Ordenador extends Participante {

	private Coordenada coordOrdenador;
	private Barco submarinoOrdenador;
	private Barco fragataOrdenador;
	private Barco acorazadoOrdenador;
	private Barco portaavionesOrdenador;

	private Tablero tableroBarcosOrdenador;

	private List<Coordenada> aSubOrdenador = new ArrayList<Coordenada>();
	private List<Coordenada> aFraOrdenador = new ArrayList<Coordenada>();
	private List<Coordenada> aAcoOrdenador = new ArrayList<Coordenada>();
	private List<Coordenada> aPortaOrdenador = new ArrayList<Coordenada>();

	private List<Coordenada[]> flotaO;
	private List<Coordenada> posicionesOcupadasFlotaOrdenador;
	private List<Coordenada> posicionesPerimetralesFlotaOrdenador;

	private List<Coordenada> disparoListo;
	private List<Coordenada> proximoDisparo;
	private List<Coordenada> disparoAlternativo;

	private String resultadoDisparoOrdenador;

	@Override
	public void posicionarFlota() {

		String orientacionAleatoria = "";
		coordOrdenador = null;

		aSubOrdenador = null;
		aFraOrdenador = null;
		aAcoOrdenador = null;
		aPortaOrdenador = null;

		tableroBarcosOrdenador = new Tablero(GlobalConstants.ANCHO_MAX_TABLERO,
				GlobalConstants.ALTO_MAX_TABLERO);

		flotaO = new ArrayList<Coordenada[]>();
		posicionesOcupadasFlotaOrdenador = new ArrayList<Coordenada>();
		posicionesPerimetralesFlotaOrdenador = new ArrayList<Coordenada>();

		// SUBMARINO ORDENADOR
		for (int i = 0; i < GlobalConstants.NUMERO_SUBMARINOS; i++) {
			do {

				orientacionAleatoria = pedirOrientacionAleatoria();
				coordOrdenador = coordenadaValidaAleatoria(
						orientacionAleatoria, Submarino.TAMANO);

				submarinoOrdenador = new Submarino();
				aSubOrdenador = submarinoOrdenador.getPosicionesBarco(
						coordOrdenador, orientacionAleatoria);

			} while (submarinoOrdenador.comprobarBarco(aSubOrdenador,
					posicionesOcupadasFlotaOrdenador,
					posicionesPerimetralesFlotaOrdenador));

			// colocar barco en el batalla.tablero
			tableroBarcosOrdenador.colocarBarcoEnTablero(
					submarinoOrdenador.getBarcoConstruido(), Submarino.TAMANO);

			flotaO = getFlotaO(submarinoOrdenador.getBarcoConstruido());
			posicionesOcupadasFlotaOrdenador = getPosicionesOcupadasFlotaOrdenador(aSubOrdenador);
			posicionesPerimetralesFlotaOrdenador = getPosicionesPerimetralesFlotaOrdenador(submarinoOrdenador);
		}

		// FRAGATA ORDENADOR
		for (int i = 0; i < GlobalConstants.NUMERO_FRAGATAS; i++) {
			do {
				orientacionAleatoria = pedirOrientacionAleatoria();
				coordOrdenador = coordenadaValidaAleatoria(
						orientacionAleatoria, Fragata.TAMANO);

				fragataOrdenador = new Fragata();
				aFraOrdenador = fragataOrdenador.getPosicionesBarco(
						coordOrdenador, orientacionAleatoria);

			} while (fragataOrdenador.comprobarBarco(aFraOrdenador,
					posicionesOcupadasFlotaOrdenador,
					posicionesPerimetralesFlotaOrdenador));

			tableroBarcosOrdenador.colocarBarcoEnTablero(
					fragataOrdenador.getBarcoConstruido(), Fragata.TAMANO);

			flotaO = getFlotaO(fragataOrdenador.getBarcoConstruido());
			posicionesOcupadasFlotaOrdenador = getPosicionesOcupadasFlotaOrdenador(aFraOrdenador);
			posicionesPerimetralesFlotaOrdenador = getPosicionesPerimetralesFlotaOrdenador(fragataOrdenador);

		}

		// ACORAZADO ORDENADOR
		for (int i = 0; i < GlobalConstants.NUMERO_ACORAZADOS; i++) {
			do {
				orientacionAleatoria = pedirOrientacionAleatoria();
				coordOrdenador = coordenadaValidaAleatoria(
						orientacionAleatoria, Acorazado.TAMANO);

				acorazadoOrdenador = new Acorazado();
				aAcoOrdenador = acorazadoOrdenador.getPosicionesBarco(
						coordOrdenador, orientacionAleatoria);

			} while (acorazadoOrdenador.comprobarBarco(aAcoOrdenador,
					posicionesOcupadasFlotaOrdenador,
					posicionesPerimetralesFlotaOrdenador));

			tableroBarcosOrdenador.colocarBarcoEnTablero(
					acorazadoOrdenador.getBarcoConstruido(), Acorazado.TAMANO);

			flotaO = getFlotaO(acorazadoOrdenador.getBarcoConstruido());
			posicionesOcupadasFlotaOrdenador = getPosicionesOcupadasFlotaOrdenador(aAcoOrdenador);
			posicionesPerimetralesFlotaOrdenador = getPosicionesPerimetralesFlotaOrdenador(acorazadoOrdenador);

		}

		// PORTAAVIONES ORDENADOR
		for (int i = 0; i < GlobalConstants.NUMERO_PORTAAVIONES; i++) {
			do {
				orientacionAleatoria = pedirOrientacionAleatoria();
				coordOrdenador = coordenadaValidaAleatoria(
						orientacionAleatoria, Portaaviones.TAMANO);

				portaavionesOrdenador = new Portaaviones();
				aPortaOrdenador = portaavionesOrdenador.getPosicionesBarco(
						coordOrdenador, orientacionAleatoria);

			} while (portaavionesOrdenador.comprobarBarco(aPortaOrdenador,
					posicionesOcupadasFlotaOrdenador,
					posicionesPerimetralesFlotaOrdenador));

			tableroBarcosOrdenador.colocarBarcoEnTablero(
					portaavionesOrdenador.getBarcoConstruido(),
					Portaaviones.TAMANO);

			flotaO = getFlotaO(portaavionesOrdenador.getBarcoConstruido());
			posicionesOcupadasFlotaOrdenador = getPosicionesOcupadasFlotaOrdenador(aPortaOrdenador);
			posicionesPerimetralesFlotaOrdenador = getPosicionesPerimetralesFlotaOrdenador(portaavionesOrdenador);

		}

	}

	public Coordenada crearDisparoAleatorio() {
		disparoAleatorio = new Coordenada();
		disparoAleatorio.coordenadaAleatoria();

		return disparoAleatorio;
	}

	public void mostrarDisparo(Coordenada c) {
		int x;
		int y;
		// la persona nombra a las filas y columnas empezando en el 1 y así se
		// muestran
		x = c.getCoordenadaX();
		y = c.getCoordenadaY();
		System.out.println();
		System.out.print("El disparo del ordenador es:");
		System.out.print(" " + (x + 1) + "-" + (y + 1) + " ");
	}

	public void iniciarDisparoListo() {
		disparoListo = new ArrayList<Coordenada>();
	}

	public void iniciarProximoDisparo() {
		proximoDisparo = new ArrayList<Coordenada>();
	}

	public void iniciarDisparoAlternativo() {
		disparoAlternativo = new ArrayList<Coordenada>();
	}

	public void crearDisparoListo(Coordenada c) {
		/*
		 * cuando tenemos un tocado del ordenador le calculamos las siguientes
		 * tiradas
		 */
		disparoListo = new ArrayList<Coordenada>();

		Coordenada cordlista1 = new Coordenada();
		Coordenada cordlista2 = new Coordenada();
		Coordenada cordlista3 = new Coordenada();
		Coordenada cordlista4 = new Coordenada();

		if (c.getCoordenadaX() != 0) {
			// disparo a la casilla de arriba
			cordlista1.setCoordenadaX(c.getCoordenadaX() - 1);
			cordlista1.setCoordenadaY(c.getCoordenadaY());
			disparoListo.add(cordlista1);
		}
		if (c.getCoordenadaY() != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
			// disparo a la casilla de la derecha
			cordlista2.setCoordenadaX(c.getCoordenadaX());
			cordlista2.setCoordenadaY(c.getCoordenadaY() + 1);
			disparoListo.add(cordlista2);
		}
		if (c.getCoordenadaX() != GlobalConstants.ALTO_MAX_TABLERO - 1) {
			// disparo a la casilla de abajo
			cordlista3.setCoordenadaX(c.getCoordenadaX() + 1);
			cordlista3.setCoordenadaY(c.getCoordenadaY());
			disparoListo.add(cordlista3);
		}
		if (c.getCoordenadaY() != 0) {
			// disparo a la casilla de la izquierda
			cordlista4.setCoordenadaX(c.getCoordenadaX());
			cordlista4.setCoordenadaY(c.getCoordenadaY() - 1);
			disparoListo.add(cordlista4);
		}
	}

	public void crearProximoDisparo(Coordenada disOrd, Coordenada disListo) {
		/*
		 * tenemos dos coordenadas tocadas contiguas lo que implica que tenemos
		 * la orientación calculamos dos arrays, siguiendo la orientación, uno
		 * en cada sentido los arrays los creamos con 3 coordenadas a cada lado
		 * (el máximo tamaño: tamañoPortaaviones menos las 2 coordenadas que ya
		 * tenemos)
		 */
		proximoDisparo = new ArrayList<Coordenada>();
		Coordenada coorProxDis1 = new Coordenada();
		Coordenada coorProxDis2 = new Coordenada();
		Coordenada coorProxDis3 = new Coordenada();

		disparoAlternativo = new ArrayList<Coordenada>();
		Coordenada coorDisAlt1 = new Coordenada();
		Coordenada coorDisAlt2 = new Coordenada();
		Coordenada coorDisAlt3 = new Coordenada();

		if (disOrd.getCoordenadaX() == disListo.getCoordenadaX()) {// nos indica
																	// orientación
																	// horizontal
			if (disOrd.getCoordenadaY() < disListo.getCoordenadaY()) {// faltan
																		// los
																		// límites
																		// del
																		// batalla.tablero
				if (disListo.getCoordenadaY() != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
					coorProxDis1.setCoordenadaX(disListo.getCoordenadaX());
					coorProxDis1.setCoordenadaY(disListo.getCoordenadaY() + 1);
					proximoDisparo.add(coorProxDis1);
					if (disListo.getCoordenadaY() + 1 != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
						coorProxDis2.setCoordenadaX(disListo.getCoordenadaX());
						coorProxDis2
								.setCoordenadaY(disListo.getCoordenadaY() + 2);
						proximoDisparo.add(coorProxDis2);
						if (disListo.getCoordenadaY() + 2 != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
							coorProxDis3.setCoordenadaX(disListo
									.getCoordenadaX());
							coorProxDis3.setCoordenadaY(disListo
									.getCoordenadaY() + 3);
							proximoDisparo.add(coorProxDis3);
						}
					}
				}
				if (disListo.getCoordenadaY() - 1 != 0) {
					coorDisAlt1.setCoordenadaX(disListo.getCoordenadaX());
					coorDisAlt1.setCoordenadaY(disListo.getCoordenadaY() - 2);
					disparoAlternativo.add(coorDisAlt1);
					if (disListo.getCoordenadaY() - 2 != 0) {
						coorDisAlt2.setCoordenadaX(disListo.getCoordenadaX());
						coorDisAlt2
								.setCoordenadaY(disListo.getCoordenadaY() - 3);
						disparoAlternativo.add(coorDisAlt2);
						if (disListo.getCoordenadaY() - 3 != 0) {
							coorDisAlt3.setCoordenadaX(disListo
									.getCoordenadaX());
							coorDisAlt3.setCoordenadaY(disListo
									.getCoordenadaY() - 4);
							disparoAlternativo.add(coorDisAlt3);
						}
					}
				}
			} else {
				if (disListo.getCoordenadaY() != 0) {
					coorProxDis1.setCoordenadaX(disListo.getCoordenadaX());
					coorProxDis1.setCoordenadaY(disListo.getCoordenadaY() - 1);
					proximoDisparo.add(coorProxDis1);
					if (disListo.getCoordenadaY() - 1 != 0) {
						coorProxDis2.setCoordenadaX(disListo.getCoordenadaX());
						coorProxDis2
								.setCoordenadaY(disListo.getCoordenadaY() - 2);
						proximoDisparo.add(coorProxDis2);
						if (disListo.getCoordenadaY() - 2 != 0) {
							coorProxDis3.setCoordenadaX(disListo
									.getCoordenadaX());
							coorProxDis3.setCoordenadaY(disListo
									.getCoordenadaY() - 3);
							proximoDisparo.add(coorProxDis3);
						}
					}
				}
				if (disListo.getCoordenadaY() + 1 != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
					coorDisAlt1.setCoordenadaX(disListo.getCoordenadaX());
					coorDisAlt1.setCoordenadaY(disListo.getCoordenadaY() + 2);
					disparoAlternativo.add(coorDisAlt1);
					if (disListo.getCoordenadaY() + 2 != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
						coorDisAlt2.setCoordenadaX(disListo.getCoordenadaX());
						coorDisAlt2
								.setCoordenadaY(disListo.getCoordenadaY() + 3);
						disparoAlternativo.add(coorDisAlt2);
						if (disListo.getCoordenadaY() + 3 != GlobalConstants.ANCHO_MAX_TABLERO - 1) {
							coorDisAlt3.setCoordenadaX(disListo
									.getCoordenadaX());
							coorDisAlt3.setCoordenadaY(disListo
									.getCoordenadaY() + 4);
							disparoAlternativo.add(coorDisAlt3);
						}
					}
				}
			}
		}
		if (disOrd.getCoordenadaY() == disListo.getCoordenadaY()) {// nos indica
																	// orientación
																	// vertical
			if (disOrd.getCoordenadaX() < disListo.getCoordenadaX()) {// faltan
																		// los
																		// límites
																		// del
																		// batalla.tablero
				if (disListo.getCoordenadaX() != GlobalConstants.ALTO_MAX_TABLERO - 1) {
					coorProxDis1.setCoordenadaX(disListo.getCoordenadaX() + 1);
					coorProxDis1.setCoordenadaY(disListo.getCoordenadaY());
					proximoDisparo.add(coorProxDis1);
					if (disListo.getCoordenadaX() + 1 != GlobalConstants.ALTO_MAX_TABLERO - 1) {
						coorProxDis2
								.setCoordenadaX(disListo.getCoordenadaX() + 2);
						coorProxDis2.setCoordenadaY(disListo.getCoordenadaY());
						proximoDisparo.add(coorProxDis2);
						if (disListo.getCoordenadaX() + 2 != GlobalConstants.ALTO_MAX_TABLERO - 1) {
							coorProxDis3.setCoordenadaX(disListo
									.getCoordenadaX() + 3);
							coorProxDis3.setCoordenadaY(disListo
									.getCoordenadaY());
							proximoDisparo.add(coorProxDis3);
						}
					}
				}
				if (disListo.getCoordenadaX() - 1 != 0) {
					coorDisAlt1.setCoordenadaX(disListo.getCoordenadaX() - 2);
					coorDisAlt1.setCoordenadaY(disListo.getCoordenadaY());
					disparoAlternativo.add(coorDisAlt1);
					if (disListo.getCoordenadaX() - 2 != 0) {
						coorDisAlt2
								.setCoordenadaX(disListo.getCoordenadaX() - 3);
						coorDisAlt2.setCoordenadaY(disListo.getCoordenadaY());
						disparoAlternativo.add(coorDisAlt2);
						if (disListo.getCoordenadaX() - 3 != 0) {
							coorDisAlt3.setCoordenadaX(disListo
									.getCoordenadaX() - 4);
							coorDisAlt3.setCoordenadaY(disListo
									.getCoordenadaY());
							disparoAlternativo.add(coorDisAlt3);
						}
					}
				}
			} else {
				if (disListo.getCoordenadaX() != 0) {
					coorProxDis1.setCoordenadaX(disListo.getCoordenadaX() - 1);
					coorProxDis1.setCoordenadaY(disListo.getCoordenadaY());
					proximoDisparo.add(coorProxDis1);
					if (disListo.getCoordenadaX() - 1 != 0) {
						coorProxDis2
								.setCoordenadaX(disListo.getCoordenadaX() - 2);
						coorProxDis2.setCoordenadaY(disListo.getCoordenadaY());
						proximoDisparo.add(coorProxDis2);
						if (disListo.getCoordenadaX() - 2 != 0) {
							coorProxDis3.setCoordenadaX(disListo
									.getCoordenadaX() - 3);
							coorProxDis3.setCoordenadaY(disListo
									.getCoordenadaY());
							proximoDisparo.add(coorProxDis3);
						}
					}
				}

				if (disListo.getCoordenadaX() + 1 != GlobalConstants.ALTO_MAX_TABLERO) {
					coorDisAlt1.setCoordenadaX(disListo.getCoordenadaX() + 2);
					coorDisAlt1.setCoordenadaY(disListo.getCoordenadaY());
					disparoAlternativo.add(coorDisAlt1);
					if (disListo.getCoordenadaX() + 2 != GlobalConstants.ALTO_MAX_TABLERO) {
						coorDisAlt2
								.setCoordenadaX(disListo.getCoordenadaX() + 3);
						coorDisAlt2.setCoordenadaY(disListo.getCoordenadaY());
						disparoAlternativo.add(coorDisAlt2);
						if (disListo.getCoordenadaX() + 3 != GlobalConstants.ALTO_MAX_TABLERO) {
							coorDisAlt3.setCoordenadaX(disListo
									.getCoordenadaX() + 4);
							coorDisAlt3.setCoordenadaY(disListo
									.getCoordenadaY());
							disparoAlternativo.add(coorDisAlt3);
						}
					}
				}
			}
		}

	}

	public List<Coordenada> getDisparoListo() {
		return disparoListo;
	}

	public List<Coordenada> getProximoDisparo() {
		return proximoDisparo;
	}

	public List<Coordenada> getDisparoAlternativo() {
		return disparoAlternativo;
	}

	public void limpiarDisparoListo() {
		disparoListo.clear();
	}

	public void limpiarProximoDisparo() {
		proximoDisparo.clear();
	}

	public void limpiarDisparoAlternativo() {
		disparoAlternativo.clear();
	}

	public String solicitarResultadoDisparo() {

		Scanner tecleo;

		while (true) {
			System.out.println("Agua (A), Tocado (T), Hundido (H)?");

			tecleo = new Scanner(System.in);
			resultadoDisparoOrdenador = tecleo.next();

			if (resultadoDisparoOrdenador.equalsIgnoreCase("A")) {
				break;
			}
			if (resultadoDisparoOrdenador.equalsIgnoreCase("T")) {
				break;
			}
			if (resultadoDisparoOrdenador.equalsIgnoreCase("H")) {
				break;
			}
		}
		tecleo.close();
		return resultadoDisparoOrdenador;
	}

	public Coordenada coordenadaValidaAleatoria(String o, int tamano) {
		// teniendo la orientacion y el tamaño del barco pide una coordenada
		// hasta que sea válida

		Coordenada coordOrdenador = new Coordenada();
		boolean resultado = false;

		do {
			coordOrdenador.coordenadaAleatoria();

			resultado = false;
			if (o.equalsIgnoreCase("h")) {// barco horizontal crece sobre las
											// las columnas
				if (coordOrdenador.getCoordenadaY() + tamano > GlobalConstants.ANCHO_MAX_TABLERO) {
					resultado = true;// se sale del batalla.tablero
				}
			} else {
				if (coordOrdenador.getCoordenadaX() + tamano > GlobalConstants.ALTO_MAX_TABLERO) {
					resultado = true;
				}
			}
		} while (resultado == true);
		return coordOrdenador;
	}

	public String pedirOrientacionAleatoria() {
		String orientacionAleatoria = "";

		int repartirOrientacion;// de 0 a 4 la orientación será horizontal de 4
								// a 9 vertical
		repartirOrientacion = (int) (Math.random() * 10);

		if (repartirOrientacion < 4) {
			orientacionAleatoria = "h";
		} else {
			orientacionAleatoria = "v";
		}

		return orientacionAleatoria;
	}

	public List<Coordenada> getPosicionesOcupadasFlotaOrdenador(
			List<Coordenada> al) {
		for (int j = 0; j < al.size(); j++) {
			posicionesOcupadasFlotaOrdenador.add(al.get(j));
		}
		return posicionesOcupadasFlotaOrdenador;
	}

	public List<Coordenada> getPosicionesOcupadasFlotaOrdenador() {
		return posicionesOcupadasFlotaOrdenador;
	}

	public List<Coordenada[]> getFlotaO() {
		return flotaO;
	}

	public List<Coordenada[]> getFlotaO(Coordenada[] barco) {
		flotaO.add(barco);
		return flotaO;
	}

	public List<Coordenada> getPosicionesPerimetralesFlotaOrdenador(Barco ba) {
		for (int k = 0; k < ba.getPosicionesPerimetroBarco().size(); k++) {
			posicionesPerimetralesFlotaOrdenador
					.add(ba.posicionesPerimetralesBarco.get(k));
		}
		return posicionesPerimetralesFlotaOrdenador;
	}

	public Coordenada disparar(List<Coordenada> conjuntoDisparos) {// crea un
																	// disparo y
																	// comprueba
																	// que no
																	// fue usado
		Coordenada disparo = new Coordenada();
		boolean resultado = false;

		do {
			disparo.coordenadaAleatoria();
			resultado = comprobarConjuntoDisparos(disparo, conjuntoDisparos);
		} while (resultado);
		mostrarDisparo(disparo);
		return disparo;
	}

	public boolean comprobarHundido(List<Coordenada[]> flota, Tablero tablero) {
		boolean bHundido = false;

		int fila;
		int columna;
		boolean estCasilla = false;
		boolean estCasillaFinal = false;
		boolean hundido = true;

		for (Coordenada[] barc : flota) {// para cada barco de la flota
			int longitud = barc.length;

			for (int i = 0; i < longitud; i++) {
				fila = barc[i].getCoordenadaX();
				columna = barc[i].getCoordenadaY();
				// si el estadoCasilla del batalla.tablero es agua(false) o
				// tocado(true)
				estCasilla = tablero.devolverEstadosCasilla(fila, columna);
				if (estCasilla) {// si la coordenada esta tocada
					hundido = true;
				} else {
					hundido = false;
					break;
				}
				estCasillaFinal = tablero.devolverEstadosCasilla(
						barc[longitud - 1].getCoordenadaX(),
						barc[longitud - 1].getCoordenadaY());
				// si la última coordenada está tocada implica hundido
				if (hundido && estCasillaFinal) {// aquí sólo se llega con todas
													// las coordenadas hundido
													// true
					bHundido = true;
					tablero.anotarHundido(barc[longitud - 1].getCoordenadaX(),
							barc[longitud - 1].getCoordenadaY());
				}
			}
		}
		return bHundido;
	}

	public boolean juegoTramposo(boolean tocado, boolean hundido,
			String respuesta) {// devuelve boolean if juegoTramposo break
		boolean terminar = false;

		if (tocado && respuesta.equalsIgnoreCase("T")) {
			terminar = false;
		} else if (hundido && respuesta.equalsIgnoreCase("H")) {
			terminar = false;
		} else if (!tocado && respuesta.equalsIgnoreCase("A")) {
			terminar = false;
		} else {
			terminar = true;
			System.out
					.println("Esta usted despistado o haciendo trampas. El juego acaba aqui...");
		}
		return terminar;
	}

}

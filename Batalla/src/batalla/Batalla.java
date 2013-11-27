package batalla;

import java.util.List;
import java.util.ArrayList;

import batalla.jugador.Ordenador;
import batalla.jugador.Persona;
import batalla.tablero.Coordenada;
import batalla.tablero.Tablero;

public class Batalla {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("	Bienvenido al juego ***Hundir la flota***\n");
		System.out.println();
		System.out
		.println("La flota consta de 7 barcos y jugamos en un batalla.tablero de "
				+ GlobalConstants.ALTO_MAX_TABLERO
				+ "x"
				+ GlobalConstants.ANCHO_MAX_TABLERO + ".");
		System.out
		.println("Para cada barco se solicita la orientacion y la primera coordenada.");
		System.out.println("Se autocompletan hacia la derecha y hacia abajo.");
		System.out.println("Tiene: ");
		System.out.println("	- 2 Submarinos con 2 coordenadas");
		System.out.println("	- 2 Fragatas con 3 coordenadas");
		System.out.println("	- 2 Acorazados con 4 coordenadas");
		System.out.println("	- 1 Portaaviones con 5 coordenadas");

		boolean acierto;
		boolean esHundido;
		boolean resultado;

		// PERSONA *******************************************
		// flota
		List<Coordenada> flotaPersona;
		List<Coordenada[]> flotaP;
		// batalla.tablero
		Tablero tableroDisparoPersona;
		List<Coordenada> conjuntoDisparosPersona;
		boolean devHundido;
		int contadorPersona;
		// disparo
		Coordenada disPersona;

		// PERSONA crear flota persona
		Persona persona = new Persona();
		persona.posicionarFlota();

		flotaPersona = new ArrayList<Coordenada>();
		flotaPersona = persona.getPosicionesOcupadasFlota();
		flotaP = new ArrayList<Coordenada[]>();
		flotaP = persona.getFlotaP();
		tableroDisparoPersona = new Tablero(GlobalConstants.ANCHO_MAX_TABLERO,
				GlobalConstants.ALTO_MAX_TABLERO);

		conjuntoDisparosPersona = new ArrayList<Coordenada>();
		contadorPersona = 0;// cuenta los barcos hundidos

		// ORDENADOR *******************************************
		// flota
		List<Coordenada> flotaOrdenador;
		List<Coordenada[]> flotaO;
		// batalla.tablero
		Tablero tableroDisparoOrdenador;
		List<Coordenada> conjuntoDisparosOrdenador;
		int contadorOrdenador;
		boolean terminar;
		// disparos
		Coordenada disOrdenador;
		Coordenada disRecuerdo = new Coordenada();
		Coordenada disListo = new Coordenada();
		Coordenada proxDisparo = new Coordenada();
		Coordenada disAlternativo = new Coordenada();
		List<Coordenada> disparoListo;
		List<Coordenada> proximoDisparo;
		List<Coordenada> disparoAlternativo;

		// ORDENADOR crear flota ordenador
		Ordenador ordenador = new Ordenador();
		ordenador.posicionarFlota();

		flotaOrdenador = new ArrayList<Coordenada>();
		flotaOrdenador = ordenador.getPosicionesOcupadasFlotaOrdenador();
		flotaO = new ArrayList<Coordenada[]>();
		flotaO = ordenador.getFlotaO();
		tableroDisparoOrdenador = new Tablero(GlobalConstants.ANCHO_MAX_TABLERO,
				GlobalConstants.ALTO_MAX_TABLERO); // para comprobar el hundido
		conjuntoDisparosOrdenador = new ArrayList<Coordenada>();// se añaden
		// después,
		// disparo a
		// disparo
		contadorOrdenador = 0;// cuenta los barcos hundidos
		terminar = false;
		// disparos
		ordenador.iniciarDisparoListo();
		ordenador.iniciarProximoDisparo();
		ordenador.iniciarDisparoAlternativo();

		disparoListo = ordenador.getDisparoListo();
		proximoDisparo = ordenador.getProximoDisparo();
		disparoAlternativo = ordenador.getDisparoAlternativo();

		String respuesta = "";
		boolean salir = false;

		int turnos = 10;
		// PERSONA turno de disparos *******************************************
		try {
			do {// este do es para que los turnos sean continuos

				do {
					tableroDisparoPersona.imprimirTableroDisparos();
					disPersona = persona.disparar(conjuntoDisparosPersona);
					conjuntoDisparosPersona = persona.añadirDisparo(disPersona,
							conjuntoDisparosPersona);
					acierto = persona.aciertaEnCoordenadaContraria(disPersona,
							flotaOrdenador);

					if (acierto) {
						System.out.println("Tocado!");
					} else {
						System.out.println("Agua");
					}

					tableroDisparoPersona.anotarDisparoEnTablero(disPersona,
							acierto);// se apunta tocado o agua
					tableroDisparoPersona.imprimirTableroDisparos();

					if (acierto) {
						devHundido = persona.comprobarHundido(flotaO,
								tableroDisparoPersona);
						if (devHundido) {
							tableroDisparoPersona.imprimirTableroDisparos();
							contadorPersona = contadorPersona + 1;// cada
							// hundido
							// suma 1.
						}
					}
					if (contadorPersona == GlobalConstants.NUMERO_TOTAL_BARCOS) {
						break;
					}
				} while (acierto
						&& (contadorPersona != GlobalConstants.NUMERO_TOTAL_BARCOS));

				if (contadorPersona == GlobalConstants.NUMERO_TOTAL_BARCOS) {
					System.out
					.println("Fin del juego. Gana usted. Enhorabuena");
					break;
				}
				// ORDENADOR turno de disparos
				// *******************************************

				if (turnos == 0) {
					salir = persona.salir();
					if (salir) {
						break;
					}
					turnos = 10;
				} else {
					turnos--;
				}

				do {
					disparoListo = ordenador.getDisparoListo();
					if (!disparoListo.isEmpty()) { // si no está vacío extraigo
						// su 1ºcoordenada y la
						// elimino del array
						do {
							disListo = disparoListo.get(0);// 1º coordenada
							disparoListo.remove(0);
							resultado = ordenador.comprobarConjuntoDisparos(
									disListo, conjuntoDisparosOrdenador);
						} while (resultado); // compruebo que la coordenada no
						// fue utilizada antes
						ordenador.mostrarDisparo(disListo);
						conjuntoDisparosOrdenador = ordenador.añadirDisparo(
								disListo, conjuntoDisparosOrdenador); // para
						// que
						// no se
						// vuelva
						// a
						// utilizar
						// el
						// mismo
						// disparo
						acierto = ordenador.aciertaEnCoordenadaContraria(
								disListo, flotaPersona);// true si es Tocado

						tableroDisparoOrdenador.anotarDisparoEnTablero(
								disListo, acierto);// se apunta tocado o agua
						esHundido = ordenador.comprobarHundido(flotaP,
								tableroDisparoOrdenador);

						// respuesta de batalla.jugador persona
						persona.mostrarTableroBarcosFlota();// muestro el
						// batalla.tablero de barcos
						// de la persona
						// jugadora para que
						// pueda contestar
						respuesta = ordenador.solicitarResultadoDisparo();// devuelve
						// A,T
						// o
						// H
						persona.anotarEnTableroBarcos(disListo, acierto);
						terminar = ordenador.juegoTramposo(acierto, esHundido,
								respuesta);// si se responde con trampa
						// (devuelve un true) terminamos el
						// juego

						if (esHundido) {
							contadorOrdenador = contadorOrdenador + 1;
							ordenador.limpiarDisparoListo();
						}
						if (acierto && !esHundido) {
							ordenador.limpiarDisparoListo();
							ordenador
							.crearProximoDisparo(disRecuerdo, disListo);
							proximoDisparo = ordenador.getProximoDisparo();
							disparoAlternativo = ordenador
									.getDisparoAlternativo();
						}
					} else if (!proximoDisparo.isEmpty()) {
						do {
							proxDisparo = proximoDisparo.get(0);
							proximoDisparo.remove(0);
							resultado = ordenador.comprobarConjuntoDisparos(
									proxDisparo, conjuntoDisparosOrdenador);
						} while (resultado);
						ordenador.mostrarDisparo(proxDisparo);
						conjuntoDisparosOrdenador = ordenador.añadirDisparo(
								proxDisparo, conjuntoDisparosOrdenador);
						acierto = ordenador.aciertaEnCoordenadaContraria(
								proxDisparo, flotaPersona);

						tableroDisparoOrdenador.anotarDisparoEnTablero(
								proxDisparo, acierto);
						esHundido = ordenador.comprobarHundido(flotaP,
								tableroDisparoOrdenador);

						persona.mostrarTableroBarcosFlota();
						respuesta = ordenador.solicitarResultadoDisparo();
						persona.anotarEnTableroBarcos(proxDisparo, acierto);
						terminar = ordenador.juegoTramposo(acierto, esHundido,
								respuesta);

						if (esHundido) {
							contadorOrdenador = contadorOrdenador + 1;
							ordenador.limpiarProximoDisparo();// se desecha el
							// array y se
							// limpia
							ordenador.limpiarDisparoAlternativo();
						}
						/*
						 * if (acierto && !esHundido){ System.out.println(
						 * "pasa por interior de acierto y !esHundido proximoDisparo"
						 * ); }
						 */
						if (!acierto) {
							ordenador.limpiarProximoDisparo();
							disparoAlternativo = ordenador
									.getDisparoAlternativo();
						}
					} else if (!disparoAlternativo.isEmpty()) {
						do {
							disAlternativo = disparoAlternativo.get(0);
							disparoAlternativo.remove(0);
							resultado = ordenador.comprobarConjuntoDisparos(
									disAlternativo, conjuntoDisparosOrdenador);
						} while (resultado);
						ordenador.mostrarDisparo(disAlternativo);
						conjuntoDisparosOrdenador = ordenador.añadirDisparo(
								disAlternativo, conjuntoDisparosOrdenador);
						acierto = ordenador.aciertaEnCoordenadaContraria(
								disAlternativo, flotaPersona);

						tableroDisparoOrdenador.anotarDisparoEnTablero(
								disAlternativo, acierto);
						esHundido = ordenador.comprobarHundido(flotaP,
								tableroDisparoOrdenador);

						persona.mostrarTableroBarcosFlota();
						respuesta = ordenador.solicitarResultadoDisparo();
						persona.anotarEnTableroBarcos(disAlternativo, acierto);
						terminar = ordenador.juegoTramposo(acierto, esHundido,
								respuesta);

						if (esHundido) {
							contadorOrdenador = contadorOrdenador + 1;
							ordenador.limpiarDisparoAlternativo();
						}
						// si es acierto continua y aquí no habrá !acierto
						/*
						 * if (acierto && !esHundido){ System.out.println(
						 * "pasa por interior de acierto y !esHundido disAlternativo"
						 * ); //AQUÍ NECESITO UN BUCLE DE ACIERTO EN DISPARO
						 * ALTERNATIVO
						 * 
						 * //tiramos la siguiente coordenada de
						 * disparoAlternativo }
						 * 
						 * if(!acierto){ //nunca habrá no acierto }
						 */
					} else {
						disOrdenador = ordenador
								.disparar(conjuntoDisparosOrdenador);
						conjuntoDisparosOrdenador = ordenador.añadirDisparo(
								disOrdenador, conjuntoDisparosOrdenador);
						acierto = ordenador.aciertaEnCoordenadaContraria(
								disOrdenador, flotaPersona);
						tableroDisparoOrdenador.anotarDisparoEnTablero(
								disOrdenador, acierto);
						esHundido = ordenador.comprobarHundido(flotaP,
								tableroDisparoOrdenador);// en este bucle no se
						// dará hundido
						/*
						 * if(esHundido){//aquí no se dará la condición de
						 * hundido contadorOrdenador=contadorOrdenador+1; }
						 */

						persona.mostrarTableroBarcosFlota();
						respuesta = ordenador.solicitarResultadoDisparo();
						persona.anotarEnTableroBarcos(disOrdenador, acierto);
						terminar = ordenador.juegoTramposo(acierto, esHundido,
								respuesta);
						if (terminar) {
							break;
						}
						if (acierto) {// aquí no se dará la condición de hundido
							// (acierto && !esHundido)
							disRecuerdo = disOrdenador;
							ordenador.crearDisparoListo(disOrdenador);
						}
					}
					if (contadorOrdenador == GlobalConstants.NUMERO_TOTAL_BARCOS) {
						break;
					}

				} while (acierto);

				if (contadorOrdenador == GlobalConstants.NUMERO_TOTAL_BARCOS
						|| terminar) {
					System.out.println("El Ordenador gana.");
					break;
				}

			} while (!acierto);
		} catch (IndexOutOfBoundsException e) {
		}
		System.out.println("Fin del juego.");
	}

}

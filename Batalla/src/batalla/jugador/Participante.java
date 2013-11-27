package batalla.jugador;

import java.util.ArrayList;
import java.util.List;

import batalla.tablero.Coordenada;

abstract class Participante {

	Coordenada disparo;
	Coordenada disparoAleatorio;

	public Participante() {
	}

	public abstract void posicionarFlota();

	public boolean aciertaEnCoordenadaContraria(Coordenada coorde,
			List<Coordenada> flota) {
		// devuelve true para tocado, y false para agua
		boolean resultadoDisparo = false;

		for (Coordenada coor : flota) {
			if (coorde.getCoordenadaX() == coor.getCoordenadaX()) {
				if (coorde.getCoordenadaY() == coor.getCoordenadaY()) {
					resultadoDisparo = true;
				}
			}
		}
		return resultadoDisparo;
	}

	public boolean comprobarDisparo(Coordenada c,
			ArrayList<Coordenada> arrayCoorde) {
		boolean disparoValido = true;
		for (Coordenada aC : arrayCoorde) {
			if (c.getCoordenadaX() == aC.getCoordenadaX()) {
				if (c.getCoordenadaY() == aC.getCoordenadaY()) {
					disparoValido = false;
				}
			}
		}
		return disparoValido;
	}

	public boolean comprobarConjuntoDisparos(Coordenada c,
			List<Coordenada> arrayCoorde) {
		boolean disparo = false;
		for (Coordenada aC : arrayCoorde) {
			if (c.getCoordenadaX() == aC.getCoordenadaX()) {
				if (c.getCoordenadaY() == aC.getCoordenadaY()) {
					disparo = true;
				}
			}
		}
		return disparo;
	}

	public List<Coordenada> añadirDisparo(Coordenada co,
			List<Coordenada> conjuntoDisparo) {
		conjuntoDisparo.add(co);
		return conjuntoDisparo;
	}

}

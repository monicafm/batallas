package batalla.tablero;

import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;

public class Coordenada {
	private int x;
	private int y;

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordenada() {
		this(0, 0);
	}
	
	public static Coordenada leerCoordenada() {

		int x = 0;
		int y = 0;
		Scanner teclado = null;
		
		try {
			System.out.print("Introducir fila y columna (ejemplo 1-10): ");
			teclado = new Scanner(System.in).useDelimiter("\\W");

			x = teclado.nextInt() - 1;
			y = teclado.nextInt() - 1;

		} catch (InputMismatchException e) {
			System.out.println("La coordenada esta mal introducida...");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Se sale del batalla.tablero...");
		} finally {
			if (teclado != null) {
				teclado.close();
			}
		}
		return new Coordenada(x, y);
	}

	public void coordenadaAleatoria() {
		x = (int) (Math.random() * 10);
		y = (int) (Math.random() * 10);
	}

	public int getCoordenadaX() {
		return x;
	}

	public int getCoordenadaY() {
		return y;
	}

	public void setCoordenadaX(int nuevaX) {
		x = nuevaX;
	}

	public void setCoordenadaY(int nuevaY) {
		y = nuevaY;
	}
}

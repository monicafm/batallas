
package batalla;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;

public class Coordenada {
    private int x=0;
    private int y=0;
    private int[] coordenada = {x,y};
    
    public void coordenada(){
                          			
                try {
					System.out.print("Introducir fila y columna (ejemplo 1-10): ");					  
					Scanner teclado= new Scanner(System.in).useDelimiter("\\W");
					
					    x=teclado.nextInt()-1;
					    y=teclado.nextInt()-1;
				
				} catch (InputMismatchException e ) {
					
					System.out.println("La coordenada esta mal introducida...");
				} catch ( ArrayIndexOutOfBoundsException e ) {
					
					System.out.println("Se sale del tablero...");
				} 
    }
    public void coordenadaAleatoria(){
        x=(int)(Math.random()*10);
        y=(int)(Math.random()*10);
    }
    
    public int getCoordenadaX(){
        return x;
    }
    
    public int getCoordenadaY(){
        return y;
    }
    
    public void setCoordenadaX(int nuevaX){
        x=nuevaX;
    }
    
    public void setCoordenadaY(int nuevaY){
        y=nuevaY;
    }
   
}


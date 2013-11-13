/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.Scanner;

/**
 *
 * @author monica
 */
public class Coordenada {
    private int x=0;
    private int y=0;
    private int[] coordenada = {x,y};
    //private int nuevaX;
    //private int nuevaY;
    
    public void Coordenada(){
        boolean restriccion;
        
               //do{ 

                System.out.print("Introducir fila y columna (ejemplo 1-10): ");
                  
                Scanner teclado= new Scanner(System.in).useDelimiter("\\W");//

                    x=teclado.nextInt()-1;
                    //x=x-1;//se resta 1 porque el usuario no tiene en cuenta la fila 0
                    y=teclado.nextInt()-1;
                    //y=y-1;//se resta 1 porque el usuario no tiene en cuenta la columna 0
                   /*
                    restriccion=false;
                    if (x<0){
                       restriccion= true;
                    }
                    if (x>GlobalConstants.ALTO_MAX_TABLERO-1){
                       restriccion= true; 
                    }
                    if (y<0){
                        restriccion= true;       
                    }
                    if(y>GlobalConstants.ANCHO_MAX_TABLERO-1){
                        restriccion= true;
                    }
                }while(restriccion==true);
                */
    }
    public void coordenadaAleatoria(){
        x=(int)(Math.random()*10);
        y=(int)(Math.random()*10);
        //System.out.print(x+","+y+"; ");
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
    public void imprimirCoordenada(){
    	System.out.println("fila-columna: "+x+"-"+y);
    }
}


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
public class Orientacion {
    String orientacion;

     public void Orientacion(){
        //String orientacion;
        String cadena1="h";
        String cadena2="v";
        while (true){
                System.out.print("Introducir orientación horizontal (h) o vertical (v): ");
                Scanner tecla= new Scanner(System.in);
        
                orientacion=tecla.next();
                
            if (orientacion.equalsIgnoreCase(cadena1)){
                break;
            }
            if (orientacion.equalsIgnoreCase(cadena2)){
                break;
            }        
        }
        //orient=orientacion;
        //return orientacion;
    }
    public void OrientacionAleatoria(){
        //String orientacion;
        String cadena1="h";
        String cadena2="v";
        int repartirOrientacion;//de 0 a 4 la orientación será horizontal de 4 a 9 vertical
        repartirOrientacion=(int)(Math.random()*10);
        if (repartirOrientacion<4){
            orientacion="h";
        }
        else{
            orientacion="v";
        }
        //orient=orientacion;
        //return orientacion;
    }
    public String getOrientacion(){
        return orientacion;
    }
}


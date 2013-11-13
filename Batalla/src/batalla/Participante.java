/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.ArrayList;

/**
 *
 * @author monica
 */
abstract class Participante {
    
    private int tam;
    
    /*
    private Submarino sub1=new Submarino();//privado 
    private Submarino sub2=new Submarino();
    private Fragata fra1=new Fragata();
    private Fragata fra2=new Fragata();
    private Acorazado aco1=new Acorazado();
    private Acorazado aco2=new Acorazado();
    private Portaaviones porta=new Portaaviones();
    */
    Coordenada disparo;
    Coordenada disparoAleatorio;
    
    private Tablero tableroBarcosJugador;
    private Tablero tableroDisparoJugador;
    
    
    //private Barco [] flota= {sub1,sub2,fra1,fra2,aco1,aco2,porta};
   
    public Participante(){}
    public abstract void posicionarFlota();
   // public abstract ArrayList<Coordenada> getPosicionesOcupadasFlota();
    //public abstract void realizarDisparo(Coordenada c,ArrayList<Coordenada> aL);
    //public abstract void anotarDisparo(Coordenada c);
    
    public ArrayList<Barco> getFlota(Barco ba){
   	 ArrayList<Barco> flotilla= new ArrayList<Barco>();
   	 
   	 flotilla.add(ba);
   	
   	return flotilla;
   }

    public boolean realizarDisparo(Coordenada coorde,ArrayList<Coordenada> flota) {
        boolean resultadoDisparo=false;
        
        for (Coordenada coor: flota){
                    if(coorde.getCoordenadaX()==coor.getCoordenadaX()){
                        if(coorde.getCoordenadaY()==coor.getCoordenadaY()){
                            resultadoDisparo=true;                     
                        }
                    }
         }
        return resultadoDisparo;
    }
    
    public boolean comprobarDisparo(Coordenada c,ArrayList<Coordenada> arrayCoorde){
        boolean disparoValido=true;
        for (Coordenada aC: arrayCoorde){
            if(c.getCoordenadaX()==aC.getCoordenadaX()){
                if(c.getCoordenadaY()==aC.getCoordenadaY()){
                    disparoValido=false;
                }
            }                   
        }
        return disparoValido;
    }
    public void anotarDisparo(Coordenada c,Tablero t) {
    }

}


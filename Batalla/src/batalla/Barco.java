/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author monica
 */
public abstract class Barco {
    protected int tamano; /* contendrá la longitud del barco*/
    private String orientacion;
    Coordenada[] barc;
    private int coorX;
    private int coorY;
    private Coordenada[] posicion ; /*contiene la lista de las posiciones ocupadas por el barco*/
    private boolean posicionAlcanzada []; /*contiene las casillas alcanzadas*/
    
    ArrayList<Coordenada> posicionesOcupadasBarco;//= new ArrayList<Coordenada>();
    ArrayList<Coordenada> posicionesPerimetralesBarco;
       
    
    
    /*crear un barco consta de:
     * -solicitar la 1º coordenada
     * -solicitar la orientación
     * -completar automáticamente todas las posiciones
     */
    
    public Barco(int tamano){
        this.tamano=tamano;
    }
     public boolean cabidaTablero(Coordenada c,String o,int tamano){
        boolean resultado=false;//false: el barco no sale del tablero
        if(o.equalsIgnoreCase("h")){//si el barco es horizontal crece sobre las las columnas       
            if (c.getCoordenadaY()+tamano>GlobalConstants.ANCHO_MAX_TABLERO){
                resultado=true;//true el barco sale del tablero
                System.out.println("El barco no cabe en el tablero. Piense en otra coordenada u orientacion inicial...");
            }    
        } else{
            if(c.getCoordenadaX()+tamano>GlobalConstants.ALTO_MAX_TABLERO){
                resultado=true;
                System.out.println("El barco no cabe en el tablero. Piense en otra coordenada u orientacion inicial...");
            }    
        }        
        return resultado;
    }
    public boolean comprobarBarco(ArrayList<Coordenada> arrayBarco,ArrayList<Coordenada> arrayFlota,ArrayList<Coordenada> arrayPerimetro){
        boolean resultado= false;// falso= no hay coordenadas coincidentes
        for(Coordenada co: arrayBarco){
            //el barco no ocupa una posicione de otro barco
            for (Coordenada coo: arrayFlota){
                    if(co.getCoordenadaX()==coo.getCoordenadaX()){
                        if(co.getCoordenadaY()==coo.getCoordenadaY()){
                             System.out.println("Hay posiciones que ya están ocupadas por un barco. Piense en otra localización...");
                             resultado=true;
                        }
                }
            }
            //el barco no ocupa el perímetro de otro barco
            for (Coordenada coor: arrayPerimetro){
                    if(co.getCoordenadaX()==coor.getCoordenadaX()){
                        if(co.getCoordenadaY()==coor.getCoordenadaY()){
                             System.out.println("Hay posiciones que invade el perímetro de algún barco.Piense en otra localización...");
                             resultado=true;
                        }
                }
            }
        }
        return resultado;
    }
    
    public ArrayList<Coordenada> getPosicionesBarco(Coordenada c,String o){ //si
               
        coorX=c.getCoordenadaX();
        coorY=c.getCoordenadaY();

        barc = new Coordenada[tamano];
  
        for (int i=0; i<tamano; i++){
            barc[i]=new Coordenada();
        }       
              
        barc[0].setCoordenadaX(coorX); 
        barc[0].setCoordenadaY(coorY);
        
        orientacion=o;
        for (int i=1; i<tamano; i++){
            /*si orientacion es horizontal*/
            if (orientacion.equalsIgnoreCase("h")){
                
                coorX=barc[i-1].getCoordenadaX();
                barc[i].setCoordenadaX(coorX);
                
                coorY=barc[i-1].getCoordenadaY()+1;
                barc[i].setCoordenadaY(coorY);
                
                if (coorY>GlobalConstants.ALTO_MAX_TABLERO){System.out.println("el barco se sale del tablero");}
            }
            else if (orientacion.equalsIgnoreCase("v")){
            /*si orientacion es vertical*/            
                coorX=barc[i-1].getCoordenadaX()+1;
                barc[i].setCoordenadaX(coorX);
                
                coorY=barc[i-1].getCoordenadaY();
                barc[i].setCoordenadaY(coorY);
                
                if (coorX>GlobalConstants.ANCHO_MAX_TABLERO){System.out.println("el barco se sale del tablero");}
            }
        }       
        posicionesOcupadasBarco= new ArrayList<Coordenada>();
        
        for (int i=0;i<barc.length;i++){
            posicionesOcupadasBarco.add(barc[i]);
        }
        return posicionesOcupadasBarco;
    }
    public Coordenada[] getBarcoConstruido(){//si
        return barc;
    }
    public void imprimirBarco(){//si
        //System.out.println();
        //System.out.print("las coordenadas que ocupa dicho barco son: ");
        for (int i=0; i<barc.length;i++){
            System.out.println("Coordenada ["+i+"] "+barc[i].getCoordenadaX()+"-"+barc[i].getCoordenadaY()+"; ");
            //barc[i].imprimirCoordenada();
             //barco[i].getBarco().getCoordenadaX();
        }
        System.out.println("longitud del barco: "+barc.length);
    }
    
    /*
     * método que meta las posiciones de barco en un arrayList y calcule sus posiciones perimetrales.
     */
    public ArrayList<Coordenada> getPosicionesReservadasBarco(){//NO
         posicionesOcupadasBarco= new ArrayList<Coordenada>();
        
        for (int i=0;i<barc.length;i++){
            posicionesOcupadasBarco.add(barc[i]);
        }
        return posicionesOcupadasBarco;
    }
    
    public ArrayList<Coordenada> getPosicionesPerimetroBarco(){//si
        
    int posEncimaX;
    int posEncimaY;
    int posDelanteX;
    int posDelanteY;
    int posDebajoX;
    int posDebajoY;
    int posDetrasX;
    int posDetrasY;       
        //para barcos horizontales
    Coordenada delanteH= new Coordenada();
    Coordenada detrasH= new Coordenada();
    Coordenada[] encimaH= new Coordenada[barc.length];
    Coordenada[] debajoH=new Coordenada[barc.length];
        //para barcos verticales
    Coordenada encimaV=new Coordenada();
    Coordenada debajoV=new Coordenada();
    Coordenada[] delanteV=new Coordenada[barc.length];
    Coordenada[] detrasV=new Coordenada[barc.length];
        
        /* Repetido
        posicionesOcupadasBarcos= new ArrayList<Coordenada>();
        
        for (int i=0;i<barc.length;i++){
            posicionesOcupadasBarcos.add(barc[i]);
        }
     * 
     */
        
        posicionesPerimetralesBarco= new ArrayList<Coordenada>();
        
        
                
        if (orientacion.equalsIgnoreCase("h")){//esto está pensado para un barco horizontal
            for (int i=0;i<barc.length;i++){                           
                debajoH[i]=new Coordenada();
                encimaH[i]=new Coordenada();
            }
            
           //posicion delante del barco. Sólo hay una coordenada
           if((barc[0].getCoordenadaY()!=0)){//si el barco no empieza en la columna 0 del tablero tiene una posición perimetral delante
              posDelanteY=barc[0].getCoordenadaY()-1;
              delanteH.setCoordenadaX(barc[0].getCoordenadaX());
              delanteH.setCoordenadaY(posDelanteY);
              posicionesPerimetralesBarco.add(delanteH); 
           }
           if(barc[barc.length-1].getCoordenadaY()!=GlobalConstants.ANCHO_MAX_TABLERO){//si el barco no termina en la última columna del tablero
               //posicion detrás del barco. Sólo hay una coordenada
               posDetrasY=barc[barc.length-1].getCoordenadaY()+1;
               detrasH.setCoordenadaX(barc[barc.length-1].getCoordenadaX());
               detrasH.setCoordenadaY(posDetrasY);
               posicionesPerimetralesBarco.add(detrasH);
           }                                
           for (int i=0;i<barc.length;i++){
                if(barc[0].getCoordenadaX()!=0){
                    //posiciones encima
                        posEncimaX=barc[i].getCoordenadaX()-1;
                        encimaH[i].setCoordenadaX(posEncimaX);
                        encimaH[i].setCoordenadaY(barc[i].getCoordenadaY());
                        posicionesPerimetralesBarco.add(encimaH[i]);
                }
                if(barc[0].getCoordenadaX()!=GlobalConstants.ALTO_MAX_TABLERO){
                    //posiciones debajo
                        posDebajoX=barc[i].getCoordenadaX()+1;
                        debajoH[i].setCoordenadaX(posDebajoX);
                        debajoH[i].setCoordenadaY(barc[i].getCoordenadaY());
                        posicionesPerimetralesBarco.add(debajoH[i]);
                }
            }
        }
        else {//barco vertical
            for (int i=0;i<barc.length;i++){           
                delanteV[i]=new Coordenada();
                detrasV[i]=new Coordenada();
            }
            if((barc[0].getCoordenadaX()!=0)){//si el barco no empieza en la fila 0 del tablero tiene una posición perimetral encima
              posEncimaX=barc[0].getCoordenadaX()-1;
              encimaV.setCoordenadaX(posEncimaX);
              encimaV.setCoordenadaY(barc[0].getCoordenadaY());
              posicionesPerimetralesBarco.add(encimaV); 
           }
           if(barc[barc.length-1].getCoordenadaX()!=GlobalConstants.ALTO_MAX_TABLERO){//si el barco no termina en la última fila del tablero
               //posicion debajo del barco. Sólo hay una coordenada
               posDebajoX=barc[barc.length-1].getCoordenadaX()+1;//se trabaja con la última posición
               debajoV.setCoordenadaX(posDebajoX);
               debajoV.setCoordenadaY(barc[barc.length-1].getCoordenadaY());
               posicionesPerimetralesBarco.add(debajoV);
           }
           for (int i=0;i<barc.length;i++){
                if(barc[0].getCoordenadaY()!=0){
                    //posiciones delante
                        //posDelanteX=barc[i].getCoordenadaX();
                        posDelanteY=barc[i].getCoordenadaY()-1;
                        delanteV[i].setCoordenadaX(barc[i].getCoordenadaX());
                        delanteV[i].setCoordenadaY(posDelanteY);                       
                        posicionesPerimetralesBarco.add(delanteV[i]);
                }
                if(barc[0].getCoordenadaY()!=GlobalConstants.ANCHO_MAX_TABLERO){
                    //posiciones detras
                        //posDetrasX=barc[i].getCoordenadaX();
                        posDetrasY=barc[i].getCoordenadaY()+1;
                        detrasV[i].setCoordenadaX(barc[i].getCoordenadaX());
                        detrasV[i].setCoordenadaY(posDetrasY);    
                        posicionesPerimetralesBarco.add(detrasV[i]);
                }
            }
        }
        return posicionesPerimetralesBarco;
    
    }
    public void imprimirPosProhibidas(){//sí

        Iterator ite=posicionesOcupadasBarco.iterator();
        System.out.print("posiciones ocupadas: ");
        while(ite.hasNext()){
            Object recorrerCoor =ite.next();
            Coordenada recor= (Coordenada) recorrerCoor;
            System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
        }
        System.out.println();
        Iterator it=posicionesPerimetralesBarco.iterator();
        System.out.print("posiciones perimetrales: ");
        while(it.hasNext()){
            Object recorrerCoor =it.next();
            Coordenada recor= (Coordenada) recorrerCoor;
            System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+"); ");
        }
        System.out.println();
    }
    
    boolean barcoAlcanzado (Coordenada coord) {return true;/*jeje*/} /*indica si la coordenada que se le pasa pertenece o no al barco*/
    boolean barcoHundido(){
        boolean hundido=true;
        /*for (Coordenada c: posicionLista){
            if (!posicionesAlcanzadasLista.contains(c)){
                hundido=false;
                break;
            }
        }
        */
        return hundido;
    } /*indica si el barco esta hundido o no*/
    
   
}

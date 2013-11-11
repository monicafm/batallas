/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author monica
 */
public class Persona extends Participante{
    private Tablero tableroBarcosPersona;
    private Tablero tableroDisparoPersona;
    
    private Coordenada coordPersona;
    private Orientacion orientacionPersona;
    private Barco submarinoPersona2;
    private Barco fragataPersona1;
    private Barco acorazadoPersona1;
    private Barco portaavionesPersona;
    private ArrayList<Coordenada> posicionesOcupadasFlota;
    private ArrayList<Coordenada> posicionesPerimetralesFlota;
    private Coordenada disparoPersona;
    
    @Override
    public void posicionarFlota() {
        posicionesOcupadasFlota= new ArrayList();
        posicionesPerimetralesFlota= new ArrayList();
        
        tableroBarcosPersona= new Tablero();
        tableroBarcosPersona.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
       
        //throw new UnsupportedOperationException("Not supported yet.");
        
        System.out.println("");
        
        //SOLICITAR SUBMARINOS
        System.out.println();
        System.out.println("Posicione su flota: ");
        for (int i=0;i<GlobalConstants.NUMERO_SUBMARINOS;i++){
            do{
                System.out.println();
                System.out.println("SUBMARINO "+(i+1));
                //solicitar coordenada
                do{
                coordPersona=new Coordenada();
                coordPersona.Coordenada();
                
                //solicitar orientación
                orientacionPersona=new Orientacion();
                orientacionPersona.Orientacion();
                //crear 1 barco permitido y devolver sus posiciones 
                submarinoPersona2= new Submarino();
                }while (submarinoPersona2.cabidaTablero(coordPersona, orientacionPersona.getOrientacion(),GlobalConstants.TAMANO_SUBMARINO)==true);
                //comprobamos que las coordenadas elegidas no están ocupadas
            }while (submarinoPersona2.comprobarBarco(submarinoPersona2.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()), posicionesOcupadasFlota, posicionesPerimetralesFlota)==true);
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(submarinoPersona2.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            tableroBarcosPersona.imprimirTableroBarcos();            
            //construir un barco y almacenar sus posiciones en un array de posiciones de flota
            for (int j=0;j<submarinoPersona2.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()).size();j++){
                posicionesOcupadasFlota.add(submarinoPersona2.posicionesOcupadasBarco.get(j));
            }
            //calcular las posiciones de perímetro de barco y almacenarlas en array de perímetro de flota
            for (int k=0;k<submarinoPersona2.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlota.add(submarinoPersona2.posicionesPerimetralesBarco.get(k));
            }
        }
               
        //SOLICITAR FRAGATAS
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_FRAGATAS;i++){
            do{      
            System.out.println("FRAGATA "+(i+1));
                do{
                    coordPersona=new Coordenada();
                    coordPersona.Coordenada();               
                    orientacionPersona=new Orientacion();
                    orientacionPersona.Orientacion();
                    fragataPersona1= new Fragata();
                }while (fragataPersona1.cabidaTablero(coordPersona, orientacionPersona.getOrientacion(),GlobalConstants.TAMANO_FRAGATA)==true);
            }while (fragataPersona1.comprobarBarco(fragataPersona1.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()), posicionesOcupadasFlota, posicionesPerimetralesFlota)==true);
            tableroBarcosPersona.colocarBarcoEnTablero(fragataPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_FRAGATA);
            tableroBarcosPersona.imprimirTableroBarcos();
            for (int j=0;j<fragataPersona1.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()).size();j++){
                posicionesOcupadasFlota.add(fragataPersona1.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<fragataPersona1.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlota.add(fragataPersona1.posicionesPerimetralesBarco.get(k));
            }
        } 
                       
        //SOLICITAR ACORAZADOS
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_ACORAZADOS;i++){
            do{      
                System.out.println("ACORAZADO "+(i+1));
                do{
                    coordPersona=new Coordenada();
                    coordPersona.Coordenada();               
                    orientacionPersona=new Orientacion();
                    orientacionPersona.Orientacion();
                    acorazadoPersona1= new Acorazado();
                }while (acorazadoPersona1.cabidaTablero(coordPersona, orientacionPersona.getOrientacion(),GlobalConstants.TAMANO_ACORAZADO)==true);
            }while (acorazadoPersona1.comprobarBarco(acorazadoPersona1.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()), posicionesOcupadasFlota, posicionesPerimetralesFlota)==true);
            tableroBarcosPersona.colocarBarcoEnTablero(acorazadoPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_ACORAZADO);
            tableroBarcosPersona.imprimirTableroBarcos();
            for (int j=0;j<acorazadoPersona1.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()).size();j++){
                posicionesOcupadasFlota.add(acorazadoPersona1.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<acorazadoPersona1.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlota.add(acorazadoPersona1.posicionesPerimetralesBarco.get(k));
            }
        }
               
        //PORTAAVIONES
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_PORTAAVIONES;i++){
            do{      
                System.out.println("PORTAAVIONES "+(i+1));
                do{            
                    coordPersona=new Coordenada();
                    coordPersona.Coordenada();               
                    orientacionPersona=new Orientacion();
                    orientacionPersona.Orientacion();
                    portaavionesPersona= new Portaaviones();
                }while (portaavionesPersona.cabidaTablero(coordPersona, orientacionPersona.getOrientacion(),GlobalConstants.TAMANO_PORTAAVIONES)==true);
            }while (portaavionesPersona.comprobarBarco(portaavionesPersona.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()), posicionesOcupadasFlota, posicionesPerimetralesFlota)==true);
            tableroBarcosPersona.colocarBarcoEnTablero(portaavionesPersona.getBarcoConstruido(),GlobalConstants.TAMANO_PORTAAVIONES);
            tableroBarcosPersona.imprimirTableroBarcos();
            for (int j=0;j<portaavionesPersona.getPosicionesBarco(coordPersona,orientacionPersona.getOrientacion()).size();j++){
                posicionesOcupadasFlota.add(portaavionesPersona.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<portaavionesPersona.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlota.add(portaavionesPersona.posicionesPerimetralesBarco.get(k));
            }
        }       
       
    }
    
    public ArrayList<Coordenada> getPosicionesOcupadasFlota(){
        return posicionesOcupadasFlota; 
    }
    public void mostrarTableroBarcosFlota(){
    	tableroBarcosPersona.imprimirTableroBarcos();
    }
    
    public void imprimirPosicionesOcupadasTablero(){
        
        Iterator itera=posicionesOcupadasFlota.iterator();
        System.out.println();
        System.out.print("***posiciones ocupadas por barcos de la Flota: ");
        while(itera.hasNext()){
            Object recorrerCoor =itera.next();
            Coordenada recor= (Coordenada) recorrerCoor;
            System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
        }
        
        Iterator iter=posicionesPerimetralesFlota.iterator();
        System.out.println();
        System.out.print("***posiciones perimetrales de la Flota: ");
        while(iter.hasNext()){
            Object recorrerCoor =iter.next();
            Coordenada recor= (Coordenada) recorrerCoor;
            System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
        }
        
    }

    public Coordenada crearDisparo(){
        disparoPersona= new Coordenada();
        disparoPersona.Coordenada();
        
        return disparoPersona;
    }

    
    
}


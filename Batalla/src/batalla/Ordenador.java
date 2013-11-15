/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author monica
 */
public class Ordenador extends Participante{
    
    private Coordenada coordOrdenador;
    //private Orientacion orientacionOrdenador;
    private Barco submarinoOrdenador;
    private Barco fragataOrdenador;
    private Barco acorazadoOrdenador;
    private Barco portaavionesOrdenador;
    
    private Tablero tableroBarcosOrdenador;
    
	private ArrayList<Coordenada> aSubOrdenador=new ArrayList<Coordenada>();
	private ArrayList<Coordenada> aFraOrdenador=new ArrayList<Coordenada>();
	private ArrayList<Coordenada> aAcoOrdenador=new ArrayList<Coordenada>();
	private ArrayList<Coordenada> aPortaOrdenador=new ArrayList<Coordenada>();
    
    private ArrayList<Barco> flotaOrdenador;
    private ArrayList<Coordenada[]>flotaO;
    private ArrayList<Coordenada> posicionesOcupadasFlotaOrdenador;
    private ArrayList<Coordenada> posicionesPerimetralesFlotaOrdenador;
    
    private ArrayList<Coordenada> disparoListo;
    
    private String resultadoDisparoOrdenador;
    
    @Override
    public void posicionarFlota() {
    	
    	String orientacionAleatoria="";
        coordOrdenador=null;
        
        aSubOrdenador=null;
        aFraOrdenador=null;
        aAcoOrdenador=null;
        aPortaOrdenador=null;
    	
        tableroBarcosOrdenador= new Tablero();
        tableroBarcosOrdenador.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
    	flotaOrdenador=new ArrayList<Barco>();
    	flotaO= new ArrayList<Coordenada[]>();
        posicionesOcupadasFlotaOrdenador= new ArrayList<Coordenada>();
        posicionesPerimetralesFlotaOrdenador= new ArrayList<Coordenada>();
        
    
        //SUBMARINO ORDENADOR
        for (int i=0;i<GlobalConstants.NUMERO_SUBMARINOS;i++){
            do{
            	
                orientacionAleatoria=pedirOrientacionAleatoria();
                coordOrdenador= coordenadaValidaAleatoria(orientacionAleatoria,GlobalConstants.TAMANO_SUBMARINO);
                
                submarinoOrdenador= new Submarino();             
                aSubOrdenador=submarinoOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria);
                
            }while (submarinoOrdenador.comprobarBarco(aSubOrdenador, posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador));
                      
            //colocar barco en el tablero 
            tableroBarcosOrdenador.colocarBarcoEnTablero(submarinoOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            
            flotaOrdenador=getFlota(submarinoOrdenador);//??
            flotaO=getFlotaO(submarinoOrdenador.getBarcoConstruido());
            posicionesOcupadasFlotaOrdenador= getPosicionesOcupadasFlotaOrdenador(aSubOrdenador);
            posicionesPerimetralesFlotaOrdenador= getPosicionesPerimetralesFlotaOrdenador(submarinoOrdenador);            
        }
        
      //FRAGATA ORDENADOR   
        for (int i=0;i<GlobalConstants.NUMERO_FRAGATAS;i++){
            do{
                orientacionAleatoria=pedirOrientacionAleatoria();
                coordOrdenador= coordenadaValidaAleatoria(orientacionAleatoria,GlobalConstants.TAMANO_FRAGATA);
                
                fragataOrdenador= new Fragata();           
                aFraOrdenador=fragataOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria);
                
            }while (fragataOrdenador.comprobarBarco(aFraOrdenador, posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador));
                        
            //colocar barco en el tablero 
            tableroBarcosOrdenador.colocarBarcoEnTablero(fragataOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_FRAGATA); 
            
            flotaOrdenador=getFlota(fragataOrdenador);//??
            flotaO=getFlotaO(fragataOrdenador.getBarcoConstruido());
            posicionesOcupadasFlotaOrdenador= getPosicionesOcupadasFlotaOrdenador(aFraOrdenador);
            posicionesPerimetralesFlotaOrdenador= getPosicionesPerimetralesFlotaOrdenador(fragataOrdenador);
        
        }
                
        //ACORAZADO ORDENADOR
        for (int i=0;i<GlobalConstants.NUMERO_ACORAZADOS;i++){
            do{               
                orientacionAleatoria=pedirOrientacionAleatoria();
                coordOrdenador= coordenadaValidaAleatoria(orientacionAleatoria,GlobalConstants.TAMANO_ACORAZADO);
                
                acorazadoOrdenador= new Acorazado();          
                aAcoOrdenador=acorazadoOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria);
                
            }while (acorazadoOrdenador.comprobarBarco(aAcoOrdenador, posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador));
                        
            //colocar barco en el tablero 
            tableroBarcosOrdenador.colocarBarcoEnTablero(acorazadoOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_ACORAZADO);  
            
            flotaOrdenador=getFlota(acorazadoOrdenador);//??
            flotaO=getFlotaO(acorazadoOrdenador.getBarcoConstruido());
            posicionesOcupadasFlotaOrdenador= getPosicionesOcupadasFlotaOrdenador(aAcoOrdenador);
            posicionesPerimetralesFlotaOrdenador= getPosicionesPerimetralesFlotaOrdenador(acorazadoOrdenador);
           
        }
        

        //PORTAAVIONES ORDENADOR
        for (int i=0;i<GlobalConstants.NUMERO_PORTAAVIONES;i++){
            do{
                //System.out.println();
                //System.out.println("ACORAZADO "+(i+1));
                
                orientacionAleatoria=pedirOrientacionAleatoria();
                coordOrdenador= coordenadaValidaAleatoria(orientacionAleatoria,GlobalConstants.TAMANO_PORTAAVIONES);
                
                portaavionesOrdenador= new Portaaviones();         
                aPortaOrdenador=portaavionesOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria);
                
            }while (portaavionesOrdenador.comprobarBarco(aPortaOrdenador, posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador));
            
            
            //colocar barco en el tablero 
            tableroBarcosOrdenador.colocarBarcoEnTablero(portaavionesOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_PORTAAVIONES);
            //PRUEBA-ELIMINAR
            tableroBarcosOrdenador.imprimirTableroBarcos();  
            //FIN PRUEBA-ELIMINAR
            
            flotaOrdenador=getFlota(portaavionesOrdenador);//??
            flotaO=getFlotaO(portaavionesOrdenador.getBarcoConstruido());
            posicionesOcupadasFlotaOrdenador= getPosicionesOcupadasFlotaOrdenador(aPortaOrdenador);
            posicionesPerimetralesFlotaOrdenador= getPosicionesPerimetralesFlotaOrdenador(portaavionesOrdenador);
        
            //PRUEBA-ELIMINAR
            Iterator<Coordenada> itera=posicionesOcupadasFlotaOrdenador.iterator();
            System.out.println();
            System.out.print("***posiciones ocupadas por barcos de la Flota: ");
            while(itera.hasNext()){
                Object recorrerCoor =itera.next();
                Coordenada recor= (Coordenada) recorrerCoor;
                System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
            }            
            Iterator<Coordenada> iter=posicionesPerimetralesFlotaOrdenador.iterator();
            System.out.println();
            System.out.print("***posiciones perimetrales de la Flota: ");
            while(iter.hasNext()){
                Object recorrerCoor =iter.next();
                Coordenada recor= (Coordenada) recorrerCoor;
                System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
            }
            System.out.println();
            //FIN PRUEBA-ELIMINAR          
            
        }
        
    }
    
    
    
    public Coordenada crearDisparoAleatorio(){
    	int x;
    	int y;
        disparoAleatorio=new Coordenada();
        disparoAleatorio.coordenadaAleatoria();

       return disparoAleatorio; 
    }
    public void mostrarDisparoAleatorio(Coordenada c){
    	int x;
    	int y;
        
        x=c.getCoordenadaX();//la persona nombra a las filas y columnas empezando en el 1
        y=c.getCoordenadaY();
        //System.out.println("antes: ("+x+","+y+")");

        System.out.print("mostrar ("+(x+1)+","+(y+1)+")");
    }
    
    public void crearDisparoListo(Coordenada c){
    	disparoListo= new ArrayList();
    	Coordenada lista=new Coordenada();
    	
    	//disparo a la casilla de arriba
    	lista.setCoordenadaX(c.getCoordenadaX()-1);
    	lista.setCoordenadaY(c.getCoordenadaY());
    	    	
    	disparoListo.add(1,lista);
    	//disparo a la casilla de la derecha
    	lista.setCoordenadaX(c.getCoordenadaX());
    	lista.setCoordenadaY(c.getCoordenadaY()+1);
    	    	
    	disparoListo.add(2,lista);
    	
    	//disparo a la casilla de abajo
    	lista.setCoordenadaX(c.getCoordenadaX()+1);
    	lista.setCoordenadaY(c.getCoordenadaY());
    	    	
    	disparoListo.add(3,lista);
    	
    	//disparo a la casilla de la izquierda
    	lista.setCoordenadaX(c.getCoordenadaX());
    	lista.setCoordenadaY(c.getCoordenadaY()-1);
    	    	
    	disparoListo.add(4,lista);
    	
    	
    }
    public ArrayList<Coordenada> getDisparoListo(){
    	return disparoListo;
    }
    public String solicitarResultadoDisparo(){
    
        while (true) {
        System.out.println("¿agua (A), tocado (T), hundido (H)?");
        
        Scanner tecleo= new Scanner(System.in);	        
        resultadoDisparoOrdenador=tecleo.next();
        
	        if (resultadoDisparoOrdenador.equalsIgnoreCase("A")){
	        	System.out.println("agua");
	        	break;
	        }
	        if (resultadoDisparoOrdenador.equalsIgnoreCase("T")){	        	
	        	System.out.println("tocado");
	        	break;
	        } 
	        if (resultadoDisparoOrdenador.equalsIgnoreCase("H")){
	        	System.out.println("hundido");
	        	break;
	        }
	        }
    	return resultadoDisparoOrdenador;
    }
    
    public Coordenada coordenadaValidaAleatoria(String o,int tamano){//teniendo la orientacion y el tamaño del barco pide una coordenada hasta que sea válida
    	
        Coordenada coordOrdenador=new Coordenada();
        boolean resultado=false;
        
        do{
	        //solicitar coordenada	
	        coordOrdenador.coordenadaAleatoria();
	        
	        resultado=false;
	        if(o.equalsIgnoreCase("h")){//si el barco es horizontal crece sobre las las columnas       
	            if (coordOrdenador.getCoordenadaY()+tamano>GlobalConstants.ANCHO_MAX_TABLERO){
	                resultado=true;//true el barco sale del tablero
	            }    
	        } else{
	            if(coordOrdenador.getCoordenadaX()+tamano>GlobalConstants.ALTO_MAX_TABLERO){
	                resultado=true;
	            }    
	        }
        }while(resultado==true);
        return coordOrdenador;
    }
    
    public String pedirOrientacionAleatoria(){
    	String orientacionAleatoria="";
    	
        int repartirOrientacion;//de 0 a 4 la orientación será horizontal de 4 a 9 vertical
        repartirOrientacion=(int)(Math.random()*10);
        
        if (repartirOrientacion<4){
            orientacionAleatoria="h";
        }
        else{
            orientacionAleatoria="v";
        }
    	
    	return orientacionAleatoria;
    }
    
    public ArrayList<Coordenada> getPosicionesOcupadasFlotaOrdenador(ArrayList<Coordenada> al){
    	for (int j=0;j<al.size();j++){
    		posicionesOcupadasFlotaOrdenador.add(al.get(j));
    	}
        return posicionesOcupadasFlotaOrdenador; 
    }
    
    public ArrayList<Coordenada> getPosicionesOcupadasFlotaOrdenador(){
    	return posicionesOcupadasFlotaOrdenador; 
    }
    
    public ArrayList<Coordenada[]> getFlotaO(){
      	return flotaO;
    }
    
    public ArrayList<Coordenada[]> getFlotaO(Coordenada[] barco){
    	//ArrayList<Coordenada[]> flot;
      	flotaO.add(barco);
      	return flotaO;
    }
    

    
    public ArrayList<Coordenada> getPosicionesPerimetralesFlotaOrdenador(Barco ba){
    	for (int k=0;k<ba.getPosicionesPerimetroBarco().size();k++){
    		posicionesPerimetralesFlotaOrdenador.add(ba.posicionesPerimetralesBarco.get(k));
        }   	
        return posicionesPerimetralesFlotaOrdenador; 
    }
    
    public Coordenada disparar(ArrayList<Coordenada> conjuntoDisparos){// crea un disparo y comprueba que no fue usado
    	Coordenada disparo=new Coordenada();
    	boolean resultado= false;
    	     	
    	do{
    		System.out.print("El disparo del ordenador es: ");
        	disparo.coordenadaAleatoria();
        	mostrarDisparoAleatorio(disparo);
        	resultado=comprobarConjuntoDisparos(disparo, conjuntoDisparos);
    	}while(resultado);
    	
    	return disparo;
    }
}


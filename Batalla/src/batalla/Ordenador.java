/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author monica
 */
public class Ordenador extends Participante{
    
    private Coordenada coordOrdenador;
    private Orientacion orientacionOrdenador;
    private Barco submarinoOrdenador;
    private Barco fragataOrdenador;
    private Barco acorazadoOrdenador;
    private Barco portaavionesOrdenador;
    
    private Tablero tableroBarcosOrdenador;
    
    private ArrayList<Coordenada> posicionesOcupadasFlotaOrdenador;
    private ArrayList<Coordenada> posicionesPerimetralesFlotaOrdenador;
    
    private ArrayList<Coordenada> disparoListo;
    
    private String resultadoDisparoOrdenador;
    
    @Override
    public void posicionarFlota() {
    	String orientacionAleatoria="";
        posicionesOcupadasFlotaOrdenador= new ArrayList();
        posicionesPerimetralesFlotaOrdenador= new ArrayList();
        
        tableroBarcosOrdenador= new Tablero();
        tableroBarcosOrdenador.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
       
        //SUBMARINO ORDENADOR
        System.out.println();
        System.out.println("el ordenador posiciona su flota...");
        for (int i=0;i<GlobalConstants.NUMERO_SUBMARINOS;i++){
            do{      
                do{
                	
                    coordOrdenador=new Coordenada();
                    coordOrdenador.coordenadaAleatoria();
                    
                    orientacionAleatoria= pedirOrientacionAleatoria();
                    
                    submarinoOrdenador= new Submarino();
                }while (submarinoOrdenador.cabidaTablero(coordOrdenador, orientacionAleatoria,GlobalConstants.TAMANO_SUBMARINO)==true);
            }while (submarinoOrdenador.comprobarBarco(submarinoOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria), posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador)==true);
            tableroBarcosOrdenador.colocarBarcoEnTablero(submarinoOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            //tableroBarcosOrdenador.imprimirTableroBarcos();
            for (int j=0;j<submarinoOrdenador.getPosicionesBarco(coordOrdenador,orientacionAleatoria).size();j++){
                posicionesOcupadasFlotaOrdenador.add(submarinoOrdenador.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<submarinoOrdenador.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlotaOrdenador.add(submarinoOrdenador.posicionesPerimetralesBarco.get(k));
            }
        } 
        
        //FRAGATA ORDENADOR
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_FRAGATAS;i++){
            do{      
                do{
                    coordOrdenador=new Coordenada();
                    coordOrdenador.coordenadaAleatoria();;               
                    orientacionOrdenador=new Orientacion();
                    orientacionOrdenador.OrientacionAleatoria();
                    fragataOrdenador= new Fragata();
                }while (fragataOrdenador.cabidaTablero(coordOrdenador, orientacionOrdenador.getOrientacion(),GlobalConstants.TAMANO_FRAGATA)==true);
            }while (fragataOrdenador.comprobarBarco(fragataOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()), posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador)==true);
            tableroBarcosOrdenador.colocarBarcoEnTablero(fragataOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_FRAGATA);
            //tableroBarcosOrdenador.imprimirTableroBarcos();
            for (int j=0;j<fragataOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()).size();j++){
                posicionesOcupadasFlotaOrdenador.add(fragataOrdenador.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<fragataOrdenador.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlotaOrdenador.add(fragataOrdenador.posicionesPerimetralesBarco.get(k));
            }
        } 
        
        //ACORAZADO ORDENADOR
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_ACORAZADOS;i++){
            do{      
                do{
                    coordOrdenador=new Coordenada();
                    coordOrdenador.coordenadaAleatoria();;               
                    orientacionOrdenador=new Orientacion();
                    orientacionOrdenador.OrientacionAleatoria();
                    acorazadoOrdenador= new Acorazado();
                }while (acorazadoOrdenador.cabidaTablero(coordOrdenador, orientacionOrdenador.getOrientacion(),GlobalConstants.TAMANO_ACORAZADO)==true);
            }while (acorazadoOrdenador.comprobarBarco(acorazadoOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()), posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador)==true);
            tableroBarcosOrdenador.colocarBarcoEnTablero(acorazadoOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_ACORAZADO);
            //tableroBarcosOrdenador.imprimirTableroBarcos();
            for (int j=0;j<acorazadoOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()).size();j++){
                posicionesOcupadasFlotaOrdenador.add(acorazadoOrdenador.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<acorazadoOrdenador.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlotaOrdenador.add(acorazadoOrdenador.posicionesPerimetralesBarco.get(k));
            }
        } 
        
        //PORTAAVIONES ORDENADOR
        System.out.println();
        for (int i=0;i<GlobalConstants.NUMERO_PORTAAVIONES;i++){
            do{      
                do{
                    coordOrdenador=new Coordenada();
                    coordOrdenador.coordenadaAleatoria();;               
                    orientacionOrdenador=new Orientacion();
                    orientacionOrdenador.OrientacionAleatoria();
                    portaavionesOrdenador= new Portaaviones();
                }while (portaavionesOrdenador.cabidaTablero(coordOrdenador, orientacionOrdenador.getOrientacion(),GlobalConstants.TAMANO_PORTAAVIONES)==true);
            }while (portaavionesOrdenador.comprobarBarco(portaavionesOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()), posicionesOcupadasFlotaOrdenador, posicionesPerimetralesFlotaOrdenador)==true);
            tableroBarcosOrdenador.colocarBarcoEnTablero(portaavionesOrdenador.getBarcoConstruido(),GlobalConstants.TAMANO_PORTAAVIONES);
            System.out.println("   Tablero de barcos del Ordenador:");
            tableroBarcosOrdenador.imprimirTableroBarcos();//este tablero no debe visualizarse. es para comprobar
            for (int j=0;j<portaavionesOrdenador.getPosicionesBarco(coordOrdenador,orientacionOrdenador.getOrientacion()).size();j++){
                posicionesOcupadasFlotaOrdenador.add(portaavionesOrdenador.posicionesOcupadasBarco.get(j));
            }
            for (int k=0;k<portaavionesOrdenador.getPosicionesPerimetroBarco().size();k++){
                posicionesPerimetralesFlotaOrdenador.add(portaavionesOrdenador.posicionesPerimetralesBarco.get(k));
            }
        } 
        
       
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public ArrayList<Coordenada> getPosicionesOcupadasFlota(){
        return posicionesOcupadasFlotaOrdenador;
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

        System.out.print("("+(x+1)+","+(y+1)+")");
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
    public void solicitarResultadoDisparo(){

        while (true){
        System.out.println("¿agua (A), tocado(T), hundido(H)?. Introduzca A, T o H.");
        
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
}


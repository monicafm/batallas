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
    private ArrayList<Coordenada> aSubPersona;
    private ArrayList<Barco> flota;
    
    @Override
    public void posicionarFlota() {
    	
    	flota= new ArrayList<Barco>();
        posicionesOcupadasFlota= new ArrayList<Coordenada>();       
        posicionesPerimetralesFlota= new ArrayList<Coordenada>();
        
        aSubPersona=new ArrayList<Coordenada>();
        
        tableroBarcosPersona= new Tablero();
        tableroBarcosPersona.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
       
        //throw new UnsupportedOperationException("Not supported yet.");
        
        System.out.println("");
        
        String orientacion="";
        Coordenada coordPersona=null;
        //ArrayList<Coordenada> subPersona= null;
        //posicionesOcupadasFlota=null;
        //posicionesPerimetralesFlota=null;
        aSubPersona=null;
        
        
        System.out.println();
        System.out.println("Posicione su flota: ");
        
      //SOLICITAR SUBMARINOS
        for (int i=0;i<GlobalConstants.NUMERO_SUBMARINOS;i++){
            do{
                System.out.println();
                System.out.println("SUBMARINO "+(i+1));
                
                orientacion=pedirOrientacion();
                coordPersona= coordenadaValida(orientacion,GlobalConstants.TAMANO_SUBMARINO);
                
                submarinoPersona2= new Submarino();             
                aSubPersona=submarinoPersona2.getPosicionesBarco(coordPersona,orientacion);
                
            }while (submarinoPersona2.comprobarBarco(aSubPersona, posicionesOcupadasFlota, posicionesPerimetralesFlota)==true);
            System.out.print("aquí");
            
            
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(submarinoPersona2.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flota=getFlota(submarinoPersona2);
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aSubPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(submarinoPersona2);
        
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
    
    public ArrayList<Barco> getFlota(Barco ba){
    	 ArrayList<Barco> flotilla= new ArrayList<Barco>();
    	 
    	 flotilla.add(ba);
    	
    	return flotilla;
    }

    public ArrayList<Coordenada> getPosicionesOcupadasFlota2(ArrayList<Coordenada> al){
    	for (int j=0;j<al.size();j++){
            posicionesOcupadasFlota.add(al.get(j));
    	}
        return posicionesOcupadasFlota; 
    }
    public ArrayList<Coordenada> getPosicionesOcupadasFlota(){
        return posicionesOcupadasFlota;
    }
    
    public ArrayList<Coordenada> getPosicionesPerimetralesFlota2(Barco ba){	
    	
    	for (int k=0;k<ba.getPosicionesPerimetroBarco().size();k++){
            posicionesPerimetralesFlota.add(ba.posicionesPerimetralesBarco.get(k));
        }
    	
        return posicionesPerimetralesFlota; 
    }
    
    
    public ArrayList<Coordenada> getPosicionesPerimetralesFlota(){	
        return posicionesPerimetralesFlota; 
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

    public String pedirOrientacion(){
    	
        String horizontal="h";
        String vertical="v";
        Boolean valida=false;
        
        String orientacion="";
        
        
           while (!valida){
        	   System.out.print("Introducir orientación horizontal (h) o vertical (v): ");
               Scanner tecla= new Scanner(System.in);
           
               orientacion=tecla.next();
               valida=orientacion.equalsIgnoreCase(horizontal)||orientacion.equalsIgnoreCase(vertical);                      
           }
           return orientacion;
    }
    public Coordenada pedirCoordenada(){
    	Coordenada coordenada=null;
    	int x=0;
    	int y=0;	
        boolean restriccion;
        
        	do{ 
        		restriccion=false;
        		coordenada= new Coordenada();
        		coordenada.Coordenada();
        		//tiene que ser en minúscula
            	x=coordenada.getCoordenadaX();            	
            	y=coordenada.getCoordenadaY();
            	System.out.println("x e y: "+x+","+y);
            		
                if (x<0){ restriccion= true;}
                if (x>GlobalConstants.ALTO_MAX_TABLERO-1){restriccion= true;}
                if (y<0){restriccion= true;}
                if(y>GlobalConstants.ANCHO_MAX_TABLERO-1){restriccion= true;}
             }while(restriccion==true);
        	
       return coordenada;
    }
    public Coordenada coordenadaValida(String o,int tamano){//teniendo la orientacion y el tamaño del barco pide una coordenada hasta que sea válida
    	    	
        Coordenada coordPersona=null;
        boolean resultado=false;
        
        do{
	        //solicitar coordenada	
	        coordPersona=pedirCoordenada();              	         
	        resultado=false;
	        if(o.equalsIgnoreCase("h")){//si el barco es horizontal crece sobre las las columnas       
	            if (coordPersona.getCoordenadaY()+tamano>GlobalConstants.ANCHO_MAX_TABLERO){
	                resultado=true;//true el barco sale del tablero
	                System.out.println("El barco no cabe en el tablero. Piense en otra coordenada u orientacion inicial...");
	            }    
	        } else{
	            if(coordPersona.getCoordenadaX()+tamano>GlobalConstants.ALTO_MAX_TABLERO){
	                resultado=true;
	                System.out.println("El barco no cabe en el tablero. Piense en otra coordenada u orientacion inicial...");
	            }    
	        }
        }while(resultado==true);
        return coordPersona;
    }
    
    public boolean comprobarBarco2(String o, int tamano,ArrayList<Coordenada> arrayFlota,ArrayList<Coordenada> arrayPerimetro){//MAL
        boolean resultado= false;// falso= no hay coordenadas coincidentes
        Coordenada coordenada= null;
        Coordenada[] barco;
        //ArrayList<Coordenada> subPersona; 
        do{
        	resultado=false;
        	coordenada= coordenadaValida(o,tamano);
        	;
        	ArrayList<Coordenada> arrayBarco;
        	arrayBarco= new ArrayList();
        	
        	//subPersona= new ArrayList();
        	//barco= barc.getPosicionesBarco2(coordenada,o);
        	
        	for(Coordenada co: arrayBarco){
                //el barco no ocupa una posicione de otro barco
                for (Coordenada coo: arrayFlota){
                        if(co.getCoordenadaX()==coo.getCoordenadaX()){
                            if(co.getCoordenadaY()==coo.getCoordenadaY()){                           
                                 resultado=true;
                            }
                    }
                }
                
                //el barco no ocupa el perímetro de otro barco
                for (Coordenada coor: arrayPerimetro){
                        if(co.getCoordenadaX()==coor.getCoordenadaX()){
                            if(co.getCoordenadaY()==coor.getCoordenadaY()){                            
                                 resultado=true;
                            }
                    }
                }
            }
        	
        
        
        if (resultado==true){
        	System.out.println("Hay posiciones que ya están ocupadas por un barco o en su perímetro. Piense en otra localización...");
        }
        
        }while (resultado==true);
        
        return true;
    }
    
    
}



package batalla;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class Persona extends Participante{
    private Tablero tableroBarcosPersona;
    private Tablero tableroDisparoPersona;
    
    private Coordenada coordPersona;
    private Barco submarinoPersona2;
    private Barco fragataPersona1;
    private Barco acorazadoPersona1;
    private Barco portaavionesPersona;
    private List<Coordenada> posicionesOcupadasFlota;
    private List<Coordenada> posicionesPerimetralesFlota;
    private Coordenada disparoPersona;
    
    private List<Coordenada> aSubPersona;
    private List<Coordenada> aFraPersona;
    private List<Coordenada> aAcoPersona;
    private List<Coordenada> aPortaPersona;
    
    private ArrayList<Coordenada[]> flotaP;
    
    
    @Override
    public void posicionarFlota() {
    	
    	flotaP= new ArrayList<Coordenada[]>();
        posicionesOcupadasFlota= new ArrayList<Coordenada>();       
        posicionesPerimetralesFlota= new ArrayList<Coordenada>();
        
        aSubPersona=new ArrayList<Coordenada>();
        aFraPersona=new ArrayList<Coordenada>();
        aAcoPersona=new ArrayList<Coordenada>();
        aPortaPersona=new ArrayList<Coordenada>();
        
        tableroBarcosPersona= new Tablero();
        tableroBarcosPersona.tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
   
        String orientacion="";
        Coordenada coordPersona=null;

        aSubPersona=null;
        aFraPersona=null;
        aAcoPersona=null;
        aPortaPersona=null;
        boolean resultado=false;
        
        System.out.println();
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
                
                resultado=submarinoPersona2.comprobarBarco(aSubPersona, posicionesOcupadasFlota, posicionesPerimetralesFlota);
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su perimetro. Piense en otra localizacion...");}
            
            }while (resultado);
            
            tableroBarcosPersona.colocarBarcoEnTablero(submarinoPersona2.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flotaP=getFlotaP(submarinoPersona2.getBarcoConstruido());
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aSubPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(submarinoPersona2);        
        }
               
        //SOLICITAR FRAGATAS       
        for (int i=0;i<GlobalConstants.NUMERO_FRAGATAS;i++){
            do{
                System.out.println();
                System.out.println("FRAGATA "+(i+1));
                
                orientacion=pedirOrientacion();
                coordPersona= coordenadaValida(orientacion,GlobalConstants.TAMANO_FRAGATA);
                
                fragataPersona1= new Fragata();             
                aFraPersona=fragataPersona1.getPosicionesBarco(coordPersona,orientacion);
                
                resultado=fragataPersona1.comprobarBarco(aFraPersona, posicionesOcupadasFlota, posicionesPerimetralesFlota);
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su perimetro. Piense en otra localizacion...");}
            
            }while (resultado);
            
            tableroBarcosPersona.colocarBarcoEnTablero(fragataPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_FRAGATA);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flotaP=getFlotaP(fragataPersona1.getBarcoConstruido());
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aFraPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(fragataPersona1);        
        }
                       
        //SOLICITAR ACORAZADOS        
        for (int i=0;i<GlobalConstants.NUMERO_ACORAZADOS;i++){
            do{
                System.out.println();
                System.out.println("ACORAZADO "+(i+1));
                
                orientacion=pedirOrientacion();
                coordPersona= coordenadaValida(orientacion,GlobalConstants.TAMANO_ACORAZADO);
                
                acorazadoPersona1= new Acorazado();            
                aAcoPersona=acorazadoPersona1.getPosicionesBarco(coordPersona,orientacion);
                
                resultado=acorazadoPersona1.comprobarBarco(aAcoPersona, posicionesOcupadasFlota, posicionesPerimetralesFlota);
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su perimetro. Piense en otra localizacion...");}
            
            }while (resultado);
                        
            tableroBarcosPersona.colocarBarcoEnTablero(acorazadoPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_ACORAZADO);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flotaP=getFlotaP(acorazadoPersona1.getBarcoConstruido());
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aAcoPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(acorazadoPersona1);       
        }
               
        //PORTAAVIONES        
        for (int i=0;i<GlobalConstants.NUMERO_PORTAAVIONES;i++){
            do{
                System.out.println();
                System.out.println("PORTAAVIONES "+(i+1));
                
                orientacion=pedirOrientacion();
                coordPersona= coordenadaValida(orientacion,GlobalConstants.TAMANO_PORTAAVIONES);
                
                portaavionesPersona= new Portaaviones();           
                aPortaPersona=portaavionesPersona.getPosicionesBarco(coordPersona,orientacion);
                
                resultado=portaavionesPersona.comprobarBarco(aPortaPersona, posicionesOcupadasFlota, posicionesPerimetralesFlota);
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su perimetro. Piense en otra localizacion...");}
            
            }while (resultado);
            
            tableroBarcosPersona.colocarBarcoEnTablero(portaavionesPersona.getBarcoConstruido(),GlobalConstants.TAMANO_PORTAAVIONES);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flotaP=getFlotaP(portaavionesPersona.getBarcoConstruido());
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aPortaPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(portaavionesPersona);       
        }
  
    }

    public void mostrarTableroBarcosFlota(){
    	System.out.println();
    	System.out.println("Compruebe el disparo en su... ");  	
    	tableroBarcosPersona.imprimirTableroBarcos();
    }
    
    public void anotarEnTableroBarcos(Coordenada c, boolean b){
    	tableroBarcosPersona.anotarDisparoEnTableroBarcos(c,b);
    }
    
    public void imprimirPosicionesOcupadasTablero(){//***
        
        Iterator<Coordenada> itera=posicionesOcupadasFlota.iterator();
        System.out.println();
        System.out.print("***posiciones ocupadas por barcos de la Flota: ");
        while(itera.hasNext()){
            Object recorrerCoor =itera.next();
            Coordenada recor= (Coordenada) recorrerCoor;
            System.out.print("("+recor.getCoordenadaX()+","+recor.getCoordenadaY()+("); "));
        }
        
        Iterator<Coordenada> iter=posicionesPerimetralesFlota.iterator();
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
        disparoPersona.coordenada();
        
        return disparoPersona;
    }

    public String pedirOrientacion(){
    	
        String horizontal="h";
        String vertical="v";
        Boolean valida=false;
        
        String orientacion="";
                
           while (!valida){
        	   System.out.print("Introducir orientacion horizontal (h) o vertical (v): ");
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
        		coordenada.coordenada();
        		
            	x=coordenada.getCoordenadaX();            	
            	y=coordenada.getCoordenadaY();
            		
                if (x<0){ restriccion= true;}
                if (x>GlobalConstants.ALTO_MAX_TABLERO-1){restriccion= true;}
                if (y<0){restriccion= true;}
                if(y>GlobalConstants.ANCHO_MAX_TABLERO-1){restriccion= true;}
             }while(restriccion==true);
        	
       return coordenada;
    }
    public Coordenada coordenadaValida(String o,int tamano){
    //teniendo la orientacion y el tamaño del barco se pide una coordenada hasta que sea válida
    	    	
        Coordenada coordPersona=null;
        boolean resultado=false;
        
        do{
	        coordPersona=pedirCoordenada();              	         
	        resultado=false;
	        if(o.equalsIgnoreCase("h")){//si es horizontal crece sobre las las columnas       
	            if (coordPersona.getCoordenadaY()+tamano>GlobalConstants.ANCHO_MAX_TABLERO){
	                resultado=true;//true el barco sale del tablero
	                System.out.println("El barco no cabe en el tablero. Piense otra coordenada u orientacion inicial...");
	            }    
	        } else{
	            if(coordPersona.getCoordenadaX()+tamano>GlobalConstants.ALTO_MAX_TABLERO){
	                resultado=true;
	                System.out.println("El barco no cabe en el tablero. Piense otra coordenada u orientacion inicial...");
	            }    
	        }
        }while(resultado==true);
        return coordPersona;
    }
       
    
    public ArrayList<Coordenada[]> getFlotaP(){
      	return flotaP;
    }
    
    public ArrayList<Coordenada[]> getFlotaP(Coordenada[] barco){
      	flotaP.add(barco);
      	return flotaP;
    }
    
    public List<Coordenada> getPosicionesOcupadasFlota2(List<Coordenada> al){    	
    	for (int j=0;j<al.size();j++){
    		posicionesOcupadasFlota.add(al.get(j));
    	}
        return posicionesOcupadasFlota; 
    }
    
    public List<Coordenada> getPosicionesOcupadasFlota(){    	
        return posicionesOcupadasFlota; 
    }
    
    public List<Coordenada> getPosicionesPerimetralesFlota2(Barco ba){    	
    	for (int k=0;k<ba.getPosicionesPerimetroBarco().size();k++){
    		posicionesPerimetralesFlota.add(ba.posicionesPerimetralesBarco.get(k));
        }    	
        return posicionesPerimetralesFlota; 
    }
    
    
    public Coordenada disparar(List<Coordenada> conjuntoDisparos){
    	//crea un disparo y comprueba que no fue usado
    	Coordenada disparo=new Coordenada();
    	boolean resultado;
    	     	
    	do{
    		resultado=false;  		
    		System.out.print("Piense en su disparo... ");
        	disparo=pedirCoordenada();
        	resultado=comprobarConjuntoDisparos(disparo, conjuntoDisparos);
    	}while(resultado);
    	    	
    	return disparo;
    }
    
    public boolean comprobarHundido(List<Coordenada[]> flota, Tablero tablero){
    	boolean devolverHundido=false;	
    	
    	for (Coordenada[] barc: flota){//para cada barco de la flota
    		int longitud=barc.length;
	    	int fila;
	    	int columna;
	    	boolean estCasilla=false;
	    	boolean estCasillaFinal=false;
	    	boolean hundido=true;
	    	 
	    	for (int i=0; i<longitud;i++){
	    		fila=barc[i].getCoordenadaX();
	    		columna=barc[i].getCoordenadaY();
	    		estCasilla=tablero.devolverEstadosCasilla(fila,columna);
	    		if(estCasilla){//si la coordenada esta tocada
	    			hundido=true;
	    		}else{	    	
	    			hundido=false;
	    			break;
	    		}
	    		//si la última coordenada está tocada implica hundido  
	    		estCasillaFinal=tablero.devolverEstadosCasilla(barc[longitud-1].getCoordenadaX(),barc[longitud-1].getCoordenadaY());    		
	    		if(hundido && estCasillaFinal){//aquí sólo se llega con todas las coordenadas hundido true
	    			 System.out.println("Hundido!!");
	    			 devolverHundido=true;
	    			 tablero.anotarHundido(barc[longitud-1].getCoordenadaX(),barc[longitud-1].getCoordenadaY());
	    		}       	 	        		 
	    	}       	
	    }
	    return devolverHundido;
    }
    
    public boolean salir(){
    	System.out.print("Desea salir? introduzca S o N: ");					  
		Scanner teclad= new Scanner(System.in).useDelimiter("\\W");
		if (teclad.hasNext("S")||teclad.hasNext("s")){
			return true;//terminar juego
		}else{
			return false;
		}   
    }
}


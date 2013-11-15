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
    private ArrayList<Coordenada> aFraPersona;
    private ArrayList<Coordenada> aAcoPersona;
    private ArrayList<Coordenada> aPortaPersona;
    
    private ArrayList<Barco> flota;
    private ArrayList<Coordenada[]> flotaP;
    
    @Override
    public void posicionarFlota() {
    	
    	flota= new ArrayList<Barco>();
    	flotaP= new ArrayList<Coordenada[]>();
        posicionesOcupadasFlota= new ArrayList<Coordenada>();       
        posicionesPerimetralesFlota= new ArrayList<Coordenada>();
        
        aSubPersona=new ArrayList<Coordenada>();
        aFraPersona=new ArrayList<Coordenada>();
        aAcoPersona=new ArrayList<Coordenada>();
        aPortaPersona=new ArrayList<Coordenada>();
        
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
        aFraPersona=null;
        aAcoPersona=null;
        aPortaPersona=null;
        boolean resultado=false;
        
        
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
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su per�metro. Piense en otra localizaci�n...");}
            
            }while (resultado);
            
            
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(submarinoPersona2.getBarcoConstruido(),GlobalConstants.TAMANO_SUBMARINO);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flota=getFlota(submarinoPersona2);//??
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
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su per�metro. Piense en otra localizaci�n...");}
            
            }while (resultado);
            
            
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(fragataPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_FRAGATA);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flota=getFlota(fragataPersona1);//??
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
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su per�metro. Piense en otra localizaci�n...");}
            
            }while (resultado);
            
            
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(acorazadoPersona1.getBarcoConstruido(),GlobalConstants.TAMANO_ACORAZADO);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flota=getFlota(acorazadoPersona1);//??
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
                if (resultado){System.out.println("Hay posiciones ya ocupadas por un barco o en su per�metro. Piense en otra localizaci�n...");}
            
            }while (resultado);
            
            
            //colocar barco en el tablero 
            tableroBarcosPersona.colocarBarcoEnTablero(portaavionesPersona.getBarcoConstruido(),GlobalConstants.TAMANO_PORTAAVIONES);
            tableroBarcosPersona.imprimirTableroBarcos();    
            
            flota=getFlota(portaavionesPersona);//??
            flotaP=getFlotaP(portaavionesPersona.getBarcoConstruido());
            posicionesOcupadasFlota= getPosicionesOcupadasFlota2(aPortaPersona);
            posicionesPerimetralesFlota= getPosicionesPerimetralesFlota2(portaavionesPersona);
        
        }
        

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
    /*
    public ArrayList<Barco> getFlota(Barco ba){
    	 ArrayList<Barco> flotilla= new ArrayList<Barco>();
    	 
    	 flotilla.add(ba);
    	
    	return flotilla;
    }
    */


    public void mostrarTableroBarcosFlota(){
    	System.out.println();
    	System.out.print("Comprueba el disparo. Este es su...");
    	tableroBarcosPersona.imprimirTableroBarcos();
    }
    
    public void imprimirPosicionesOcupadasTablero(){
        
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
        	   System.out.print("Introducir orientaci�n horizontal (h) o vertical (v): ");
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
        		//tiene que ser en min�scula
            	x=coordenada.getCoordenadaX();            	
            	y=coordenada.getCoordenadaY();
            		
                if (x<0){ restriccion= true;}
                if (x>GlobalConstants.ALTO_MAX_TABLERO-1){restriccion= true;}
                if (y<0){restriccion= true;}
                if(y>GlobalConstants.ANCHO_MAX_TABLERO-1){restriccion= true;}
             }while(restriccion==true);
        	
       return coordenada;
    }
    public Coordenada coordenadaValida(String o,int tamano){//teniendo la orientacion y el tama�o del barco pide una coordenada hasta que sea v�lida
    	    	
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
                
                //el barco no ocupa el per�metro de otro barco
                for (Coordenada coor: arrayPerimetro){
                        if(co.getCoordenadaX()==coor.getCoordenadaX()){
                            if(co.getCoordenadaY()==coor.getCoordenadaY()){                            
                                 resultado=true;
                            }
                    }
                }
            }
        	
        
        
        if (resultado==true){
        	System.out.println("Hay posiciones que ya est�n ocupadas por un barco o en su per�metro. Piense en otra localizaci�n...");
        }
        
        }while (resultado==true);
        
        return true;
    }
    
    public ArrayList<Coordenada[]> getFlotaP(){
      	return flotaP;
    }
    
    public ArrayList<Coordenada[]> getFlotaP(Coordenada[] barco){
    	//ArrayList<Coordenada[]> flot;
      	flotaP.add(barco);
      	return flotaP;
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
    
    /*
     * me falta un m�todo que me permita ver que hay algo dentro de flota... iterar...
     */
    
    public Coordenada disparar(ArrayList<Coordenada> conjuntoDisparos){// crea un disparo y comprueba que no fue usado
    	Coordenada disparo=new Coordenada();
    	boolean resultado;
    	     	
    	do{
    		resultado=false;//??   		
    		System.out.print("Piense en su disparo... ");
        	disparo.coordenada();
        	//System.out.println("coor:"+disparo.getCoordenadaX()+","+disparo.getCoordenadaY());
        	resultado=comprobarConjuntoDisparos(disparo, conjuntoDisparos);
    	}while(resultado);
    	
    	//System.out.println(" salgo del bucle coor:"+disparo.getCoordenadaX()+","+disparo.getCoordenadaY());
    	return disparo;
    }
}


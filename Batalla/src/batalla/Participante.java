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
    
    public ArrayList<Barco> getFlota(){
      	 ArrayList<Barco> flotilla= new ArrayList<Barco>();
      	
      	return flotilla;
      }
  

    public boolean aciertaEnCoordenadaContraria(Coordenada coorde,ArrayList<Coordenada> flota) {//este método debería devolver tocado, hundido o agua para poder comprobar con la respuesta de persona 
        boolean resultadoDisparo=false;
        
        for (Coordenada coor: flota){
                    if(coorde.getCoordenadaX()==coor.getCoordenadaX()){
                        if(coorde.getCoordenadaY()==coor.getCoordenadaY()){
                            resultadoDisparo=true;
                            System.out.println("método aciertaEnCoordenadaContraria");                         
                        }
                    }
         }
        return resultadoDisparo;
    }
    
    public boolean esTocado(Coordenada c, ArrayList<Barco> flota){
    	Coordenada[] barc;
    	boolean tocado=false;
    	
    	System.out.println("entra en método es tocado");
    	for (Barco fl: flota){//para cada barco de la flota
    		barc=fl.getBarcoConstruido();
    		//para cada coordenada de cada barco
    		System.out.println("entra en 1º for del método es tocado");
    		
    		for (int i=0; i<barc.length;i++){
                System.out.println("Coordenada ["+i+"] "+barc[i].getCoordenadaX()+"-"+barc[i].getCoordenadaY()+"; ");
                //barc[i].imprimirCoordenada();
                 //barco[i].getBarco().getCoordenadaX();
            }
    		
    		   		
    	}
    return tocado;	
    }
    
    public void marcarTocados(Coordenada c, ArrayList<Coordenada[]> flota){// paso disparo y los barcos que son arrays de coordenadas
    	 	
    	for (Coordenada[] fl: flota){//para cada barco de la flota    		
    		    		
    		for (int i=0; i<fl.length;i++){
    			if(fl[i].getCoordenadaX()==c.getCoordenadaX()){
    				if(fl[i].getCoordenadaY()==c.getCoordenadaY()){
    					
    					fl[i].setCoordenadaX(100);//marco cada coordenada
    					fl[i].setCoordenadaY(100);
    				}
    			}
            }   		    		   		
    	}
    	
    	for (Coordenada[] fl: flota){//para cada barco de la flota
    		
    		
    		    		   		
    		for (int i=0; i<fl.length;i++){  			
    			if(fl[i].getCoordenadaX()==100 && fl[i].getCoordenadaY()==100){
    					System.out.println("las nuevas coordenadas son ["+i+"] "+fl[i].getCoordenadaX()+"-"+fl[i].getCoordenadaY()+"; ");
    			}   			       		    		   		
    		}
    	}
    	      	
    //return tocado;	
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
    
    public boolean comprobarConjuntoDisparos(Coordenada c,ArrayList<Coordenada> arrayCoorde){
        boolean disparo=false;
        for (Coordenada aC: arrayCoorde){
            if(c.getCoordenadaX()==aC.getCoordenadaX()){
                if(c.getCoordenadaY()==aC.getCoordenadaY()){
                    disparo=true;
                }
            }                   
        }
        return disparo;
    }
    
    public ArrayList<Coordenada> añadirDisparo(Coordenada co, ArrayList<Coordenada> conjuntoDisparo){
    	conjuntoDisparo.add(co);
    	return conjuntoDisparo;
    }

}


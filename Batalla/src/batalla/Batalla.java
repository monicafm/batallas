/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import batalla.Coordenada;

import java.util.Iterator;
import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

/**
 *
 * @author monica
 */
public class Batalla {
    
    /**
     * @param args the command line arguments
     */
	
    
    public static void main(String[] args) {

        // TODO code application logic here
        
        Coordenada disPersona;
        Coordenada disOrdenador;
        ArrayList<Coordenada> flotaPersona;
        ArrayList<Coordenada> flotaOrdenador;
        ArrayList<Barco> flotaOrd;
        ArrayList<Coordenada[]> flotaO;
        Tablero tableroDisparoPersona;
        Tablero tableroBarcosP;
        Tablero taberoDisparoOrdenador;
        
        ArrayList<Coordenada> conjuntoDisparosPersona;
        
        ArrayList<Coordenada> conjuntoDisparosOrdenador;
        
        boolean acierto;
        
        //crear flota persona
        Persona persona=new Persona();
        persona.posicionarFlota();
        
        
        flotaPersona= new ArrayList<Coordenada>();
        flotaPersona=persona.getPosicionesOcupadasFlota();
        
        
        //crear flota ordenador
        Ordenador ordenador=new Ordenador();
        ordenador.posicionarFlota();// este m�todo nos ense�a el tablero de barcos del ordenador, es de prueba, no se visualizar�
       
        flotaOrdenador=new ArrayList<Coordenada>();
        flotaOrdenador=ordenador.getPosicionesOcupadasFlotaOrdenador();
        
        flotaOrd=new ArrayList<Barco>();
        flotaOrd= ordenador.getFlota();
        flotaO=new ArrayList<Coordenada[]>();
        flotaO= ordenador.getFlotaO();
        
        String respuesta="";
        //disparos - tablero persona
        
        
        
        //disPersona= new Coordenada();
        //System.out.print("Piense en su disparo... ");
        //disPersona= persona.crearDisparo();//se crea el primer disparo de la persona
        conjuntoDisparosPersona=new ArrayList<Coordenada>();
        conjuntoDisparosOrdenador=new ArrayList<Coordenada>();
        //conjuntoDisparosPersona.add(disPersona);//a�ado el primer disparo
        
        tableroDisparoPersona= new Tablero();
        tableroDisparoPersona.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        //acierto=false;
        
        for(int i=0;i<2;i++){
        //disparo Persona
        disPersona=persona.disparar(conjuntoDisparosPersona);
        conjuntoDisparosPersona=persona.a�adirDisparo(disPersona,conjuntoDisparosPersona);
        
        
        /*
         * es un disparo certero? dispara la persona contra la flota del ordenador
         * compruebo el disparo en el array de coordenadas (aciertaEnCoordenadaContraria(disparo,flotaContraria) o en el array de barcos?
         * tengo que cambiar mi tablero de disparos y mostrarlo (antes de disparar tambien tengo que mostrar mi tablero de disparos)
         * como cambio tocado a hundido??
         * 
         * 
         */
        //tableroDisparoPersona.imprimirTableroDisparos();//se muestra el tablero de disparos      
       
        //persona.aciertaEnCoordenadaContraria(disPersona,flotaOrdenador);
        //persona.esTocado(disPersona,flotaOrd);//??
        
        acierto=persona.aciertaEnCoordenadaContraria(disPersona,flotaOrdenador);
        tableroDisparoPersona.anotarDisparoEnTablero(disPersona,acierto);//se apunta el disparo
        tableroDisparoPersona.imprimirTableroDisparos();
        persona.marcarTocados(disPersona,flotaO);//las coordenadas acertadas se cambian a 100 
        }
           
        
        //disparo Ordenador
        disOrdenador=ordenador.disparar(conjuntoDisparosOrdenador);
        conjuntoDisparosOrdenador=ordenador.a�adirDisparo(disOrdenador,conjuntoDisparosOrdenador);
        persona.mostrarTableroBarcosFlota();
        respuesta=ordenador.solicitarResultadoDisparo();
        System.out.println("esta es la respuesta: "+respuesta);
        
        
        /*
         * m�todo que recoja la respuesta de persona y la del m�todo acierta y las compruebe..
         */
        
        acierto=ordenador.aciertaEnCoordenadaContraria(disOrdenador, flotaPersona);
        
        //es disparo certero? dispara el ordenador contra la flota de la persona
        
        /*
         * el disparo del ordenador:
         * -se elige coordenada aleatoria y se comprueba que no fue usada antes
         * -se comprueba la coordenada aleatoria v�lida contra la flotaPersona:
         * --se pide a la persona que conteste (tenemos que mostrarle antes el tablero de barcos persona)
         * --comprobamos que la contestaci�n es correcta
         * -anotamos dicha contestaci�n sobre el tablero de barcos persona
         * -si es tocado o hundido se repite el disparo del ordenador
         * -si es tocado el disparo tiene que ser un disparo listo / si es hundido es disparo aleatorio
         */
        
/*
       //DISPARO PERSONA
	        if(persona.realizarDisparo(disPersona,flotaOrdenador)==true){//devuelve verdadero si es tocado
	            do{
	                System.out.println("tocado");
	                System.out.println();
	                tableroDisparoPersona.anotarDisparoEnTablero(disPersona,true);//se apunta el disparo
	                tableroDisparoPersona.imprimirTableroDisparos();//se muestra el tablero de disparos
	                do{
	                	System.out.println("Dispare. ");
	                	disPersona=persona.crearDisparo();//nuevo disparo
		                if (persona.comprobarDisparo(disPersona, conjuntoDisparosPersona)==true){//se comprueba que es v�lido y se guarda para no repetirlo
		                    conjuntoDisparosPersona.add(disPersona);
		                    
		                }else {
		                    System.out.println("el disparo es repetido.Piense en otro... ");
		                    System.out.println();
		                }
	                }while(persona.comprobarDisparo(disPersona, conjuntoDisparosPersona)==true);// hay que decir que no repita disparo
                 
	            }while (persona.realizarDisparo(disPersona,flotaOrdenador)==true);
	            //el disparo TOCA un barco
	            //informo de tocado
	            //modifico el tablero
	            //solicito nueva coordenada
	        }
	        if (persona.realizarDisparo(disPersona,flotaOrdenador)==false){
	            System.out.println("agua");
	            System.out.println();
	            tableroDisparoPersona.anotarDisparoEnTablero(disPersona,false);
	            tableroDisparoPersona.imprimirTableroDisparos();
	        }
	        
	    //DISPARO ORDENADOR
	    disOrdenador= new Coordenada();
	    System.out.println();
	    System.out.print("Recuerde la posici�n de su flota: ");
	    persona.mostrarTableroBarcosFlota();

	    System.out.print("Disparo del Ordenador: ");
	    disOrdenador=ordenador.crearDisparoAleatorio();// se crea el primer disparo del ordenador OJO
	    ordenador.mostrarDisparoAleatorio(disOrdenador);
	    
	    conjuntoDisparosOrdenador=new ArrayList();//se crea el array donde se almacenar�n los disparos del ordenador
	    conjuntoDisparosOrdenador.add(disOrdenador);//a�ado el primer disparo   

	    ordenador.solicitarResultadoDisparo();//se le pide a la persona que conteste si el disparo toc�, hundi� o resulto ser agua
	        
	    //m�todo para comprobar que la persona dice la verdad
	        
	    if (ordenador.realizarDisparo(disOrdenador, flotaPersona)==true){//No funciona     	
	        System.out.println("aqu�. tocado");
	        //faltan las restricciones para hundido
	    }else{
	        System.out.println("agua");
	    }       
*/
        

        
    }
    

    
    
}


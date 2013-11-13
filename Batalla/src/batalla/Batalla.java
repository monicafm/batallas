/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import batalla.Coordenada;

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
        Tablero tableroDisparoPersona;
        Tablero tableroBarcosP;
        Tablero taberoDisparoOrdenador;
        
        ArrayList<Coordenada> conjuntoDisparosPersona;
        ArrayList<Coordenada> conjuntoDisparosOrdenador;
        
        
        //crear flota persona
        Persona persona=new Persona();
        persona.posicionarFlota();
        
        
        //flotaPersona= new ArrayList();
        //flotaPersona=persona.getPosicionesOcupadasFlota();
        
        
        //crear flota ordenador
        Ordenador ordenador=new Ordenador();
        ordenador.posicionarFlota();// este método nos enseña el tablero de barcos del ordenador, es de prueba, no se visualizará
        /*
        flotaOrdenador=new ArrayList();
        flotaOrdenador=ordenador.getPosicionesOcupadasFlota();
        
        
        
        //disparos - tablero persona
        disPersona= new Coordenada();
        System.out.print("Piense en su disparo... ");
        disPersona= persona.crearDisparo();//se crea el primer disparo de la persona
        conjuntoDisparosPersona=new ArrayList();
        conjuntoDisparosPersona.add(disPersona);//añado el primer disparo
        tableroDisparoPersona= new Tablero();
        tableroDisparoPersona.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
         

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
		                if (persona.comprobarDisparo(disPersona, conjuntoDisparosPersona)==true){//se comprueba que es válido y se guarda para no repetirlo
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
	    System.out.print("Recuerde la posición de su flota: ");
	    persona.mostrarTableroBarcosFlota();

	    System.out.print("Disparo del Ordenador: ");
	    disOrdenador=ordenador.crearDisparoAleatorio();// se crea el primer disparo del ordenador OJO
	    ordenador.mostrarDisparoAleatorio(disOrdenador);
	    
	    conjuntoDisparosOrdenador=new ArrayList();//se crea el array donde se almacenarán los disparos del ordenador
	    conjuntoDisparosOrdenador.add(disOrdenador);//añado el primer disparo   

	    ordenador.solicitarResultadoDisparo();//se le pide a la persona que conteste si el disparo tocó, hundió o resulto ser agua
	        
	    //método para comprobar que la persona dice la verdad
	        
	    if (ordenador.realizarDisparo(disOrdenador, flotaPersona)==true){//No funciona     	
	        System.out.println("aquí. tocado");
	        //faltan las restricciones para hundido
	    }else{
	        System.out.println("agua");
	    }       
*/
    }
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;
import java.util.ArrayList;

/**
 *
 * @author monica
 */
abstract class Participante {
    
    private int tam;
    private Submarino sub1=new Submarino();//privado 
    private Submarino sub2=new Submarino();
    private Fragata fra1=new Fragata();
    private Fragata fra2=new Fragata();
    private Acorazado aco1=new Acorazado();
    private Acorazado aco2=new Acorazado();
    private Portaaviones porta=new Portaaviones();
    Coordenada disparo;
    Coordenada disparoAleatorio;
    
    private Tablero tableroBarcosJugador;
    private Tablero tableroDisparoJugador;
    
    //private Barco [] flota= {sub1,sub2,fra1,fra2,aco1,aco2,porta};
   
    public Participante(){}
    public abstract void posicionarFlota();
    public abstract ArrayList<Coordenada> getPosicionesOcupadasFlota();
    //public abstract void realizarDisparo(Coordenada c,ArrayList<Coordenada> aL);
    //public abstract void anotarDisparo(Coordenada c);
    
    public boolean realizarDisparo(Coordenada coorde,ArrayList<Coordenada> flota) {
        boolean resultadoDisparo=false;
        
        for (Coordenada coor: flota){
                    if(coorde.getCoordenadaX()==coor.getCoordenadaX()){
                        if(coorde.getCoordenadaY()==coor.getCoordenadaY()){
                            resultadoDisparo=true;                     
                        }
                    }
         }
        return resultadoDisparo;
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
    public void anotarDisparo(Coordenada c,Tablero t) {

        
        
    }
        
    public void crearFlotaSituadaTablero (){
            
        System.out.println("Vamos a crear la flota: ");
        System.out.println("La flota consta de 2 submarinos, 2 fragatas, 2 acorazados y 1 portaaviones: ");
        System.out.println("Para cada barco se solicitará la primera coordenada y la orientación. \n");
        
        System.out.print("Posicionar el primer submarino (tamaño 2).\n");
        //colocar los barcos en tablero. Faltan restricciones solapamiento barcos
        tableroBarcosJugador= new Tablero();
        tableroBarcosJugador.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
       // tableroBarcosJugador.colocarBarcoEnTablero(sub1.getBarco(2), 2);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar el segundo submarino (tamaño 2).\n");
       // tableroBarcosJugador.colocarBarcoEnTablero(sub2.getBarco(2), 2);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar la primera fragata (tamaño 3).\n");
       // tableroBarcosJugador.colocarBarcoEnTablero(fra1.getBarco(3), 3);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar la segunda fragata (tamaño 3).\n");
       // tableroBarcosJugador.colocarBarcoEnTablero(fra2.getBarco(3), 3);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar el primer acorazado (tamaño 4).\n");
       // tableroBarcosJugador.colocarBarcoEnTablero(aco1.getBarco(4), 4);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar el segundo acorazado (tamaño 4).\n");
     //   tableroBarcosJugador.colocarBarcoEnTablero(aco2.getBarco(4), 4);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        System.out.print("Posicionar el portaaviones (tamaño 5).\n");
       // tableroBarcosJugador.colocarBarcoEnTablero(porta.getBarco(5), 5);
        tableroBarcosJugador.imprimirTableroBarcos();
        
    }
        public void crearFlotaAleatoriaSituadaTablero (){
            //esta es una prueba en la que sólo sitúo un barco
        
        //colocar los barcos en tablero. Faltan restricciones solapamiento barcos
        tableroBarcosJugador= new Tablero();
        tableroBarcosJugador.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
 //       tableroBarcosJugador.colocarBarcoEnTablero(sub1.getBarcoAleatorio(2), 2);
        tableroBarcosJugador.imprimirTableroBarcos();//no será visible
        
        /*tableroBarcosJugador.colocarBarcoEnTablero(sub2.getBarco(2), 2);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        tableroBarcosJugador.colocarBarcoEnTablero(fra1.getBarco(3), 3);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        tableroBarcosJugador.colocarBarcoEnTablero(fra2.getBarco(3), 3);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        tableroBarcosJugador.colocarBarcoEnTablero(aco1.getBarco(4), 4);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        tableroBarcosJugador.colocarBarcoEnTablero(aco2.getBarco(4), 4);
        tableroBarcosJugador.imprimirTableroBarcos();
        
        tableroBarcosJugador.colocarBarcoEnTablero(porta.getBarco(5), 5);
        tableroBarcosJugador.imprimirTableroBarcos();
        */
    }
        


    /*
    public void situarDisparoTableroDisparo(Tablero tableroDisparoJugador, Coordenada disparo){ //en teoría tendría que entrar el tableroBarcosOrdenador
        tableroDisparoJugador= new Tablero();
        tableroDisparoJugador.Tablero(GlobalConstants.ANCHO_MAX_TABLERO,GlobalConstants.ALTO_MAX_TABLERO);
        
        tableroDisparoJugador.colocarDisparoEnTablero(disparo);
        tableroDisparoJugador.imprimirTableroDisparos();

        //esta es una prueba en la que no se dispara contra el tablero contrario, si no contra el propio
        //tengo que comprobar que existe en esa posición en tablero barcos
        if(tableroBarcosOrdenador[disparo.getCoordenadaX()][disparo.getCoordenadaY()]=='B'){
            tableroDisparoJugador[disparo.getCoordenadaX()][disparo.getCoordenadaY()]= estadoCasilla.TOCA;//D-usar flotad. Despues de cada punto un método
        }
        else{
            tableroDisparoJugador[disparo.getCoordenadaX()][disparo.getCoordenadaY()]= estadoCasilla.DISP;
        }
    }
     */

    /*void coordenadasOcupadas(){
        Barco [] flota= {sub1,sub2,fra1,fra2,aco1,aco2,porta};
        
    }*/
    /*public void imprimirFlota(){
        System.out.println("Las coordenadas que ocupa la flota son: ");
        
        sub1.imprimirBarco(2);
        sub2.imprimirBarco(2);
        fra1.imprimirBarco(3);
        fra2.imprimirBarco(3);
        aco1.imprimirBarco(4);
        aco2.imprimirBarco(4);
        porta.imprimirBarco(5);
    }
     * 
     */
}


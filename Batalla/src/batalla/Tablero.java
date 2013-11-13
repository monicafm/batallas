/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;

/**
 *
 * @author monica
 */
public class Tablero {
    private  int alto;
    private int ancho;
    private char [][] tablabarcos;
    private enum estadoCasilla{
        AGUA, DISP, TOCA, HUND
    };
    private estadoCasilla [][] tabladisparos;
    private int tamano;
    
    
   public void Tablero(int altura,int anchura){/*es necesario crear las variables altura y anchura? D -método solo tablero ??
¿por qué no podemos poner ANCHO_MAX_TABLERO y ALTO_MAX_TABLERO*/
        this.alto= altura;
        ancho=anchura;
        tablabarcos= new char [alto][ancho];
        tabladisparos=new estadoCasilla [alto][ancho];
        //iniciar el tablero con todas las posiciones en blanco
        for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                tablabarcos[i][j]='o';
            }
        }
       for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                tabladisparos[i][j]=estadoCasilla.AGUA;
            }
        }
   }

    public void colocarBarcoEnTablero(Coordenada[] barco,int tam){
        tamano=tam;
        for (int i=0; i<tamano;i++){
                tablabarcos[barco[i].getCoordenadaX()][barco[i].getCoordenadaY()]='B';//D-usar flotad. Despues de cada punto un método
                tablabarcos[barco[i].getCoordenadaX()][barco[i].getCoordenadaY()]='B';
        }
    }
    public void anotarDisparoEnTablero(Coordenada c,boolean b){
    	
    	if (b==true){   	
    		tabladisparos[c.getCoordenadaX()][c.getCoordenadaY()]=estadoCasilla.TOCA;
    	} else {
    		tabladisparos[c.getCoordenadaX()][c.getCoordenadaY()]=estadoCasilla.DISP;
    	}
    }
    public void anotarDisparoOrdenadorEnTableroBarcos(){
    	
    }
   
    /*public void colocarFlotaEnTablero(Flota flotad){
        //flot=flotad;
        
        for (int i=0; i<2;i++){// en vez de poner 2 poner tamanoSubmarino
                tablabarcos[flotad.sub1.barc[i].getCoordenadaX()][flotad.sub1.barc[i].getCoordenadaY()]='S';//D-usar flotad. Despues de cada punto un método
                tablabarcos[flotad.sub2.barc[i].getCoordenadaX()][flotad.sub2.barc[i].getCoordenadaY()]='S';
        }
        for (int i=0; i<3;i++){// en vez de poner 3 poner tamanoFragata
                tablabarcos[flotad.fra1.barc[i].getCoordenadaX()][flotad.fra1.barc[i].getCoordenadaY()]='F';
                tablabarcos[flotad.fra2.barc[i].getCoordenadaX()][flotad.fra2.barc[i].getCoordenadaY()]='F';
        }
        for (int i=0; i<4;i++){// en vez de poner 4 poner tamanoAcorazado
                tablabarcos[flotad.aco1.barc[i].getCoordenadaX()][flotad.aco1.barc[i].getCoordenadaY()]='A';
                tablabarcos[flotad.aco2.barc[i].getCoordenadaX()][flotad.aco2.barc[i].getCoordenadaY()]='A';
        }
        for (int i=0; i<5;i++){// en vez de poner 5 poner tamanoPortaaviones
                tablabarcos[flotad.porta.barc[i].getCoordenadaX()][flotad.porta.barc[i].getCoordenadaY()]='P';
        }
    }*/
    
    public void imprimirTableroBarcos(){
        System.out.println("\n");
        System.out.println("    Tablero de barcos:\n");
        for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                System.out.print(tablabarcos[i][j]);
                if (j!=tablabarcos[i].length-1)System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void imprimirTableroDisparos(){
        System.out.println("Tablero de disparos\n");
        for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                System.out.print(tabladisparos[i][j]);
                if (j!=tabladisparos[i].length-1)System.out.print("  ");
            }
            System.out.println();
        }
      System.out.println();  
    }
   
}



package batalla;

public class Tablero {
    private  int alto;
    private int ancho;
    private char [][] tablabarcos;
    private enum estadoCasilla{
        a, x, T, H
    };
    private estadoCasilla [][] tabladisparos;
    private int tamano;
    
    
   public void tablero(int altura,int anchura){
	   
        this.alto= altura;
        ancho=anchura;
        tablabarcos= new char [alto][ancho];
        tabladisparos=new estadoCasilla [alto][ancho];
        //tablero posiciones en blanco
        for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                tablabarcos[i][j]='o';
            }
        }
        for (int i=0; i<alto; i++){
            for (int j=0; j<ancho; j++){
                tabladisparos[i][j]=estadoCasilla.a;
            }
        }
   }

    public void colocarBarcoEnTablero(Coordenada[] barco,int tam){
        tamano=tam;
        for (int i=0; i<tamano;i++){
                tablabarcos[barco[i].getCoordenadaX()][barco[i].getCoordenadaY()]='B';
                tablabarcos[barco[i].getCoordenadaX()][barco[i].getCoordenadaY()]='B';
        }
    }
    
    public void anotarDisparoEnTablero(Coordenada c,boolean b){  	
    	if (b==true){tabladisparos[c.getCoordenadaX()][c.getCoordenadaY()]=estadoCasilla.T;}
    	else {tabladisparos[c.getCoordenadaX()][c.getCoordenadaY()]=estadoCasilla.x;}
    }
    
    public void anotarDisparoEnTableroBarcos(Coordenada c,boolean b){
    	if (b==true){tablabarcos[c.getCoordenadaX()][c.getCoordenadaY()]='T';}
    	else{tablabarcos[c.getCoordenadaX()][c.getCoordenadaY()]='x';}
    }
    
    public void anotarDisparoOrdenadorEnTableroBarcos(){
    	
    }
    
    public void anotarHundido(int fil,int col){
    	tabladisparos[fil][col]=estadoCasilla.H;
    }
    
    public boolean devolverHundido(Coordenada c,Tablero tableroDisparos){
    	boolean dHundido=false;
    	
    	if(tabladisparos[c.getCoordenadaX()][c.getCoordenadaY()]==estadoCasilla.H){//OJO comprobar tableroDisparos e if
    		dHundido=true;
    	}    	
    	return dHundido;
    }
    
    public boolean devolverEstadosCasilla(int f, int c){
    	boolean casilla=false;
    	
    	if(tabladisparos[f][c]==estadoCasilla.T){
    		casilla=true;   		
    	}else{casilla=false; }
    	
    	return casilla;
    }
    
    
    public void imprimirTableroBarcos(){
        System.out.println("    Tablero de barcos:\n");
        System.out.println("     1  2  3  4  5  6  7  8  9 10\n");//para mostrar tablero 10x10
        for (int i=0; i<alto; i++){       	
        	if(i<9){System.out.print(" "+(i+1)+"   ");}//para mostrar tablero 10x10
        	else{System.out.print((i+1)+"   ");}//para mostrar tablero 10x10       	
            for (int j=0; j<ancho; j++){            	
                System.out.print(tablabarcos[i][j]);
                if (j!=tablabarcos[i].length-1)System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void imprimirTableroDisparos(){
    	System.out.println();
        System.out.println("    Tablero de disparos\n");
        System.out.println("     1  2  3  4  5  6  7  8  9 10\n");//para mostrar tablero 10x10
        for (int i=0; i<alto; i++){        	
        	if(i<9){System.out.print(" "+(i+1)+"   ");}//para mostrar tablero 10x10
        	else{System.out.print((i+1)+"   ");}//para mostrar tablero 10x10
            for (int j=0; j<ancho; j++){
                System.out.print(tabladisparos[i][j]);
                if (j!=tabladisparos[i].length-1)System.out.print("  ");
            }
            System.out.println();
        }
      System.out.println();  
    }
   
}


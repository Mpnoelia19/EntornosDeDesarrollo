import com.tetramino.juego.Casilla;
import com.tetramino.juego.Jugador;
import com.tetramino.juego.Tablero;
import com.tetramino.juego.Tetramino;

import java.util.Random;
import java.util.Scanner;

// Falta implementar que el tablero al disparar al agua cambie a o, si es al tetra a x
// En tablero propio ver donde están colocados los tetras
// Que vaya cambiando de turno
// Pedir coordenadas por teclado

public class Juego {
    static Jugador jug1;
    static Jugador pc;

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        
        iniciarJuegoPrueba();

    }

    public static Casilla[] cuadrado () {

        Casilla [] posicionCuadrado = new Casilla[4];
        Random random = new Random();

        int fila = random.nextInt(Tablero.MAX_CASILLAS - 1); // Generar un número aleatorio entre 0 y 9
        int columna = random.nextInt(Tablero.MAX_CASILLAS - 1);

        posicionCuadrado [0] = new Casilla(fila,columna);
        posicionCuadrado [1] = new Casilla(fila,columna + 1);
        posicionCuadrado [2] = new Casilla(fila + 1,columna);
        posicionCuadrado [3] = new Casilla(fila + 1,columna +1);

        return posicionCuadrado;
    }

    public static Casilla[] barraHorizontal() {

        Casilla [] posicionBarra = new Casilla[4];
        Random random = new Random();

        int fila = random.nextInt(Tablero.MAX_CASILLAS - 1); // Generar un número aleatorio entre 0 y 9
        int columna = random.nextInt(Tablero.MAX_CASILLAS - 3);

        posicionBarra [0] = new Casilla(fila, columna);
        posicionBarra [1] = new Casilla(fila,columna + 1);
        posicionBarra [2] = new Casilla(fila,columna + 2);
        posicionBarra [3] = new Casilla(fila,columna + 3);

        return posicionBarra;
    }

    public static Casilla[] barraVertical() {

        Casilla [] posicionBarra = new Casilla[4];
        Random random = new Random();

        int fila = random.nextInt(Tablero.MAX_CASILLAS - 3); // Generar un número aleatorio entre 0 y 9
        int columna = random.nextInt(Tablero.MAX_CASILLAS - 1);

        posicionBarra [0] = new Casilla(fila, columna);
        posicionBarra [1] = new Casilla(fila + 1,columna );
        posicionBarra [2] = new Casilla(fila + 2,columna);
        posicionBarra [3] = new Casilla(fila + 3,columna);

        return posicionBarra;
    }

    public static void iniciarJuegoPrueba(){

        jug1 = new Jugador();
        pc = new Jugador();

        jug1.getTableroDisparos().getCasilla();

        jug1.getTableroDisparos().getCasilla()[0][0].setEstado(Casilla.Estado.TOCADO);
        jug1.getTableroDisparos().getCasilla()[0][1].setEstado(Casilla.Estado.TOCADO);
        jug1.getTableroDisparos().getCasilla()[1][0].setEstado(Casilla.Estado.TOCADO);
        jug1.getTableroDisparos().getCasilla()[1][1].setEstado(Casilla.Estado.TOCADO);

        Tetramino barco = new Tetramino();
        barco.setPosicion(cuadrado()); //
        jug1.añadirBarco(barco);
        jug1.getTableroDisparos();

        Tetramino barco2 = new Tetramino();
        barco2.setPosicion(barraHorizontal());
        jug1.añadirBarco(barco2);

        Tetramino barco3 = new Tetramino();
        barco3.setPosicion(barraHorizontal());
        jug1.añadirBarco(barco3);

        Tetramino barco4 = new Tetramino();
        barco4.setPosicion(barraVertical());
        jug1.añadirBarco(barco4);

        jug1.recibirAtaque(0,0);
        jug1.recibirAtaque(0,1);
        jug1.recibirAtaque(1,0);
        jug1.recibirAtaque(1,1);


    }


}
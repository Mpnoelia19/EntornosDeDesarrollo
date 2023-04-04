package com.tetramino.juego;

public class Tablero {
    public static final int MAX_CASILLAS = 10;
    private Casilla[][] casillas;

    public Tablero(Casilla[][] casillas) {
        this.casillas = casillas;

    }

    public Tablero() {
        // Inicializa el tablero.
        casillas = new Casilla[MAX_CASILLAS][MAX_CASILLAS];
        for (int fila = 0; fila < MAX_CASILLAS; fila++) {
            for (int columna = 0; columna < MAX_CASILLAS; columna++) {
                casillas[fila][columna] = new Casilla(fila, columna);
            }
        }
    }

    public void setCasilla(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Casilla [][] getCasilla() {
        return casillas;
    }

    public Casilla getCasilla(int fila, int columna) { //Método getCasilla no confundir con getter
        return casillas[fila][columna];
    }

    public void mostrarTablero(){

        // Imprimir tablero
        int [][] tablero = new int[MAX_CASILLAS][MAX_CASILLAS];
        System.out.print("  ");
        for (int i = 'A'; i <= 'J'; i++) {
            System.out.format("%2c",i);
        }
        System.out.println();
        for (int j = 0; j < tablero.length; j++) {
            System.out.format("%2d",j + 1);
            for (int k = 0; k < tablero.length; k++) {
                System.out.print(" ");
                System.out.print(casillas[j][k].toString());
            }
            System.out.println();
        }
    }

    public void actualizarCasilla(Casilla casilla, Casilla.Estado estado) {
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        this.casillas[fila][columna].setEstado(estado);
    }



}





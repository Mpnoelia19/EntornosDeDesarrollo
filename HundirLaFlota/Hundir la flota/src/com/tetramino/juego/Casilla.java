package com.tetramino.juego;

public class Casilla {
    public enum Estado {AGUA, BARCO, TOCADO, HUNDIDO, FALLADO, VACIA}
    private int fila;
    private int columna;
    private Estado estadoCasilla;
    private String alias;
    private Tetramino tetramino;
    public Casilla(int fila, int columna) {

        this.fila = fila;
        this.columna = columna;
        this.estadoCasilla = Estado.AGUA; // todas las casillas está inicializadas en agua.
    }

    public Casilla(){

    }
    public Estado getEstado() {

        return estadoCasilla;
    }

    public void setEstado(Estado estado) {
        this.estadoCasilla = estado;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Tetramino getTetramino() {
        return tetramino;
    }

    public void setTetramino(Tetramino tetramino) {
        this.tetramino = tetramino;
    }

    @Override
    public String toString() {
        String simbolo = "";
        switch (estadoCasilla){
            case FALLADO: simbolo = "f";
                break;
            case TOCADO: simbolo = "t";
                break;
            case HUNDIDO: simbolo= "x";
        }
        return simbolo;
    }


}

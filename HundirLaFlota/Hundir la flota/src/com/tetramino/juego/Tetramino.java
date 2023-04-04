package com.tetramino.juego;

public class Tetramino {
    public enum Tipo {CUADRADO, BARRA}

    public static final int MAX_PUNTOS_VIDA = 4;
    private Tipo tipo;
    private int puntosDeVida;
    private Casilla[] posicion;

    public Tetramino(Casilla[] posicion) {
        this.puntosDeVida = MAX_PUNTOS_VIDA;
        this.posicion = posicion;
    }

    public Tetramino() {
        this.puntosDeVida = MAX_PUNTOS_VIDA;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Casilla[] getPosicion() {
        return posicion;
    }

    public void setPosicion(Casilla[] posicion) {
        this.posicion = posicion;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void tocado() {

        puntosDeVida = puntosDeVida -1;
    }

    public boolean esHundido() {
        if (puntosDeVida == 0) {

            return true;
        }
        return false;
    }

    public String tipoTetramino() {

        if (this.tipo == Tipo.BARRA) {
            return "barra";
        } else if (this.tipo == Tipo.CUADRADO) {
            return "cuadrado";
        }

        return null;
    }

    // Le llega una casilla a la que le están disparando, aquí tendrá que devolverme si le he pegado a algo o no
    public boolean contieneCasilla(Casilla casillaAtacada) {

        for (int i = 0; i < posicion.length; i++) {

            int fila = casillaAtacada.getFila(); // No puedo comparar diferentes tipos de datos
            int columna = casillaAtacada.getColumna();
            int filaPosicion = posicion[i].getFila();
            int columnaPosicion = posicion[i].getColumna();

            if (fila == filaPosicion && columna == columnaPosicion) {
                return true;
            }

        }

        return false;
    }

}


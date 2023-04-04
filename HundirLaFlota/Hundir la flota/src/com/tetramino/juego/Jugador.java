package com.tetramino.juego;

public class Jugador {
    public static final int MAX_TETRAMINOS = 4;

    private String nombreJugador;
    private Tablero tableroPropio;
    private Tablero tableroDisparos;
    private Tetramino[] barcos;
    private int barcosNoHundidos;

    public Jugador(String nombreJugador, int barcosNoHundidos) {
        this.nombreJugador = nombreJugador;
        this.tableroPropio = new Tablero();
        this.tableroDisparos = new Tablero();
        this.barcos = new Tetramino[MAX_TETRAMINOS];
        this.barcosNoHundidos = barcosNoHundidos;

    }

    public Jugador() {
        this("", 0);

    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Tablero getTableroPropio() {
        return tableroPropio;
    }

    public void setTableroPropio(Tablero tableroPropio) {
        this.tableroPropio = tableroPropio;
    }

    public Tablero getTableroDisparos() {
        return tableroDisparos;
    }

    public void setTableroDisparos(Tablero tableroDisparos) {
        this.tableroDisparos = tableroDisparos;
    }

    public Tetramino[] getBarcos() {
        return barcos;
    }

    public void setBarcos(Tetramino[] barcos) {
        this.barcos = barcos;
    }

    public int getBarcosNoHundidos() {
        return barcosNoHundidos;
    }

    public void setBarcosNoHundidos(int barcosNoHundidos) {
        this.barcosNoHundidos = barcosNoHundidos;
    }


    // Cantidad maxima de tetraminos que me caben en el tablero
    public boolean añadirBarco(Tetramino barco) {

        // Buscamos si hay huecos para el barco
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < barcos.length) {
            if (barcos[i] == null) {
                encontrado = true;
            } else {
                i++;
            }
        }

        // Añadimos barco en el primer hueco
        if (encontrado) {

            Casilla[] casillas = barco.getPosicion();

            // Comprobar que cada casilla esté vacía para poder añadir el barco
            for (Casilla casilla : casillas) {
                if (casilla.getEstado() != Casilla.Estado.AGUA) {
                    return false;
                }
            }

            barcos[i] = barco;

            // Actualizar el tablero con el barco
            for (Casilla casilla : casillas) {
                tableroPropio.actualizarCasilla(casilla, Casilla.Estado.BARCO);
            }
            barcosNoHundidos++; //
            return true;

        }

        return false;
    }

    public void recibirAtaque(int fila, int columna) {

        // ¿En qué casilla se hizo el ataque?
        Casilla casillaAtacada = tableroDisparos.getCasilla(fila, columna);

        // ¿Ya ha tenido algún ataque?
        if (casillaAtacada.getEstado() != Casilla.Estado.AGUA) {
            System.out.println("Esta casilla ya fue atacada. Elige otra.");
        }

        // ¿Hay barco?
        Tetramino barcoAtacado = null;
        for (Tetramino barco : barcos) {
            if (barco.contieneCasilla(casillaAtacada)) {
                barcoAtacado = barco;
                break;
            }
        }

        // Actualizar el estado
        if (barcoAtacado == null) {
            casillaAtacada.setEstado(Casilla.Estado.FALLADO);
            System.out.println("Agua!");

        } else {
            casillaAtacada.setEstado(Casilla.Estado.TOCADO);
            barcoAtacado.tocado();

            if (barcoAtacado.esHundido()) {
                for (Casilla casilla : barcoAtacado.getPosicion()) {
                    casilla.setEstado(Casilla.Estado.HUNDIDO);
                }
                System.out.println("Barco hundido!");
                barcosNoHundidos--;

                // Finalizar el juego
                if (barcosNoHundidos == 0) {
                    System.out.println("Has perdido, ya no te quedan barcos a flote");
                }
            }else {

                System.out.println("Tocado!");
            }
        }
        tableroDisparos.mostrarTablero();
    }


}

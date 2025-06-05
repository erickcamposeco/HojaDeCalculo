package hoja_calculo;

// Clase nodo, como en los arboles

public class Nodo {

    private int fila;
    private int columna;
    private Celda celda;
    private Nodo arriba;
    private Nodo abajo;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(int fila, int columna, Celda celda) {
        this.fila = fila;
        this.columna = columna;
        this.celda = celda;
    }

    // Constructores
    
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public Nodo getArriba() {
        return arriba;
    }

    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
}
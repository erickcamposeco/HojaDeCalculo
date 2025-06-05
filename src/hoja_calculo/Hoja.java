package hoja_calculo;

//Hoja de calculo

public class Hoja {

    private int filas;
    private int columnas;
    private Celda[][] celdas;

    public Hoja(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j, "", this);
            }
        }
    }

    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public Celda getCelda(String referencia) {
        int columna = referencia.charAt(0) - 'A';
        int fila = Integer.parseInt(referencia.substring(1)) - 1;
        return getCelda(fila, columna);
    }

    public void setCelda(int fila, int columna, String contenido) {
        celdas[fila][columna].setContenido(contenido);
    }

    public Celda[][] getCeldas() {
        return celdas;
    }
}
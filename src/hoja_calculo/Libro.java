package hoja_calculo;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private List<Hoja> hojas;

    public Libro() {
        hojas = new ArrayList<>();
    }

    public void agregarHoja(Hoja hoja) {
        hojas.add(hoja);
    }

    public int getNumeroDeHojas() {
        return hojas.size();
    }

    public Hoja getHoja(int index) {
        return hojas.get(index);
    }
}
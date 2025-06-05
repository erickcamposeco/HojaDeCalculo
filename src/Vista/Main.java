
package Vista;

//Controlador de la vista

import Controlador.ControladorHojaCalculo;
import hoja_calculo.Libro;

public class Main {

    public static void main(String[] args) {
        VistaPrincipal vista = new VistaPrincipal();
        Libro libro = new Libro();
        ControladorHojaCalculo controlador = new ControladorHojaCalculo(vista, libro);
    }
}

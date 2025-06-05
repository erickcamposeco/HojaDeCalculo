
package Controlador;

import Controlador.ControladorHashTable;
import hoja_calculo.Hoja;
import hoja_calculo.Libro;
import Vista.VistaPrincipal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorHojaCalculo {
    private VistaPrincipal vista;
    private Libro libro;

    public ControladorHojaCalculo(VistaPrincipal vista, Libro libro) 
    {
        this.vista = vista;
        this.libro = libro;

        vista.getNuevaHojaItem().addActionListener(e -> agregarHoja(10, 10));
        vista.getTablaHashItem().addActionListener(e -> new ControladorHashTable(vista).mostrarTablaHash());

       //Adicion de los listeners como en la hashtable
    }

    public void agregarHoja(int filas, int columnas) 
    {
        Hoja nuevaHoja = new Hoja(filas, columnas);
        libro.agregarHoja(nuevaHoja);

        JPanel panelHoja = new JPanel(new BorderLayout());

        // Creacion del Panel
        
        JPanel gridPanel = new JPanel(new GridLayout(filas + 1, columnas + 1));
        JTextField[][] campos = new JTextField[filas][columnas];

        // Adicion de celdas y datos
        
        for (int i = 0; i <= filas; i++) 
        {
            for (int j = 0; j <= columnas; j++) 
            {
                if (i == 0 && j == 0) {
                    gridPanel.add(new JLabel(""));  // Esquinas vacias
                } else if (i == 0) {
                    gridPanel.add(new JLabel(String.valueOf((char) ('A' + j - 1)), SwingConstants.CENTER));  // Encabezado
                } else if (j == 0) {
                    gridPanel.add(new JLabel(String.valueOf(i), SwingConstants.CENTER));  // Encabezado
                } else {
                    JTextField textField = new JTextField();
                    campos[i - 1][j - 1] = textField;
                    int fila = i - 1;
                    int columna = j - 1;
                    textField.addActionListener(new ActionListener() {
                        @Override //sobreescribir
                        
                        public void actionPerformed(ActionEvent e) {
                            String contenido = textField.getText();
                            nuevaHoja.setCelda(fila, columna, contenido);
                            actualizarHoja(gridPanel, nuevaHoja, campos);
                        }
                    });
                    gridPanel.add(textField);
                }
            }
        }

        panelHoja.add(gridPanel, BorderLayout.CENTER);
        vista.agregarHoja("Hoja " + libro.getNumeroDeHojas(), panelHoja);
    }

    private void actualizarHoja(JPanel panel, Hoja hoja, JTextField[][] campos) {
        for (int i = 0; i < hoja.getCeldas().length; i++) {
            for (int j = 0; j < hoja.getCeldas()[i].length; j++) {
                campos[i][j].setText(hoja.getCelda(i, j).getValor());
            }
        }
        panel.revalidate();
        panel.repaint();
    }
}

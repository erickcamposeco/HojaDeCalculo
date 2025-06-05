
package Vista;
//Vista

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal 
{

    private JFrame frame;
    private JTabbedPane tabbedPane;

    public VistaPrincipal() {
        frame = new JFrame("Hoja de Calculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");
        JMenuItem nuevaHojaItem = new JMenuItem("Nueva Hoja");
        JMenuItem tablaHashItem = new JMenuItem("Tabla Hash");
        archivoMenu.add(nuevaHojaItem);
        archivoMenu.add(tablaHashItem);
        menuBar.add(archivoMenu);
        frame.setJMenuBar(menuBar);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        frame.setVisible(true);
    }

    public void agregarHoja(String nombre, JPanel panel) {
        tabbedPane.addTab(nombre, panel);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JMenuItem getNuevaHojaItem() {
        return ((JMenu) frame.getJMenuBar().getMenu(0)).getItem(0);
    }

    public JMenuItem getTablaHashItem() {
        return ((JMenu) frame.getJMenuBar().getMenu(0)).getItem(1);
    }
}

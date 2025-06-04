
package Controlador;

import Vista.VistaPrincipal;
import javax.swing.*;
import java.awt.*;


public class ControladorHashTable {
    
    private HashTable hashTable;
    private VistaPrincipal vista;
    
    public ControladorHashTable (VistaPrincipal vista){
        this.vista = vista;
        this.hashTable = new HashTable(10);
    }
    
     public void mostrarTablaHash() //Mostrar la hashtable
    {
        JPanel panelHash = new JPanel(new BorderLayout());
        JTextArea inputArea = new JTextArea(10, 20);
        JTextArea outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        inputArea.addKeyListener(new java.awt.event.KeyAdapter() //Los listeners para la hashtable
        {
            public void keyReleased(java.awt.event.KeyEvent evt) 
            {
                String[] lines = inputArea.getText().split("\n");
                StringBuilder output = new StringBuilder();
                for (String line : lines) {
                    int hashValue = hashTable.hash(line);
                    hashTable.put(line, hashValue);
                    output.append(line).append(" -> ").append(hashValue).append("\n");
                }
                outputArea.setText(output.toString());
            }
        });
        //Adicion del os panelHash para la vista
        panelHash.add(new JScrollPane(inputArea), BorderLayout.WEST);
        panelHash.add(new JScrollPane(outputArea), BorderLayout.EAST);
        vista.agregarHoja("Tabla Hash", panelHash);
    }

    public void agregarDato(String key) 
    {
        hashTable.put(key, hashTable.hash(key));
        // Código para actualizar la vista de la tabla hash
    }
    
}

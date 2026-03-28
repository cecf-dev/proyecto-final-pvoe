/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.pf.operaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import uam.pvoe.pf.clases.Taller;

public class GestionTalleres {

    public java.util.LinkedList<Taller> listaTalleres() {
        LinkedList<Taller> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("talleres.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                // Ahora esperamos 5 datos en lugar de 4
                if (datos.length >= 5) {
                    String nombre = datos[0];
                    String instructor = datos[1]; // CAPTURAMOS AL INSTRUCTOR
                    String[] horarios = datos[2].split(";"); // El horario ahora es el índice 2
                    double costo = Double.parseDouble(datos[3]); // Costo es el 3
                    double material = Double.parseDouble(datos[4]); // Material es el 4

                    // Pasamos el instructor al crear el objeto
                    lista.add(new Taller(nombre, instructor, horarios, costo, material));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer talleres: " + e.getMessage());
        }
        return lista;
    }
}

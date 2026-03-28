/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.pf.operaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import uam.pvoe.pf.clases.Usuario;

/**
 *
 * @author
 */
/**
 * Lógica para el control de acceso al sistema de la Casa de la Cultura
 */
public class ValidarUsuario {

    /**
     * Valida el acceso leyendo el archivo de texto separado por comas.
     */
    public Usuario validarAcceso(String user, String pass) {
        try (BufferedReader br = new BufferedReader(new FileReader("administra.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separamos la línea por comas: "admin,1234,ADMIN"
                String[] datos = linea.split(",");

                // datos[0] = usuario, datos[1] = password, datos[2] = rol
                if (datos[0].equals(user) && datos[1].equals(pass)) {
                    return new Usuario(datos[0], datos[1], datos[2]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.pf.clases;


/**
 * Modelo para los usuarios del sistema.
 * 
 * @author Cristian Emanuel Ceron Franco
 */
public class Usuario {

    private String username;
    private String password;
    private String rol; // "ADMIN" o "STAFF"

    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }
}


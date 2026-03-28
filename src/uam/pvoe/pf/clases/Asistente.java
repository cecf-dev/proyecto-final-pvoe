/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.pf.clases;

/**
 * Clase que representa a un Asistente registrado en el sistema.
 *
 * @author Cristian Emanuel Ceron Franco
 */
public class Asistente {

    private String id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String edad;
    private String genero;
    private String direccion;
    private String telContacto;
    private String telEmergencia;

    public Asistente(String id, String nombre, String primerApellido,
            String segundoApellido, String edad, String genero,
            String direccion, String telContacto, String telEmergencia) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telContacto = telContacto;
        this.telEmergencia = telEmergencia;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public String getTelEmergencia() {
        return telEmergencia;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public void setTelEmergencia(String telEmergencia) {
        this.telEmergencia = telEmergencia;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + primerApellido;
    }
}

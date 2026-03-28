/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.pf.compartido;

import java.util.LinkedList;
import uam.pvoe.pf.clases.Asistente;
import uam.pvoe.pf.clases.Taller;

/**
 * Clase para el manejo de datos globales y de sesión.
 * Centraliza la información necesaria para que todas las pantallas
 * cumplan con los requisitos del sistema.
 * * @author Cristian Emanuel Ceron Franco
 */
public class Compartido {
    
   
    /* * Datos de la sesión de la encargada del sistema[
     * Estos se llenan al validar el usuario en el Login
     */
    public static String login;         // Identificador (ej. adminCC, encargada1) 
    public static String tipoUsuario;   // Rol: ADMIN o STAFF (reemplaza a admin/usr de la práctica) 
    public static String nombreUsuario; // Nombre legible para el mensaje de bienvenida 
    
    /* * Gestión del flujo de información del asistente.
     * Permite que los datos capturados en una ventana estén disponibles en otra.
     */
    public static String idAsistenteSeleccionado; // Para usar en Administración
    public static LinkedList<Taller> talleresSeleccionados = new LinkedList<>(); // Lista de inscripciones actuales.
    
    

}

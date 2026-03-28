package uam.pvoe.pf.clases;

/**
 *
 * @author Cristian Emanuel Ceron Franco
 */
public class Taller {

    private String nombre;
    private String instructor;
    private String[] horarios;
    private double costoBase;
    private double costoMaterial;

    public Taller(String nombre, String instructor, String[] horarios, double costoBase, double costoMaterial) {
        this.nombre = nombre;
        this.instructor = instructor;
        this.horarios = horarios;
        this.costoBase = costoBase;
        this.costoMaterial = costoMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstructor() {
        return instructor;
    } // NUEVO GETTER

    public String[] getHorarios() {
        return horarios;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public double getCostoMaterial() {
        return costoMaterial;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}

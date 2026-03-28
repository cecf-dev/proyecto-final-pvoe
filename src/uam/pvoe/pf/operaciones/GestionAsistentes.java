package uam.pvoe.pf.operaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import uam.pvoe.pf.clases.Asistente;

/**
 *
 */
public class GestionAsistentes {

    private final String ARCHIVO_ASISTENTES = "asistentes.dat";

    public boolean registrarAsistente(String id, String nom, String ap1, String ap2,
            String edad, String gen, String dir, String tel1, String tel2) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENTES, true))) {
            String registro = id + "," + nom + "," + ap1 + "," + ap2 + ","
                    + edad + "," + gen + "," + dir + "," + tel1 + "," + tel2;
            bw.write(registro);
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String generarSiguienteID() {
        int contador = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENTES))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            return "1";
        }
        return String.valueOf(contador);
    }

    public boolean guardarInscripcion(String idAsistente, String taller, String horario, boolean conMaterial, String costoTotal) {
        ArrayList<String> todasLasLineas = new ArrayList<>();
        boolean archivoModificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(idAsistente + ",")) {
                    String materialStr = conMaterial ? "Si" : "No";
                    linea = linea + "," + taller + "," + horario + "," + materialStr + "," + costoTotal;
                    archivoModificado = true;
                }
                todasLasLineas.add(linea);
            }
        } catch (IOException e) {
            return false;
        }

        if (archivoModificado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENTES))) {
                for (String l : todasLasLineas) {
                    bw.write(l);
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    public String[] obtenerAsistentePorId(String idBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(idBuscado + ",")) {
                    return linea.split(",", -1);
                }
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public LinkedList<Asistente> obtenerListaPorTaller(String tallerNombre) {
        LinkedList<Asistente> lista = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(tallerNombre.toLowerCase())) {
                    String[] d = linea.split(",", -1);
                    if (d.length >= 9) {
                        lista.add(new Asistente(d[0], d[1], d[2], d[3], d[4], d[5], d[6], d[7], d[8]));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al filtrar taller: " + e.getMessage());
        }
        return lista;
    }

    public LinkedList<Asistente> obtenerTodosLosAsistentes() {
        LinkedList<Asistente> lista = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",", -1);
                if (d.length >= 9) {
                    lista.add(new Asistente(d[0], d[1], d[2], d[3], d[4], d[5], d[6], d[7], d[8]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar asistentes: " + e.getMessage());
        }
        return lista;
    }

    public boolean darDeBajaTaller(String idAsistente, String nombreTaller) {
        ArrayList<String> todasLasLineas = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("asistentes.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.startsWith(idAsistente + ",")) {
                    String[] datos = linea.split(",");

                    StringBuilder nuevaLinea = new StringBuilder();
                    for (int i = 0; i < 9; i++) {
                        nuevaLinea.append(datos[i]);
                        if (i < 8) {
                            nuevaLinea.append(",");
                        }
                    }

                    for (int i = 9; i < datos.length; i += 4) {
                        if (!datos[i].equals(nombreTaller)) {
                            nuevaLinea.append(",").append(datos[i]) // Taller
                                    .append(",").append(datos[i + 1]) // Horario
                                    .append(",").append(datos[i + 2]) // Material
                                    .append(",").append(datos[i + 3]);  // Total
                        } else {
                            modificado = true;
                        }
                    }
                    linea = nuevaLinea.toString();
                }
                todasLasLineas.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer para dar de baja: " + e.getMessage());
            return false;
        }

        if (modificado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("asistentes.dat"))) {
                for (String l : todasLasLineas) {
                    bw.write(l);
                    bw.newLine();
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al guardar la baja: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean actualizarInscripcionTaller(String idAsistente, String nombreTaller, String nuevoHorario, boolean conMaterial, String nuevoTotal) {
        ArrayList<String> todasLasLineas = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("asistentes.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                // Encontramos al alumno
                if (linea.startsWith(idAsistente + ",")) {
                    String[] datos = linea.split(",");
                    StringBuilder nuevaLinea = new StringBuilder();

                    for (int i = 0; i < 9; i++) {
                        nuevaLinea.append(datos[i]);
                        if (i < 8) {
                            nuevaLinea.append(",");
                        }
                    }

                    for (int i = 9; i < datos.length; i += 4) {
                        nuevaLinea.append(",").append(datos[i]); // Nombre del taller

                        if (datos[i].equals(nombreTaller)) {
                            String materialStr = conMaterial ? "Si" : "No";
                            nuevaLinea.append(",").append(nuevoHorario)
                                    .append(",").append(materialStr)
                                    .append(",").append(nuevoTotal);
                            modificado = true;
                        } else {
                            nuevaLinea.append(",").append(datos[i + 1])
                                    .append(",").append(datos[i + 2])
                                    .append(",").append(datos[i + 3]);
                        }
                    }
                    linea = nuevaLinea.toString();
                }
                todasLasLineas.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer para actualizar taller: " + e.getMessage());
            return false;
        }
        if (modificado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("asistentes.dat"))) {
                for (String l : todasLasLineas) {
                    bw.write(l);
                    bw.newLine();
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al guardar actualización: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean actualizarDatosAsistente(String id, String nom, String ap1, String ap2, String edad, String gen, String dir, String tel1, String tel2) {
        ArrayList<String> todasLasLineas = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("asistentes.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(id + ",")) {
                    String[] datos = linea.split(",");
                    StringBuilder nuevaLinea = new StringBuilder();

                    nuevaLinea.append(id).append(",")
                            .append(nom).append(",")
                            .append(ap1).append(",")
                            .append(ap2).append(",")
                            .append(edad).append(",")
                            .append(gen).append(",")
                            .append(dir).append(",")
                            .append(tel1).append(",")
                            .append(tel2);

                    for (int i = 9; i < datos.length; i++) {
                        nuevaLinea.append(",").append(datos[i]);
                    }

                    linea = nuevaLinea.toString();
                    modificado = true;
                }
                todasLasLineas.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar datos personales: " + e.getMessage());
            return false;
        }

        if (modificado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("asistentes.dat"))) {
                for (String l : todasLasLineas) {
                    bw.write(l);
                    bw.newLine();
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean eliminarAsistente(String idAsistente) {
        ArrayList<String> todasLasLineas = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("asistentes.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith(idAsistente + ",")) {
                    todasLasLineas.add(linea);
                } else {
                    modificado = true; // Encontramos y omitimos (borramos) al alumno
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar eliminar: " + e.getMessage());
            return false;
        }

        if (modificado) {
            try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter("asistentes.dat"))) {
                for (String l : todasLasLineas) {
                    bw.write(l);
                    bw.newLine();
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}

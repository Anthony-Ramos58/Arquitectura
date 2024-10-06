/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER 17
 */
public class EstudianteArray {

    private ArrayList<Estudiante> listaEstudiante;
    private DefaultTableModel modelo;

    // Constructor que acepta DefaultTableModel
    public EstudianteArray(DefaultTableModel modelo) {
        this.listaEstudiante = new ArrayList<>();
        this.modelo = modelo;
    }

    public void agregarEstudiante(Estudiante estudiante, Date fechaNacimiento) {
        if (listaEstudiante.size() >= 5) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más de 5 estudiantes.");
            return;
        }

        // Calcular la edad basada en la fecha de nacimiento
        int edad = calcularEdad(fechaNacimiento);
        estudiante.setEdad(edad);  // Asigna la edad calculada

        listaEstudiante.add(estudiante);
        actualizarTabla(); // Actualizar la tabla al agregar un estudiante
        guardarDatosEnArchivo("D:\\DISCO D\\INGENIERIA DE SISTEMAS\\VII CICLO\\Esctructura de software\\Semana 05\\estudiantes.txt");
    }

    // Método para calcular la edad en función de la fecha de nacimiento
    public int calcularEdad(Date fechaNacimiento) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaNacimiento);
        int añoNacimiento = cal.get(Calendar.YEAR);
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);
        return añoActual - añoNacimiento;
    }

    public void actualizarTabla() {
        // Limpiar la tabla actual
        modelo.setRowCount(0);

        // Agregar todos los estudiantes a la tabla
        for (Estudiante e : listaEstudiante) {
            modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getApellidom(), e.getApellidop(), e.getFacultad(), e.getEdad()});
        }
    }

    // Método para limpiar los campos del formulario
    public void limpiar(javax.swing.JTextField txtCodigo, javax.swing.JTextField txtNombre,
            javax.swing.JTextField txtApellidop, javax.swing.JTextField txtApellidom,
            javax.swing.JTextField txtFacultad, com.toedter.calendar.JCalendar calendario) {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellidop.setText("");
        txtApellidom.setText("");
        txtFacultad.setText("");
        calendario.setDate(null);
    }

    public void buscarPorNombre(String nombre) {
        // Limpiar la tabla actual
        modelo.setRowCount(0);

        // Filtrar la lista por nombre y agregar los resultados a la tabla
        for (Estudiante e : listaEstudiante) {
            if (e.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                modelo.addRow(new Object[]{e.getCodigo(), e.getNombre(), e.getApellidom(), e.getApellidop(), e.getFacultad(), e.getEdad()});
            }
        }
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiante;
    }

    public void guardarDatosEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) { // No agregar 'true', esto sobrescribirá el archivo
            for (Estudiante estudiante : listaEstudiante) {
                writer.write(estudiante.getCodigo() + ","
                        + estudiante.getNombre() + ","
                        + estudiante.getApellidop() + ","
                        + estudiante.getApellidom() + ","
                        + estudiante.getFacultad() + ","
                        + estudiante.getEdad());
                writer.newLine(); // Nueva línea para cada estudiante
            }
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean archivoVacio = true; // Bandera para verificar si el archivo está vacío

            // Limpiar tanto la tabla como el ArrayList antes de cargar datos
            listaEstudiante.clear();  // Limpiar el ArrayList
            modelo.setRowCount(0);    // Limpiar la tabla

            while ((linea = reader.readLine()) != null) {
                archivoVacio = false; // Si hay alguna línea, significa que el archivo no está vacío
                String[] datos = linea.split(","); // Suponiendo que los datos están separados por comas
                if (datos.length == 6) {
                    // Crear un nuevo objeto Estudiante con los datos leídos
                    Estudiante estudiante = new Estudiante();
                    estudiante.setCodigo(datos[0]);
                    estudiante.setNombre(datos[1]);
                    estudiante.setApellidop(datos[2]);
                    estudiante.setApellidom(datos[3]);
                    estudiante.setFacultad(datos[4]);
                    estudiante.setEdad(Integer.parseInt(datos[5]));

                    // Agregar el estudiante a la lista
                    listaEstudiante.add(estudiante);

                    // Agregar el estudiante a la tabla
                    modelo.addRow(new Object[]{datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]});
                }
            }

            if (archivoVacio) {
                JOptionPane.showMessageDialog(null, "El archivo está vacío, la tabla y la lista han sido limpiadas.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }
}

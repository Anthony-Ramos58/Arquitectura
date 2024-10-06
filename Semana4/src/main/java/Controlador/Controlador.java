/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteArray;
import Vista.IRegistro;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author USER 17
 */
public class Controlador {

    private EstudianteArray gestor;
    private IRegistro vista;

    public Controlador(IRegistro vista, EstudianteArray gestor) {
        this.vista = vista;
        this.gestor = gestor;

        // Asignar eventos usando los getters de los botones
        this.vista.getBtnGuardar().addActionListener(e -> guardarEstudiante());
        this.vista.getBtnBuscar().addActionListener(e -> buscarPorNombre());
        this.vista.getCargarDatos().addActionListener(e-> cargarDatosDesdeArchivo());
    }

    public void guardarEstudiante() {
        // Usar los getters para acceder a los campos
        if (vista.getTxtCodigo().getText().isEmpty() || vista.getTxtNombre().getText().isEmpty()
                || vista.getTxtApellidop().getText().isEmpty() || vista.getTxtApellidom().getText().isEmpty()
                || vista.getTxtFacultad().getText().isEmpty() || vista.getCalendario().getDate() == null) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
            return;
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setCodigo(vista.getTxtCodigo().getText());
        estudiante.setNombre(vista.getTxtNombre().getText());
        estudiante.setApellidop(vista.getTxtApellidop().getText());
        estudiante.setApellidom(vista.getTxtApellidom().getText());
        estudiante.setFacultad(vista.getTxtFacultad().getText());

        Date fechaNacimiento = vista.getCalendario().getDate();
        gestor.agregarEstudiante(estudiante, fechaNacimiento);

        gestor.limpiar(vista.getTxtCodigo(), vista.getTxtNombre(), vista.getTxtApellidop(), vista.getTxtApellidom(), vista.getTxtFacultad(), vista.getCalendario());
        gestor.actualizarTabla();

        String rutaArchivo = "D:\\DISCO D\\INGENIERIA DE SISTEMAS\\VII CICLO\\Esctructura de software\\Semana 05\\estudiantes.txt";
        gestor.guardarDatosEnArchivo(rutaArchivo);
    }

    public void buscarPorNombre() {
        String nombreBuscado = vista.getTxtBuscador().getText();
        gestor.buscarPorNombre(nombreBuscado); // Actualiza la tabla según el texto buscado
    }
        public void cargarDatosDesdeArchivo() {
        // Cargar los datos desde el archivo al iniciar el programa
        String rutaArchivo = "D:\\DISCO D\\INGENIERIA DE SISTEMAS\\VII CICLO\\Esctructura de software\\Semana 05\\estudiantes.txt";
        gestor.cargarDatosDesdeArchivo(rutaArchivo);
    }
}

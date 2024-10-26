/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Personal;
import Modelo.PersonalModelo;
import java.util.Date;
import java.util.Date;

public class SistemaController {

    private PersonalModelo modelo;

    // Constructor
    public SistemaController(PersonalModelo modelo) {
        this.modelo = modelo;
    }

    // Método para agregar nuevo personal
    public void agregarPersonal(String nombre, String apellido, Date fechaNac, Date fechaCon) {
        // Obtener nuevo código generado automáticamente
        String codigo = obtenerNuevoCodigo();
        
        // Crear un nuevo objeto de Personal
        Personal nuevoPersonal = new Personal(codigo, nombre, apellido, fechaNac, fechaCon);
        
        // Agregar el personal al modelo
        modelo.agregarPersonal(nuevoPersonal);
    }

    // Método para eliminar personal
    public boolean eliminarPersonal(String codigo) {
        return modelo.eliminarPersonal(codigo);
    }

    // Método para modificar datos de personal
    public boolean modificarPersonal(String codigo, String nombre, String apellido, Date fechaNac, Date fechaCon) {
        for (Personal personal : modelo.getListaPersonal()) {
            if (personal.getCodigo().equals(codigo)) {
                personal.setNombre(nombre);
                personal.setApellido(apellido);
                personal.setFecha_nac(fechaNac);
                personal.setFecha_con(fechaCon);
                return true;
            }
        }
        return false;
    }

    // Implementación de IA para validar las fechas de nacimiento y contratación
    public boolean validarFechas(Date fechaNac, Date fechaCon) {
        // Validación simple de que las fechas no son iguales
        if (fechaNac.equals(fechaCon)) {
            System.out.println("Error: La fecha de nacimiento y contratación no pueden ser iguales.");
            return false;
        }
        
        // Suponer que la IA realiza validaciones adicionales, como:
        // - Validar si la fecha de nacimiento parece demasiado antigua o reciente para trabajar.
        // - Verificar si la fecha de contratación es posterior a la fecha de nacimiento por un margen lógico.
        
        long edadMilis = fechaCon.getTime() - fechaNac.getTime();
        int edadAnios = (int) (edadMilis / (1000L * 60 * 60 * 24 * 365));

        if (edadAnios < 18) {
            System.out.println("Error: El empleado debe tener al menos 18 años.");
            return false;
        }

        System.out.println("Fechas validadas correctamente.");
        return true;
    }

    // Método para generar un nuevo código
    public String obtenerNuevoCodigo() {
        return "P" + String.format("%02d", modelo.getListaPersonal().size() + 1);
    }

    // Suponer que la IA puede sugerir un nombre basado en ciertos patrones o tendencias
    public String sugerirNombre() {
        // Aquí se podría utilizar un modelo de IA para sugerir nombres comunes en una región o en el historial
        // de nombres dentro del sistema. En esta simulación, devolvemos un nombre predeterminado.
        return "NombreSugerido";
    }

    // Suponer que la IA puede sugerir un apellido basado en ciertos patrones o tendencias
    public String sugerirApellido() {
        // Similar al método anterior, podríamos tener un algoritmo o modelo que sugiera apellidos.
        return "ApellidoSugerido";
    }
}

        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controlador.Conexion; // Asegúrate de importar tu clase de conexión

public class PersonalModelo {

    private List<Personal> listaPersonal;

    public PersonalModelo() {
        listaPersonal = new ArrayList<>();
    }

    // Método para agregar personal a la base de datos
    public void agregarPersonal(Personal personal) {
        Connection conexion = null;
        PreparedStatement ps = null;
        
        try {
            // Obtener la conexión desde la clase Conexion
            conexion = new Conexion().conectar();
            
            // Consulta SQL para insertar personal
            String sql = "INSERT INTO Personal (codigo, nombre, apellido, fecha_nac, fecha_con) VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, personal.getCodigo());
            ps.setString(2, personal.getNombre());
            ps.setString(3, personal.getApellido());
            ps.setDate(4, new java.sql.Date(personal.getFecha_nac().getTime()));
            ps.setDate(5, new java.sql.Date(personal.getFecha_con().getTime()));
            
            ps.executeUpdate();
            System.out.println("Personal agregado a la base de datos.");
            
        } catch (SQLException e) {
            System.out.println("Error al agregar personal: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    // Método para eliminar personal de la base de datos
    public boolean eliminarPersonal(String codigo) {
        Connection conexion = null;
        PreparedStatement ps = null;
        boolean eliminado = false;

        try {
            conexion = new Conexion().conectar();
            String sql = "DELETE FROM Personal WHERE codigo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, codigo);
            eliminado = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar personal: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return eliminado;
    }

    // Método para obtener la lista de personal desde la base de datos
    public List<Personal> getListaPersonal() {
    List<Personal> listaPersonal = new ArrayList<>();
    Connection conexion = new Conexion().conectar();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        if (conexion != null) {
            String sql = "SELECT * FROM Personal";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Personal personal = new Personal(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nac"),
                    rs.getDate("fecha_con")
                );
                listaPersonal.add(personal);
            }
        } else {
            System.out.println("No se pudo obtener la conexión.");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la lista de personal: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    return listaPersonal;
}
}

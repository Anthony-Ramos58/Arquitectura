package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    Conexion conectar = new Conexion();  // Usa tu clase de conexión
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todas las personas
    public List<Persona> listar() {
        List<Persona> datos = new ArrayList<>();
        String sql = "SELECT * FROM Persona";
        try {
            con = conectar.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));  // Almacena el ID como int
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                datos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    // Agregar una nueva persona
    public int agregar(Persona p) {
        String sql = "INSERT INTO Persona (nombres, correo, numero) VALUES (?, ?, ?)";
        try {
            con = conectar.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    // Actualizar una persona
    public int actualizar(Persona p) {
        String sql = "UPDATE Persona SET nombres=?, correo=?, numero=? WHERE id=?";
        try {
            con = conectar.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTelefono());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    // Eliminar una persona por su ID
    public void eliminar(int id) {
        String sql = "DELETE FROM Persona WHERE id=?";
        try {
            con = conectar.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
private final String URL = "jdbc:sqlserver://mi-servidor-anthony-sql.database.windows.net:1433;databaseName=RegistroPersonal;encrypt=true;trustServerCertificate=true";
    private final String USER = "Anthony";
    private final String PASSWORD = "Anteral5885";  

    public Connection conectar() {
        try {
            // Registrar el driver explícitamente
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a SQL Server.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el driver JDBC.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}


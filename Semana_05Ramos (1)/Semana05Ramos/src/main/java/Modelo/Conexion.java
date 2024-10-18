package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public Connection conectar() {
        Connection connection = null;
        try {
            // Registrar el controlador JDBC de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Configurar la cadena de conexión
String url = "jdbc:sqlserver://192.168.1.39:1433;databaseName=BaseDeDatosRegistro;encrypt=false;trustServerCertificate=true;loginTimeout=30";

            String usuario = "sa"; // Cambia este usuario por el tuyo
            String contraseña = "123"; // Cambia esta contraseña por la tuya

            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(url, usuario, contraseña);

            System.out.println("Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC de SQL Server.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }
}

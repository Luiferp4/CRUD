package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {
    private Connection connection;

    public void estableceConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/dbproductos";
            String usuario = "root";
            String contraseña = "root";
            connection = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}

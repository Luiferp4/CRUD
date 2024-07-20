package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CProductos {
    private final Connection connection;

    public CProductos(Connection connection) {
        this.connection = connection;
    }

    public void AgregarProducto(int id, String nombre, String fabricante, float precio, File archivoImagen) throws IOException {
        String sql = "INSERT INTO productos (id, nombre, fabricante, precio, imagen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, nombre);
            statement.setString(3, fabricante);
            statement.setFloat(4, precio);
            if (archivoImagen != null) {
                try (InputStream inputStream = new FileInputStream(archivoImagen)) {
                    statement.setBlob(5, inputStream);
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado: " + ex.getMessage());
                }
            } else {
                statement.setNull(5, java.sql.Types.BLOB);
            }
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al agregar producto: " + ex.getMessage());
        }
    }

    public void ModificarProducto(int id, String nombre, String fabricante, float precio, File archivoImagen) throws IOException {
        String sql = "UPDATE productos SET nombre = ?, fabricante = ?, precio = ?, imagen = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, fabricante);
            statement.setFloat(3, precio);
            if (archivoImagen != null) {
                try (InputStream inputStream = new FileInputStream(archivoImagen)) {
                    statement.setBlob(4, inputStream);
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado: " + ex.getMessage());
                }
            } else {
                statement.setNull(4, java.sql.Types.BLOB);
            }
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar producto: " + ex.getMessage());
        }
    }

    public void EliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar producto: " + ex.getMessage());
        }
    }

    public void MostrarProductos(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        String sql = "SELECT id, nombre, fabricante, precio, imagen FROM productos";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Object[] row = {
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getString("fabricante"),
                    result.getFloat("precio"),
                    result.getString("imagen")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error al mostrar productos: " + ex.getMessage());
        }
    }
}

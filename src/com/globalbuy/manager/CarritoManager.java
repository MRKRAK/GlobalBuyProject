package com.globalbuy.manager;

import com.globalbuy.util.GlobalBuyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarritoManager {
    public void agregarProductoAlCarrito(int idUsuario, int idProducto, int cantidad, double precio) {
        try (Connection conn = GlobalBuyConnection.getConnection()) {
            String sql = "INSERT INTO Carrito_Productos (id_carrito, id_producto, cantidad, precio) " +
                         "VALUES ((SELECT id_carrito FROM Carrito WHERE id_usuario = ?), ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idProducto);
            pstmt.setInt(3, cantidad);
            pstmt.setDouble(4, precio);
            pstmt.executeUpdate();
            System.out.println("Producto agregado al carrito exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto al carrito: " + e.getMessage());
        }
    }

    public void verCarrito(int idUsuario) {
        try (Connection conn = GlobalBuyConnection.getConnection()) {
            String sql = "SELECT cp.id_carrito_producto, p.nombre, cp.cantidad, cp.precio " +
                         "FROM Carrito_Productos cp " +
                         "JOIN Productos p ON cp.id_producto = p.id_producto " +
                         "WHERE cp.id_carrito = (SELECT id_carrito FROM Carrito WHERE id_usuario = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idCarritoProducto = rs.getInt("id_carrito_producto");
                String nombreProducto = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                System.out.println("ID Carrito Producto: " + idCarritoProducto +
                                   ", Nombre: " + nombreProducto +
                                   ", Cantidad: " + cantidad +
                                   ", Precio: " + precio);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el carrito: " + e.getMessage());
        }
    }

    public void eliminarProductoDelCarrito(int idUsuario, int idProducto) {
        try (Connection conn = GlobalBuyConnection.getConnection()) {
            String sql = "DELETE FROM Carrito_Productos " +
                         "WHERE id_carrito = (SELECT id_carrito FROM Carrito WHERE id_usuario = ?) " +
                         "AND id_producto = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idProducto);
            pstmt.executeUpdate();
            System.out.println("Producto eliminado del carrito exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto del carrito: " + e.getMessage());
        }
    }
}

package com.globalbuy.manager;

import com.globalbuy.model.Compra;
import com.globalbuy.util.GlobalBuyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraManager {

    // Método para agregar una nueva compra
    public boolean agregarCompra(Compra compra) {
        String query = "INSERT INTO Compras (id_usuario, monto_total, fecha_compra, total_pagado) VALUES (?, ?, ?, ?)";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, compra.getIdUsuario());
            pstmt.setDouble(2, compra.getMontoTotal());
            pstmt.setDate(3, new java.sql.Date(compra.getFechaCompra().getTime())); // Convertir java.util.Date a java.sql.Date
            pstmt.setDouble(4, compra.getTotalPagado()); // Total pagado

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        compra.setIdCompra(generatedKeys.getInt(1));
                    }
                }
            }

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar la compra: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener el historial de compras de un usuario
    public List<Compra> obtenerHistorialDeCompras(int idUsuario) {
        List<Compra> compras = new ArrayList<>();
        String query = "SELECT * FROM Compras WHERE id_usuario = ?";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Compra compra = new Compra();
                    compra.setIdCompra(rs.getInt("id_compra"));
                    compra.setIdUsuario(rs.getInt("id_usuario"));
                    compra.setMontoTotal(rs.getDouble("monto_total"));
                    compra.setFechaCompra(rs.getDate("fecha_compra"));  // Obtener la fecha de compra
                    compra.setTotalPagado(rs.getDouble("total_pagado")); // Obtener el total pagado

                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el historial de compras: " + e.getMessage());
        }
        return compras;
    }

    // Método para eliminar una compra por su ID
    public boolean eliminarCompra(int idCompra) {
        String query = "DELETE FROM Compras WHERE id_compra = ?";
        try (Connection conn = GlobalBuyConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idCompra);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la compra: " + e.getMessage());
            return false;
        }
    }
}

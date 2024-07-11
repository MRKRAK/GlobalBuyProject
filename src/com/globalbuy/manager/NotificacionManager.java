package com.globalbuy.manager;

import com.globalbuy.model.Notificacion;
import com.globalbuy.util.GlobalBuyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificacionManager {
    private Connection connection;

    public NotificacionManager() {
        connection = GlobalBuyConnection.getConnection();
    }

    public boolean agregarNotificacion(Notificacion notificacion) {
        String sql = "INSERT INTO notificaciones (id_usuario, mensaje, leido, fecha_envio) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, notificacion.getIdUsuario());
            ps.setString(2, notificacion.getMensaje());
            ps.setBoolean(3, notificacion.isLeido());
            ps.setTimestamp(4, new java.sql.Timestamp(notificacion.getFecha().getTime()));
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Notificacion> obtenerNotificacionesPorUsuario(int idUsuario) {
        String sql = "SELECT * FROM notificaciones WHERE id_usuario = ?";
        List<Notificacion> notificaciones = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notificacion notificacion = new Notificacion(
                    rs.getInt("id_notificacion"),
                    rs.getInt("id_usuario"),
                    rs.getString("mensaje"),
                    rs.getBoolean("leido"),
                    rs.getTimestamp("fecha_envio")
                );
                notificaciones.add(notificacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificaciones;
    }

    public boolean marcarComoLeida(int idNotificacion) {
        String sql = "UPDATE notificaciones SET leido = ? WHERE id_notificacion = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, idNotificacion);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

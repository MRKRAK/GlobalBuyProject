package com.globalbuy.test;

import com.globalbuy.manager.NotificacionManager;
import com.globalbuy.model.Notificacion;
import java.util.Date;
import java.util.List;

public class TestNotificacionManager {

    public static void main(String[] args) {
        NotificacionManager notificacionManager = new NotificacionManager();

        // Prueba de agregar notificación
        Notificacion nuevaNotificacion = new Notificacion(0, 1, "Tu pedido ha sido enviado", false, new Date());
        boolean agregada = notificacionManager.agregarNotificacion(nuevaNotificacion);
        if (agregada) {
            System.out.println("Notificación agregada exitosamente.");
        } else {
            System.out.println("Error al agregar la notificación.");
        }

        // Prueba de obtener notificaciones por usuario
        List<Notificacion> notificaciones = notificacionManager.obtenerNotificacionesPorUsuario(1);
        if (!notificaciones.isEmpty()) {
            for (Notificacion n : notificaciones) {
                System.out.println("Notificación: " + n.getMensaje() + ", Leído: " + n.isLeido());
            }
        } else {
            System.out.println("No se encontraron notificaciones para el usuario.");
        }

        // Prueba de marcar notificación como leída
        if (!notificaciones.isEmpty()) {
            boolean marcada = notificacionManager.marcarComoLeida(notificaciones.get(0).getIdNotificacion());
            if (marcada) {
                System.out.println("Notificación marcada como leída exitosamente.");
            } else {
                System.out.println("Error al marcar la notificación como leída.");
            }
        }
    }
}

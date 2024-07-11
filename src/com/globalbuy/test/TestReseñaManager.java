package com.globalbuy.test;

import com.globalbuy.manager.ReseñaManager;
import com.globalbuy.model.Reseña;
import java.util.List;

public class TestReseñaManager {

    public static void main(String[] args) {
        ReseñaManager reseñaManager = new ReseñaManager();

        // Prueba de agregar reseña
        Reseña nuevaReseña = new Reseña(6, 1, 5, "Excelente producto", new java.util.Date());
        boolean agregada = reseñaManager.agregarReseña(nuevaReseña);
        if (agregada) {
            System.out.println("Reseña agregada exitosamente.");
        } else {
            System.out.println("Error al agregar la reseña.");
        }

        // Prueba de obtener reseñas por producto
        List<Reseña> reseñas = reseñaManager.obtenerReseñasPorProducto(1);
        if (!reseñas.isEmpty()) {
            System.out.println("Reseñas encontradas para el producto 1:");
            for (Reseña reseña : reseñas) {
                System.out.println(reseña);
            }
        } else {
            System.out.println("No se encontraron reseñas para el producto 1.");
        }

        // Prueba de actualizar reseña
        if (!reseñas.isEmpty()) {
            Reseña reseñaModificar = reseñas.get(0);
            reseñaModificar.setCalificación(4);
            reseñaModificar.setComentario("Buen producto, recomiendo.");
            boolean actualizada = reseñaManager.actualizarReseña(reseñaModificar);
            if (actualizada) {
                System.out.println("Reseña actualizada exitosamente.");
            } else {
                System.out.println("Error al actualizar la reseña.");
            }
        }

        // Prueba de eliminar reseña
        if (!reseñas.isEmpty()) {
            Reseña reseñaEliminar = reseñas.get(0);
            boolean eliminada = reseñaManager.eliminarReseña(reseñaEliminar.getIdReseña());
            if (eliminada) {
                System.out.println("Reseña eliminada exitosamente.");
            } else {
                System.out.println("Error al eliminar la reseña.");
            }
        }
    }
}

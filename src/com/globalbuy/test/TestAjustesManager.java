package com.globalbuy.test;

import com.globalbuy.manager.AjustesManager;
import com.globalbuy.model.Ajustes;

public class TestAjustesManager {

    public static void main(String[] args) {
        AjustesManager ajustesManager = new AjustesManager();

        // Prueba de cambiar el tema
        boolean temaCambiado = ajustesManager.cambiarTema("Oscuro");
        if (temaCambiado) {
            System.out.println("Tema cambiado exitosamente.");
        } else {
            System.out.println("Error al cambiar el tema.");
        }

        // Prueba de actualizar privacidad
        boolean privacidadActualizada = ajustesManager.actualizarPrivacidad("Alta");
        if (privacidadActualizada) {
            System.out.println("Privacidad actualizada exitosamente.");
        } else {
            System.out.println("Error al actualizar la privacidad.");
        }

        // Prueba de obtener ayuda
        boolean ayudaObtenida = ajustesManager.obtenerAyuda();
        if (ayudaObtenida) {
            System.out.println("Ayuda obtenida exitosamente.");
        } else {
            System.out.println("Error al obtener ayuda.");
        }
    }
}

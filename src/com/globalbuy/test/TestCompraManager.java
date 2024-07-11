package com.globalbuy.test;

import com.globalbuy.manager.CompraManager;
import com.globalbuy.model.Compra;

import java.util.Date;
import java.util.List;

public class TestCompraManager {
    public static void main(String[] args) {
        CompraManager compraManager = new CompraManager();

        // Agregar una nueva compra
        Compra nuevaCompra = new Compra();
        nuevaCompra.setIdUsuario(1);  // Asignar un usuario existente
        nuevaCompra.setMontoTotal(150.75);
        nuevaCompra.setFechaCompra(new Date());  // Asignar la fecha actual
        nuevaCompra.setTotalPagado(150.75);  // Asignar el total pagado

        if (compraManager.agregarCompra(nuevaCompra)) {
            System.out.println("Compra agregada exitosamente.");
        } else {
            System.out.println("Hubo un error al agregar la compra.");
        }

        // Obtener el historial de compras de un usuario
        List<Compra> compras = compraManager.obtenerHistorialDeCompras(1);  // Asignar un usuario existente
        if (compras.isEmpty()) {
            System.out.println("No se encontraron compras en el historial.");
        } else {
            System.out.println("Historial de compras:");
            for (Compra compra : compras) {
                System.out.println("ID Compra: " + compra.getIdCompra() +
                                   ", ID Usuario: " + compra.getIdUsuario() +
                                   ", Monto Total: " + compra.getMontoTotal() +
                                   ", Fecha de Compra: " + compra.getFechaCompra() +
                                   ", Total Pagado: " + compra.getTotalPagado());
            }
        }

        // Eliminar una compra por ID
        if (compraManager.eliminarCompra(nuevaCompra.getIdCompra())) {
            System.out.println("Compra eliminada exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar la compra.");
        }
    }
}

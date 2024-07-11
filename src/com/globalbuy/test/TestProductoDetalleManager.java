package com.globalbuy.test;

import com.globalbuy.manager.ProductoDetalleManager;
import com.globalbuy.model.Producto;

public class TestProductoDetalleManager {

    public static void main(String[] args) {
        ProductoDetalleManager detalleManager = new ProductoDetalleManager();

        // Ejemplo: Obtener el detalle del producto con ID 1
        int idProducto = 2;
        Producto producto = detalleManager.obtenerProductoPorId(idProducto);

        if (producto != null) {
            System.out.println("Detalle del Producto:");
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Categoría ID: " + producto.getCategoriaID());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("URL de Imagen: " + producto.getImagenUrl());
        } else {
            System.out.println("No se encontró ningún producto con ID " + idProducto);
        }
    }
}

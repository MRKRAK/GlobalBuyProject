package com.globalbuy.test;

import com.globalbuy.manager.CarritoManager;

public class TestCarritoManager {
    public static void main(String[] args) {
        CarritoManager carritoManager = new CarritoManager();

        int idUsuario = 1; // Asegúrate de que este usuario exista en la base de datos
        int idProducto = 2; // Asegúrate de que este producto exista en la base de datos
        int cantidad = 1;
        double precio = 599.99; // Precio del producto

        carritoManager.agregarProductoAlCarrito(idUsuario, idProducto, cantidad, precio);
        carritoManager.verCarrito(idUsuario);
        carritoManager.eliminarProductoDelCarrito(idUsuario, idProducto);
        carritoManager.verCarrito(idUsuario);
    }
}

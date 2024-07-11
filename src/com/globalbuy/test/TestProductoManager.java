package com.globalbuy.test;

import com.globalbuy.manager.ProductoManager;
import com.globalbuy.model.Producto;

public class TestProductoManager {
    public static void main(String[] args) {
        ProductoManager productoManager = new ProductoManager();

        // Crear un nuevo producto para la prueba
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre("Laptop XYZ");
        nuevoProducto.setDescripcion("Laptop de alto rendimiento con 16GB RAM y 512GB SSD");
        nuevoProducto.setPrecio(1200.00);
        nuevoProducto.setCategoriaID(1);  // Asegúrate de que este ID de categoría existe
        nuevoProducto.setStock(50);
        nuevoProducto.setImagenUrl("http://example.com/laptop-xyz.jpg");

        // Agregar el nuevo producto
        if (productoManager.agregarProducto(nuevoProducto)) {
            System.out.println("Producto agregado exitosamente.");
        } else {
            System.out.println("Hubo un error al agregar el producto.");
        }

        // Obtener y listar todos los productos
        System.out.println("Lista de productos:");
        for (Producto producto : productoManager.obtenerTodosLosProductos()) {
            System.out.println("ID: " + producto.getIdProducto() + ", Nombre: " + producto.getNombre());
        }

        // Actualizar el producto
        nuevoProducto.setNombre("Laptop XYZ Actualizada");
        if (productoManager.actualizarProducto(nuevoProducto)) {
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Hubo un error al actualizar el producto.");
        }

        // Eliminar el producto
        if (productoManager.eliminarProducto(nuevoProducto.getIdProducto())) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar el producto.");
        }
    }
}

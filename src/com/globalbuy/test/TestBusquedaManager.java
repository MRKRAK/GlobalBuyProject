package com.globalbuy.test;

import com.globalbuy.manager.BusquedaManager;
import java.util.List;

public class TestBusquedaManager {
    public static void main(String[] args) {
        BusquedaManager busquedaManager = new BusquedaManager();

        System.out.println("Buscar productos por nombre 'Laptop':");
        List<String> productosNombre = busquedaManager.buscarProductosPorNombre("Laptop");
        productosNombre.forEach(System.out::println);

        System.out.println("\nFiltrar productos por categoría ID 1:");
        List<String> productosCategoria = busquedaManager.filtrarProductosPorCategoria(1);
        productosCategoria.forEach(System.out::println);

        System.out.println("\nFiltrar productos por precio entre 100 y 1000:");
        List<String> productosPrecio = busquedaManager.filtrarProductosPorPrecio(100, 1000);
        productosPrecio.forEach(System.out::println);
    }
}

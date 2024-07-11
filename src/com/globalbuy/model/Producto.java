package com.globalbuy.model;

public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int categoriaID;
    private int stock;
    private String imagenUrl;

    // Constructor por defecto
    public Producto() {}

    // Constructor con parámetros
    public Producto(int idProducto, String nombre, String descripcion, double precio, int categoriaID, int stock, String imagenUrl) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaID = categoriaID;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}

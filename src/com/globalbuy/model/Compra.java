package com.globalbuy.model;

import java.util.Date;

public class Compra {
    private int idCompra;
    private int idUsuario;
    private double montoTotal;
    private Date fechaCompra;
    private double totalPagado;  // Nuevo campo

    // Constructor por defecto
    public Compra() {}

    // Constructor con parámetros
    public Compra(int idCompra, int idUsuario, double montoTotal, Date fechaCompra, double totalPagado) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.montoTotal = montoTotal;
        this.fechaCompra = fechaCompra;
        this.totalPagado = totalPagado;
    }

    // Getters y Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }
}

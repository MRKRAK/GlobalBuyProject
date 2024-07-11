package com.globalbuy.model;

import java.util.Date;

public class Notificacion {
    private int idNotificacion;
    private int idUsuario;
    private String mensaje;
    private boolean leido;
    private Date fecha;

    // Constructor por defecto
    public Notificacion() {
    }

    // Constructor con parámetros
    public Notificacion(int idNotificacion, int idUsuario, String mensaje, boolean leido, Date fecha) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.leido = leido;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

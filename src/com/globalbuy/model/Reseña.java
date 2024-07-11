package com.globalbuy.model;

import java.util.Date;

public class Reseña {
    private int idReseña;
    private int idProducto;
    private int idUsuario;
    private int calificación;
    private String comentario;
    private Date fechaReseña;

    public Reseña() {
    }

    public Reseña(int idProducto, int idUsuario, int calificación, String comentario, Date fechaReseña) {
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.calificación = calificación;
        this.comentario = comentario;
        this.fechaReseña = fechaReseña;
    }

    public int getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(int idReseña) {
        this.idReseña = idReseña;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCalificación() {
        return calificación;
    }

    public void setCalificación(int calificación) {
        this.calificación = calificación;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaReseña() {
        return fechaReseña;
    }

    public void setFechaReseña(Date fechaReseña) {
        this.fechaReseña = fechaReseña;
    }

    @Override
    public String toString() {
        return "Reseña{" +
                "idReseña=" + idReseña +
                ", idProducto=" + idProducto +
                ", idUsuario=" + idUsuario +
                ", calificación=" + calificación +
                ", comentario='" + comentario + '\'' +
                ", fechaReseña=" + fechaReseña +
                '}';
    }
}

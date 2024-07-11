package com.globalbuy.model;

public class Ajustes {
    private String tema;
    private String privacidad;

    // Constructores, getters y setters
    public Ajustes() {}

    public Ajustes(String tema, String privacidad) {
        this.tema = tema;
        this.privacidad = privacidad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }
}

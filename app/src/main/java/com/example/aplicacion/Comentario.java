package com.example.aplicacion;

public class Comentario {
    private String nombreUsuario;
    private String contenido;

    public Comentario(String nombreUsuario, String contenido) {
        this.nombreUsuario = nombreUsuario;
        this.contenido = contenido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContenido() {
        return contenido;
    }
}

package com.example.Nutreapp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Video {
    @Id
    private UUID id;

    private String titulo;
    private String descripcion;
    private String url;

    @ManyToOne
    private Usuario usuario;

    public Video() {
    }

    public Video(String descripcion, UUID id, String titulo, String url, Usuario usuario) {
        this.descripcion = descripcion;
        this.id = id;
        this.titulo = titulo;
        this.url = url;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

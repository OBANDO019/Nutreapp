package com.example.Nutreapp.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Video {
    @Id
    private UUID id;

    private String titulo;
    private String descripcion;
    private String url;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference(value = "video-visualizaciones")
    private List<Visualizacion> visualizaciones;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Visualizacion> getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(List<Visualizacion> visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
}

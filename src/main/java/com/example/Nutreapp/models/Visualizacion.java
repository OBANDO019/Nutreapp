package com.example.Nutreapp.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visualizaciones")
public class Visualizacion {

    @Id
    private UUID id;

    @Column(name = "fecha_visualizacion")
    private LocalDate fechaVisualizacion;

    private Boolean completado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "usuario-visualizaciones")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference(value = "video-visualizaciones")
    private Video video;

    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fechaVisualizacion, Boolean completado) {
        this.id = id;
        this.fechaVisualizacion = fechaVisualizacion;
        this.completado = completado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(LocalDate fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}

package com.example.Nutreapp.models;
import java.time.LocalDate;
import java.util.UUID;

public class Visualizacion {

    private UUID id;
    private LocalDate fecha_visualizacion;
    private Boolean completado;

    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fecha_visualizacion, Boolean completado) {
        this.id = id;
        this.fecha_visualizacion = fecha_visualizacion;
        this.completado = completado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFecha_visualizacion() {
        return fecha_visualizacion;
    }

    public void setFecha_visualizacion(LocalDate fecha_visualizacion) {
        this.fecha_visualizacion = fecha_visualizacion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

 

  
}

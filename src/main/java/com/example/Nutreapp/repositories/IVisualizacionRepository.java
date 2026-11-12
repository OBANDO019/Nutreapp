package com.example.Nutreapp.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Nutreapp.models.Visualizacion;
import com.example.Nutreapp.models.helpers.Departamento;

public interface IVisualizacionRepository extends JpaRepository<Visualizacion, UUID> {

    List<Visualizacion> findByFechaVisualizacion(LocalDate fecha);
    List<Visualizacion> findByFechaVisualizacionAndCompletado(LocalDate fecha, Boolean completado);
    List<Visualizacion> findByFechaVisualizacionAndCompletadoTrue(LocalDate fecha);
    List<Visualizacion> findByFechaVisualizacionAndCompletadoFalse(LocalDate fecha);

    @Query("SELECT v FROM Visualizacion v JOIN v.usuario u WHERE u.departamento = :departamento")
    List<Visualizacion> buscarVisualizacionesPorDepartamento(@Param("departamento") Departamento departamento);
}

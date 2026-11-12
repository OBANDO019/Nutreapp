package com.example.Nutreapp.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Nutreapp.models.Video;

public interface IVideoRepositories extends JpaRepository<Video, UUID> {

    List<Video> findByCategoriaIgnoreCase(String categoria);

    List<Video> findByTituloIgnoreCase(String titulo);

    Video findByUrl(String url);

    List<Video> findByTituloIgnoreCaseAndCategoriaIgnoreCase(String titulo, String categoria);

    List<Video> findByCategoriaIgnoreCaseAndTituloIgnoreCase(String categoria, String titulo);

    @Query("SELECT v FROM Video v WHERE LOWER(v.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Video> buscarPorTitulo(@Param("titulo") String titulo);
}

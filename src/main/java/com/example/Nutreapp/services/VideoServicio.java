package com.example.Nutreapp.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import com.example.Nutreapp.models.Video;
import com.example.Nutreapp.repositories.IVideoRepositories;

public class VideoServicio {

    //INVECCION DE DEPENDENCIAS
    @Autowired 
    private IVideoRepositories Repositorio;

    //metodo para guardar
     public Video guardar(Video datos){
        return this.Repositorio.save(datos);
    
    }
    
    //metodo para buscar por id
    
    //metodo para buscar todos
    
    //metodo para modificar
    
    //metodo para eliminar
    
    //metodo para buscar por depto y rol
    
    //metodo para buscar por correo
    
    //metodo para buscar por rol
    
    //metodo para evrificar correo

 public Video buscarporvideo(UUID id){
    Optional<Video> videoBuscado = this.Repositorio.findById(id);
    if (videoBuscado.isPresent()){
        return videoBuscado.get();
    }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }
}
public List<Video> buscarTodo(){
    return this.Repositorio.findAll();
}

public Video buscarporid(UUID id){
    Optional<Video> videoBuscado = this.Repositorio.findById(id);
    if (videoBuscado.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        return videoBuscado.get();
    }
}

public Video modificar(UUID id, Video datos){
    Optional<Video> videoBuscado = this.Repositorio.findById(id);
    if (videoBuscado.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        Video videoEncontrado = videoBuscado.get();
        // aqui tus setters, ej: videoEncontrado.setTitulo(datos.getTitulo());
        this.Repositorio.save(videoEncontrado);
        return videoEncontrado;
    }
}

}
package com.example.Nutreapp.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.Nutreapp.models.Visualizacion;
import com.example.Nutreapp.repositories.IVisualizacionRepository;

import java.util.List;
import java.util.Optional;





public class VisualizacionServicio {

    //INVECCION DE DEPENDENCIAS
    @Autowired 
    private IVisualizacionRepository Repositorio;

    //metodo para guardar
    public Visualizacion guardar(Visualizacion datos){
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


    public Visualizacion buscarPorId(UUID id){
    Optional<Visualizacion> visualizacionBuscada = this.Repositorio.findById(id);
    if (visualizacionBuscada.isPresent()){
        return visualizacionBuscada.get();
    }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }
}

public Visualizacion buscarporid(UUID id){
    Optional<Visualizacion> visualizacionBuscada = this.Repositorio.findById(id);
    if (visualizacionBuscada.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        return visualizacionBuscada.get();
    }
}

public List<Visualizacion> buscarTodo(){
    return this.Repositorio.findAll();
}

public Visualizacion modificar(UUID id, Visualizacion datos){
    Optional<Visualizacion> visualizacionBuscada = this.Repositorio.findById(id);
    if (visualizacionBuscada.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        Visualizacion visualizacionEncontrada = visualizacionBuscada.get();
        // aqui tus setters, ej: visualizacionEncontrada.setCampo(datos.getCampo());
        this.Repositorio.save(visualizacionEncontrada);
        return visualizacionEncontrada;
    }
}

}
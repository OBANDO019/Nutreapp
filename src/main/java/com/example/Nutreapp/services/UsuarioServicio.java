package com.example.Nutreapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Nutreapp.models.Usuario;
import com.example.Nutreapp.repositories.InnerIUsuarioRepositorio;

@Service 
public class UsuarioServicio {
// metodo para guardar 
// metodo para actualizar 
//metodo para buscar por id 
//metodo para buscar todo 
//metodo para Eliminar
//metodo para buscar por depa y rol
//metodo para buscar por correo
//metodo para buscar por rol
//metodo para verificar por correo

@Autowired
private InnerIUsuarioRepositorio repositorio;

public Usuario guardar(Usuario datos){
    return  this.repositorio.save(datos);

}

public Usuario buscarporid(UUID id){
   Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
   if (usuarioBuscado.isPresent()){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
   }else{
    return usuarioBuscado.get();
   }
   

}

public List<Usuario> buscarTodo(){
    return this.repositorio.findAll();
}

public Usuario modificar(UUID id, Usuario datos){
    Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
    if (usuarioBuscado.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        Usuario usuarioEncontrado = usuarioBuscado.get();
        usuarioEncontrado.setNombre(datos.getNombre());
        usuarioEncontrado.setRol(datos.getRol());
        this.repositorio.save(usuarioEncontrado);
        return usuarioEncontrado;
    }
}

public boolean eliminar(UUID id){
    Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
    if (usuarioBuscado.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no encontrado");
    }else{
        this.repositorio.deleteById(id);
        return true;
    }
}
}

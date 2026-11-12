package com.example.Nutreapp.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Nutreapp.models.Usuario;
import com.example.Nutreapp.models.helpers.Departamento;
import com.example.Nutreapp.models.helpers.Rol;

@Repository
public interface InnerIUsuarioRepositorio extends JpaRepository<Usuario, UUID> {

   //consulta prefabricadas(Buscar )

   //1. Buscar un usuario asociado a un departamento y un rol especifico
   List<Usuario> findByDepartamentoAndRol(Departamento departamento, Rol rol);

   Optional<Usuario> findByCorreo(String correo);

   List<Usuario> findByRolOrderByNombre(String rol); 

   boolean existsByCorreo(String correo);

   

}

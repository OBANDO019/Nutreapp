package com.example.Nutreapp.models;

import java.util.List;
import java.util.UUID;

import com.example.Nutreapp.models.helpers.Departamento;
import com.example.Nutreapp.models.helpers.Rol;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "rol", nullable = false)
    private Rol rol;

    @Column(name = "departamento", nullable = false)
    private Departamento departamento;

    @Column(name = "contrasena_hash", nullable = false)
    private String contrasena_hash;

    @OneToMany (mappedBy = "usuario")
    @JsonManagedReference(value = "usuario-visualizaciones")
    private List<Visualizacion> visualizaciones;

    

    public Usuario() {
    }

    public Usuario(String contrasena_hash, String correo, Departamento departamento, UUID id, String nombre, Rol rol) {
        this.contrasena_hash = contrasena_hash;
        this.correo = correo;
        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getContrasena_hash() {
        return contrasena_hash;
    }

    public void setContrasena_hash(String contrasena_hash) {
        this.contrasena_hash = contrasena_hash;
    }
}

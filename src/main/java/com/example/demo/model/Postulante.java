package com.example.demo.model;

/**
 * Modelo de dominio para Postulante.
 * No tiene anotaciones JPA — es el objeto que viaja entre Controller y Service.
 * Su equivalente con persistencia es PostulanteEntity.
 */
public class Postulante {

    private Long id;
    private String nombre;
    private String email;

    public Postulante() {
    }

    public Postulante(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

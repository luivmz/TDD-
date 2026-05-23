package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * Entidad JPA para la tabla `postulante`.
 * Es el objeto que se persiste en H2 a través de PostulanteRepository.
 * El modelo de dominio equivalente (sin JPA) es Postulante.
 */
@Entity(name = "postulante")
public class PostulanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    public PostulanteEntity() {
    }

    public PostulanteEntity(Long id, String nombre, String email) {
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

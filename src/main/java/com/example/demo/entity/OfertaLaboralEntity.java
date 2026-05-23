package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * Entidad JPA para la tabla `oferta_laboral`.
 * Es el objeto que se persiste en H2 a través de OfertaLaboralRepository.
 * El modelo de dominio equivalente (sin JPA) es OfertaLaboral.
 */
@Entity(name = "oferta_laboral")
public class OfertaLaboralEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    public OfertaLaboralEntity() {
    }

    public OfertaLaboralEntity(Long id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

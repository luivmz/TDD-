package com.example.demo.model;

/**
 * Modelo de dominio para OfertaLaboral.
 * No tiene anotaciones JPA — es el objeto que viaja entre Controller y Service.
 * Su equivalente con persistencia es OfertaLaboralEntity.
 */
public class OfertaLaboral {

    private Long id;
    private String titulo;
    private String descripcion;

    public OfertaLaboral() {
    }

    public OfertaLaboral(Long id, String titulo, String descripcion) {
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

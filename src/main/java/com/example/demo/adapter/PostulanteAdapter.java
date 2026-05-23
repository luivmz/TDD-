package com.example.demo.adapter;

import com.example.demo.entity.PostulanteEntity;
import com.example.demo.model.Postulante;
import org.springframework.stereotype.Component;

/**
 * Adapter que convierte entre el modelo de dominio Postulante
 * y la entidad JPA PostulanteEntity.
 *
 * Convierte entre modelo de dominio y entidad JPA.
 */
@Component
public class PostulanteAdapter {

    /**
     * Convierte PostulanteEntity → Postulante (model).
     * Se usa al leer desde la base de datos.
     */
    public Postulante toModel(PostulanteEntity entity) {
        if (entity == null) {
            return null;
        }
        Postulante postulante = new Postulante();
        postulante.setId(entity.getId());
        postulante.setNombre(entity.getNombre());
        postulante.setEmail(entity.getEmail());
        return postulante;
    }

    /**
     * Convierte Postulante (model) → PostulanteEntity.
     * Se usa antes de persistir en la base de datos.
     */
    public PostulanteEntity toEntity(Postulante model) {
        if (model == null) {
            return null;
        }
        PostulanteEntity entity = new PostulanteEntity();
        entity.setNombre(model.getNombre());
        entity.setEmail(model.getEmail());
        // No se copia el id: H2 lo genera con IDENTITY
        return entity;
    }
}

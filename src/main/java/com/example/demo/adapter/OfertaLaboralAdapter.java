package com.example.demo.adapter;

import com.example.demo.entity.OfertaLaboralEntity;
import com.example.demo.model.OfertaLaboral;
import org.springframework.stereotype.Component;

/**
 * Adapter que convierte entre el modelo de dominio OfertaLaboral
 * y la entidad JPA OfertaLaboralEntity.
 *
 * Convierte entre modelo de dominio y entidad JPA.
 */
@Component
public class OfertaLaboralAdapter {

    /**
     * Convierte OfertaLaboralEntity → OfertaLaboral (model).
     * Se usa al leer desde la base de datos.
     */
    public OfertaLaboral toModel(OfertaLaboralEntity entity) {
        if (entity == null) {
            return null;
        }
        OfertaLaboral oferta = new OfertaLaboral();
        oferta.setId(entity.getId());
        oferta.setTitulo(entity.getTitulo());
        oferta.setDescripcion(entity.getDescripcion());
        return oferta;
    }

    /**
     * Convierte OfertaLaboral (model) → OfertaLaboralEntity.
     * Se usa antes de persistir en la base de datos.
     */
    public OfertaLaboralEntity toEntity(OfertaLaboral model) {
        if (model == null) {
            return null;
        }
        OfertaLaboralEntity entity = new OfertaLaboralEntity();
        entity.setTitulo(model.getTitulo());
        entity.setDescripcion(model.getDescripcion());
        // No se copia el id: H2 lo genera con IDENTITY
        return entity;
    }
}

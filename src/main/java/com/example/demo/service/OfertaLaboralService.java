package com.example.demo.service;

import com.example.demo.adapter.OfertaLaboralAdapter;
import com.example.demo.entity.OfertaLaboralEntity;
import com.example.demo.model.OfertaLaboral;
import com.example.demo.repository.OfertaLaboralRepository;
import org.springframework.stereotype.Service;

@Service
public class OfertaLaboralService {

    private final OfertaLaboralRepository ofertaLaboralRepository;
    private final OfertaLaboralAdapter ofertaLaboralAdapter;

    public OfertaLaboralService(OfertaLaboralRepository ofertaLaboralRepository,
                                OfertaLaboralAdapter ofertaLaboralAdapter) {
        this.ofertaLaboralRepository = ofertaLaboralRepository;
        this.ofertaLaboralAdapter = ofertaLaboralAdapter;
    }

    public OfertaLaboral crearOferta(OfertaLaboral oferta) {
        OfertaLaboralEntity entity = ofertaLaboralAdapter.toEntity(oferta); //F3 ref
        OfertaLaboralEntity savedEntity = ofertaLaboralRepository.save(entity); //F3 ref
        return ofertaLaboralAdapter.toModel(savedEntity); //F3 ref
        //OfertaLaboral resp = new OfertaLaboral(); //F1 rojo
        //resp.setTitulo(oferta.getTitulo()); //F2 verde
        //resp.setDescripcion(oferta.getDescripcion()); //F2 verde
        //return resp; //
    }
}

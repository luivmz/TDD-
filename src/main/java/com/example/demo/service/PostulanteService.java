package com.example.demo.service;

import com.example.demo.adapter.PostulanteAdapter;
import com.example.demo.entity.PostulanteEntity;
import com.example.demo.model.Postulante;
import com.example.demo.repository.PostulanteRepository;
import org.springframework.stereotype.Service;

@Service
public class PostulanteService {

    private final PostulanteRepository postulanteRepository;
    private final PostulanteAdapter postulanteAdapter;

    public PostulanteService(PostulanteRepository postulanteRepository,
                             PostulanteAdapter postulanteAdapter) {
        this.postulanteRepository = postulanteRepository;
        this.postulanteAdapter = postulanteAdapter;
    }

    public Postulante crearPostulante(Postulante postulante) {
        PostulanteEntity entity = postulanteAdapter.toEntity(postulante); //F3 ref
        PostulanteEntity savedEntity = postulanteRepository.save(entity); //F3 ref
        return postulanteAdapter.toModel(savedEntity); //F3 ref
        //Postulante resp = new Postulante(); //F1 rojo
        //resp.setNombre(postulante.getNombre()); //F2 verde
        //resp.setEmail(postulante.getEmail()); //F2 verde
        //return resp; //
    }
}

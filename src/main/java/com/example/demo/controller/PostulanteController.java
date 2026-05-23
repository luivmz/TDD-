package com.example.demo.controller;

import com.example.demo.model.Postulante;
import com.example.demo.service.PostulanteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller para el recurso Postulante.
 * Endpoint: POST /api/postulantes
 */
@RestController
@RequestMapping("/api/postulantes")
public class PostulanteController {

    private final PostulanteService postulanteService;

    public PostulanteController(PostulanteService postulanteService) {
        this.postulanteService = postulanteService;
    }

    /**
     * Crea un nuevo postulante.
     *
     * Request:  { "nombre": "Juan Perez", "email": "juan@example.com" }
     * Response: { "id": 1, "nombre": "Juan Perez", "email": "juan@example.com" }
     */
    @PostMapping
    public Postulante crear(@RequestBody Postulante postulante) {
        return postulanteService.crearPostulante(postulante);
    }
}

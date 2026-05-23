package com.example.demo.controller;

import com.example.demo.model.OfertaLaboral;
import com.example.demo.service.OfertaLaboralService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller para el recurso OfertaLaboral.
 * Endpoint: POST /api/ofertas-laborales
 */
@RestController
@RequestMapping("/api/ofertas-laborales")
public class OfertaLaboralController {

    private final OfertaLaboralService ofertaLaboralService;

    public OfertaLaboralController(OfertaLaboralService ofertaLaboralService) {
        this.ofertaLaboralService = ofertaLaboralService;
    }

    /**
     * Crea una nueva oferta laboral.
     *
     * Request:  { "titulo": "Desarrollador Java Junior", "descripcion": "..." }
     * Response: { "id": 1, "titulo": "Desarrollador Java Junior", "descripcion": "..." }
     */
    @PostMapping
    public OfertaLaboral crear(@RequestBody OfertaLaboral oferta) {
        return ofertaLaboralService.crearOferta(oferta);
    }
}

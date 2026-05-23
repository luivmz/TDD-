package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TDD - Tests para el recurso OfertaLaboral.
 *
 * Ciclo completo Red-Green-Refactor por cada funcionalidad:
 *
 *   F1 ROJO   : Se escribe el test ANTES de que exista el endpoint.
 *               El test falla con 404 porque OfertaLaboralController no existe.
 *
 *   F2 VERDE  : Se implementa lo minimo para que el test pase.
 *               OfertaLaboralController + OfertaLaboralService devuelven los datos
 *               recibidos sin persistencia. El id queda null.
 *
 *   F3 REFACTOR: Se agrega la persistencia real en H2.
 *               OfertaLaboralEntity + OfertaLaboralRepository + OfertaLaboralAdapter.
 *               El id lo genera la base de datos con IDENTITY.
 */
@SpringBootTest
@AutoConfigureMockMvc
class OfertaLaboralControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // =====================================================================
    //  F1 ROJO  -  Escribimos los tests PRIMERO. Todos fallan con 404
    //              porque el controller POST /api/ofertas-laborales no existe.
    //
    //  F2 VERDE -  Creamos OfertaLaboralController + OfertaLaboralService con
    //              implementacion minima (sin persistencia). Los tests
    //              1, 2 y 3 pasan. El test 4 (id) pasa con id = null.
    //
    //  F3 REFACTOR - Agregamos Entity + Repository + Adapter.
    //              OfertaLaboralService ahora persiste en H2.
    //              Todos los tests pasan con id generado por la BD.
    // =====================================================================

    @Nested
    @DisplayName("F1 ROJO -> F2 VERDE -> F3 REFACTOR: Crear OfertaLaboral")
    class CrearOfertaLaboral {

        // ------------------------------------------------------------------
        // TEST 1
        // F1 ROJO  : falla con 404 (controller no existe)
        // F2 VERDE : pasa con 200 (controller creado, devuelve datos sin BD)
        // F3 REFACTOR: pasa con 200 (persiste en H2)
        // ------------------------------------------------------------------
        @Test
        @DisplayName("F1 ROJO: POST /api/ofertas-laborales deberia retornar 200")
        void deberiaCrearOfertaYRetornar200() throws Exception {

            String json = """
                    {
                        "titulo": "Desarrollador Java Junior",
                        "descripcion": "Trabajo para desarrollador Spring Boot"
                    }
                    """;

            mockMvc.perform(
                            post("/api/ofertas-laborales")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(json)
                    )
                    .andExpect(status().isOk());
        }

        // ------------------------------------------------------------------
        // TEST 2
        // F1 ROJO  : falla con 404, nunca llega a verificar el body
        // F2 VERDE : pasa (controller copia el titulo del request)
        // F3 REFACTOR: pasa (titulo viene del registro guardado en H2)
        // ------------------------------------------------------------------
        @Test
        @DisplayName("F1 ROJO: La respuesta debe contener el titulo de la oferta")
        void laRespuestaDebeContenerElTitulo() throws Exception {

            String json = """
                    {
                        "titulo": "Desarrollador Java Junior",
                        "descripcion": "Trabajo para desarrollador Spring Boot"
                    }
                    """;

            mockMvc.perform(
                            post("/api/ofertas-laborales")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(json)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.titulo").value("Desarrollador Java Junior"));
        }

        // ------------------------------------------------------------------
        // TEST 3
        // F1 ROJO  : falla con 404
        // F2 VERDE : pasa (controller copia la descripcion del request)
        // F3 REFACTOR: pasa (descripcion viene del registro guardado en H2)
        // ------------------------------------------------------------------
        @Test
        @DisplayName("F1 ROJO: La respuesta debe contener la descripcion de la oferta")
        void laRespuestaDebeContenerLaDescripcion() throws Exception {

            String json = """
                    {
                        "titulo": "Desarrollador Java Junior",
                        "descripcion": "Trabajo para desarrollador Spring Boot"
                    }
                    """;

            mockMvc.perform(
                            post("/api/ofertas-laborales")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(json)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.descripcion").value("Trabajo para desarrollador Spring Boot"));
        }

        // ------------------------------------------------------------------
        // TEST 4
        // F1 ROJO  : falla con 404
        // F2 VERDE : pasa pero id = null (sin persistencia)
        // F3 REFACTOR: pasa con id generado por H2 (IDENTITY)
        // ------------------------------------------------------------------
        @Test
        @DisplayName("F1 ROJO: La respuesta debe contener un id generado por H2")
        void laRespuestaDebeContenerUnId() throws Exception {

            String json = """
                    {
                        "titulo": "Analista QA Senior",
                        "descripcion": "Posicion para QA con experiencia en automatizacion"
                    }
                    """;

            mockMvc.perform(
                            post("/api/ofertas-laborales")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(json)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").exists());
        }
    }
}

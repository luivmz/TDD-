package com.example.demo.repository;

import com.example.demo.entity.OfertaLaboralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para OfertaLaboralEntity.
 * Spring Data JPA genera automáticamente save(), findAll(), findById(), etc.
 */
@Repository
public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboralEntity, Long> {
}

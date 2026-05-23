package com.example.demo.repository;

import com.example.demo.entity.PostulanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para PostulanteEntity.
 * Spring Data JPA genera automáticamente save(), findAll(), findById(), etc.
 */
@Repository
public interface PostulanteRepository extends JpaRepository<PostulanteEntity, Long> {
}

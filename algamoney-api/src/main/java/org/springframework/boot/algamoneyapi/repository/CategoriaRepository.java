package org.springframework.boot.algamoneyapi.repository;

import org.springframework.boot.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

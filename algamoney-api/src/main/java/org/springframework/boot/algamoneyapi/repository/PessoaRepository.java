package org.springframework.boot.algamoneyapi.repository;

import org.springframework.boot.algamoneyapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    void delete(Long codigo);
}

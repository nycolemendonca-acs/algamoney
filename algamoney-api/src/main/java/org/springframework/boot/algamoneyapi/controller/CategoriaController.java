package org.springframework.boot.algamoneyapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.algamoneyapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.algamoneyapi.model.Categoria;
import org.springframework.boot.algamoneyapi.repository.CategoriaRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController // Conversão da response para .json
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired private CategoriaRepository categoriaRepository;
    @Autowired private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Categoria> criar(
            @Validated @RequestBody Categoria categoria,
            HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Categoria categoria = categoriaRepository.findOne(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }
}

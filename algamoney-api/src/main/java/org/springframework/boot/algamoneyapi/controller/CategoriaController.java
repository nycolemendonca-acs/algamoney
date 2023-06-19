package org.springframework.boot.algamoneyapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.algamoneyapi.model.Categoria;
import org.springframework.boot.algamoneyapi.repository.CategoriaRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController // Conversão da response para .json
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/codigo")
                    .buildAndExpand(categoriaSalva.getCodigo())
                    .toUri();

        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Categoria categoria = categoriaRepository.findOne(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }
}

package com.algaworks.demo.resource;

import com.algaworks.demo.model.Categoria;
import com.algaworks.demo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Converte o resultado da requisição para .json
@RequestMapping("/categorias") // Mapeamento da requisição
public class CategoriaResource {
    private CategoriaRepository categoriaRepository;
    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll(); // select * from categoria
    }


}

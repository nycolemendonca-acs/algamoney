package org.springframework.boot.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.algamoneyapi.model.Pessoa;
import org.springframework.boot.algamoneyapi.repository.PessoaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        pessoa = buscarPessoaPeloCodigo(codigo);
        Pessoa pessoaSalva = pessoaRepository.findOne(codigo);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    private Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
        if (pessoaSalva == null) throw new EmptyResultDataAccessException(1);
        return pessoaSalva;
    }

    public Pessoa buscarPeloCodigo(Long codigo) {
    }
}

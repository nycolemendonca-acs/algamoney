package org.springframework.boot.algamoneyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.algamoneyapi.model.Lancamento;
import org.springframework.boot.algamoneyapi.model.Pessoa;
import org.springframework.boot.algamoneyapi.repository.LancamentoRepository;
import org.springframework.boot.algamoneyapi.repository.PessoaRepository;
import org.springframework.boot.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    @Autowired private PessoaRepository pessoaRepository ;
    @Autowired private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return null;
    }
}

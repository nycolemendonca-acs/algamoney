package org.springframework.boot.algamoneyapi.repository.lancamento;

import org.springframework.boot.algamoneyapi.model.Lancamento
import org.springframework.boot.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}

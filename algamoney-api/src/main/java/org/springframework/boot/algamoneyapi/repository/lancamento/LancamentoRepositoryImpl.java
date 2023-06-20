package org.springframework.boot.algamoneyapi.repository.lancamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.boot.algamoneyapi.model.Lancamento;
import org.springframework.boot.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {
    @PersistenceContext private EntityManager manager;
    @Override
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        // Restrições
        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
    }

    private Predicate[] criarRestricoes(
            LancamentoFilter lancamentoFilter,
            CriteriaBuilder builder,
            Root<Lancamento> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(
                            root.get("descricao")), "%" + lancamentoFilter
                                                                .getDescricao()
                                                                .toLowerCase() + "%"));
        }

        if (lancamentoFilter.getDataVencimentoDe() != null) {
            predicates.add(builder.greaterThanOrEqualTo(
                    root.get("dataVencimentoDe"), lancamentoFilter.getDataVencimentoDe()));
        }

        if (lancamentoFilter.getGetDataVencimentoAte() != null) {
            predicates.add(builder.lessThanOrEqualTo(
                    root.get("dataVencimentoAte"), lancamentoFilter.getGetDataVencimentoAte()));
        }

        return predicates.toArray(predicates.toArray(new Predicate[predicates.size()]));
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Lancamento> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }


    private Long total(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }
}

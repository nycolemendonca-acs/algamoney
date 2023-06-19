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
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {
    @PersistenceContext EntityManager manager;
    @Override
    public List<Lancamento> filtar(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        // Restrições
        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(
            LancamentoFilter lancamentoFilter,
            CriteriaBuilder builder,
            Root<Lancamento> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(lancamentoFilter.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(root.get("descricao")), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
            ));
        }
        if (lancamentoFilter.getDataVencimentoDe() != null) {
            // predicates.add(e);
        }
        if (lancamentoFilter.getGetDataVencimentoAte() != null) {
            // predicates.add(e);
        }
        return predicates.toArray(predicates.toArray(new Predicate[predicates.size()]));
    }
}

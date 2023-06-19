package org.springframework.boot.algamoneyapi.repository;

import org.springframework.boot.algamoneyapi.model.Lancamento;
import org.springframework.boot.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LancamentoRepository implements JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Lancamento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Lancamento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Lancamento getOne(Long aLong) {
        return null;
    }

    @Override
    public Lancamento getById(Long aLong) {
        return null;
    }

    @Override
    public Lancamento getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Lancamento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Lancamento> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Lancamento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Lancamento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Lancamento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Lancamento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Lancamento> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Lancamento> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Lancamento> findAll() {
        return null;
    }

    @Override
    public List<Lancamento> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Lancamento entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Lancamento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Lancamento> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Lancamento> findAll(Pageable pageable) {
        return null;
    }

    public Lancamento findOne(Long codigo) {
        return null;
    }
}

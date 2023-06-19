package org.springframework.boot.algamoneyapi.controller;
import org.springframework.boot.algamoneyapi.exceptionhandler.AlgamoneyExceptionHandler;
import org.springframework.boot.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.boot.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.context.ApplicationEventPublisher;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.algamoneyapi.event.RecursoCriadoEvent;
import org.springframework.boot.algamoneyapi.model.Lancamento;
import org.springframework.boot.algamoneyapi.repository.LancamentoRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired private LancamentoRepository lancamentoRepository;
    @Autowired ApplicationEventPublisher publisher;
    @Autowired MessageSource messageSource;
    @GetMapping
    public List<Lancamento> pesquisar(LancamentoFilter lancamentoFilter) {
        return lancamentoRepository.filtrar(lancamentoFilter);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
        Lancamento lancamento = lancamentoRepository.findOne(codigo);
        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Validated @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @ExceptionHandler({ PessoaInexistenteOuInativaException.class })
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(
            PessoaInexistenteOuInativaException ex) {
        String mensagemUsuario = messageSource.getMessage(
                "pessoa.inexistente-ou-inativa",
                null,
                LocaleContextHolder.getLocale());

        String mensagemDesenvolvedor = ex.toString();
        List<AlgamoneyExceptionHandler.Erro> erros = Arrays
                .asList(new AlgamoneyExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor));
        return ResponseEntity.badRequest().body(erros);
    }
}

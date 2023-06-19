package org.springframework.boot.algamoneyapi.event.listener;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.algamoneyapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Override
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {
    @Component
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    private void adicionarHeaderLocation(
            HttpServletResponse response,
            Long codigo) {
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/{codigo}")
                    .buildAndExpand(codigo)
                    .toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}

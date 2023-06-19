package org.springframework.boot.algamoneyapi.event.listener;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.algamoneyapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;

public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {
    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();
    }
}

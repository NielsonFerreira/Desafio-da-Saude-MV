package com.nielsonferreira.desafiodasaudemv.events.listerners;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nielsonferreira.desafiodasaudemv.events.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		HttpServletResponse response = event.getResponse();
		Long codigoCnes = event.getCodigoCnes();
		
		adicionarHeaderLocation(response, codigoCnes);
	}

	// Adiciona a localização do recurso criado ao header
	private void adicionarHeaderLocation(HttpServletResponse response, Long codigoCnes) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoCnes}").buildAndExpand(codigoCnes).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}

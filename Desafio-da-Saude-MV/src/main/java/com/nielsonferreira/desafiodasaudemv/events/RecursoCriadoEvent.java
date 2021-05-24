package com.nielsonferreira.desafiodasaudemv.events;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long codigoCnes;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigoCnes) {
		super(source);
		this.response = response;
		this.codigoCnes = codigoCnes;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigoCnes() {
		return codigoCnes;
	}

}

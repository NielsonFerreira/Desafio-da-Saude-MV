package com.nielsonferreira.desafiodasaudemv.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CnesExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 * Um ou mais campos não são reconhecidos na requisição.
	 * Ou seja, um campo que não existe foi enviado na requisição
	 */
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String exception = ex.getCause().toString();
		List<Erro> erros = Arrays.asList(new Erro(exception));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	/*
	 * Algum campo não foi passou na validação.
	 * Por exemplo, deixar vazio um campo anotado com "@NotEmpty"
	 */
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaDeErros(BindingResult bindingResult){
		List<Erro> erros = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String exception = fieldError.toString(); 
			erros.add(new Erro(exception));
		}
		
		return erros;

	}
	
	public static class Erro{
		
		private String exception;
		
		public Erro(String exception) {
			this.exception = exception;
		}

		public String getException() {
			return exception;
		}
	}
}

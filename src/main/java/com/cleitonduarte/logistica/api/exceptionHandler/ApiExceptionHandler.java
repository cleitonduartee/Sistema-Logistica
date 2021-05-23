package com.cleitonduarte.logistica.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cleitonduarte.logistica.domain.exception.EntidadeNaoEncontradaException;
import com.cleitonduarte.logistica.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<CamposError> campos = new ArrayList<>();
		for(ObjectError erro : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) erro).getField();
			String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			campos.add(new CamposError(nome, mensagem));
		}
		
		
		ErroPadrao error = new ErroPadrao();
		error.setCampos(campos);
		error.setDataHora(LocalDateTime.now());
		error.setStatus(status.value());
		error.setTitulo("Um ou mais campos estão invalidos.");
		return handleExceptionInternal(ex, error,headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handlerNegocio(NegocioException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao error = new ErroPadrao();		
		error.setDataHora(LocalDateTime.now());
		error.setStatus(status.value());
		error.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, error,new HttpHeaders(), status, request);
	}
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handlerEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao error = new ErroPadrao();		
		error.setDataHora(LocalDateTime.now());
		error.setStatus(status.value());
		error.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, error,new HttpHeaders(), status, request);
	}
	
	
	
}

package br.com.jlucasguedes.ntdw.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jlucasguedes.ntdw.domain.DetalheErro;
import br.com.jlucasguedes.ntdw.exceptions.JaExistenteException;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ResourceExpectionHandler {
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handlerNaoEncontradoException(NaoEncontradoException e,
			HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("https://localhost:8080/erros/404");
		erro.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(JaExistenteException.class)
	public ResponseEntity<DetalheErro> handlerJaExistenteException(JaExistenteException e, HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("https://localhost:8080/erros/404");
		erro.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalheErro> handleBadInput(MethodArgumentNotValidException e, HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(500l);
		erro.setTitulo("Erro de validação no campo " + e.getFieldError().getField());
		erro.setMensagemDesenvolvedor("https://localhost:8080/erros/500");
		erro.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}

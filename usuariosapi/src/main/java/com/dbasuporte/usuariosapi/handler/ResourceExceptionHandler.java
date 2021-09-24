package com.dbasuporte.usuariosapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dbasuporte.usuariosapi.domain.DetalhesErro;
import com.dbasuporte.usuariosapi.services.exceptions.ClienteExistenteException;
import com.dbasuporte.usuariosapi.services.exceptions.ClienteNaoEncontradoException;
import com.dbasuporte.usuariosapi.services.exceptions.ConsultaInvalidaException;
import com.dbasuporte.usuariosapi.services.exceptions.DocumentacaoExistenteException;
import com.dbasuporte.usuariosapi.services.exceptions.DocumentoInvalidoException;
import com.dbasuporte.usuariosapi.services.exceptions.DocumentoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(400l);
		erro.setMensagem("campos invalidos informados " + e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(ConsultaInvalidaException.class)
	public ResponseEntity<DetalhesErro> handleConsultaInvalidaException(ConsultaInvalidaException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(400l);
		erro.setMensagem("Informe pelo menos um parametro para realizar a consulta");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DetalhesErro> handleHttpMessageNotReadableException(HttpMessageNotReadableException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(400l);
		erro.setMensagem("Json invalido");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException(ClienteNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(404l);
		erro.setMensagem("O cliente nao pode ser encontrado");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DocumentoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleDocumentoNaoEncontradoException(DocumentoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(404l);
		erro.setMensagem("O Documento nao pode ser encontrado");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handleClienteExistenteException(ClienteExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(409l);
		erro.setMensagem("O cliente ja existe");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(DocumentacaoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleDocumentacaoExistenteException(DocumentacaoExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(409l);
		erro.setMensagem("O documento ja existe");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(DocumentoInvalidoException.class)
	public ResponseEntity<DetalhesErro> handleDocumentoInvalidoException(DocumentoInvalidoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(400l);
		erro.setMensagem("O documento deve ser no formato PDF e nao pode ser superior a 2MB");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();

		erro.setCodigoRetorno(400l);
		erro.setMensagem("Requisicao invalida");

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

}

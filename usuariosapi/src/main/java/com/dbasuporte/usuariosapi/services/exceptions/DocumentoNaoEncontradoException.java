package com.dbasuporte.usuariosapi.services.exceptions;

public class DocumentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DocumentoNaoEncontradoException() {

	}

	public DocumentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

package com.dbasuporte.usuariosapi.services.exceptions;

public class DocumentoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DocumentoInvalidoException() {

	}

	public DocumentoInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

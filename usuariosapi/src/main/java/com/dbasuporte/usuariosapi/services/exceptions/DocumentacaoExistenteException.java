package com.dbasuporte.usuariosapi.services.exceptions;

public class DocumentacaoExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DocumentacaoExistenteException() {

	}

	public DocumentacaoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

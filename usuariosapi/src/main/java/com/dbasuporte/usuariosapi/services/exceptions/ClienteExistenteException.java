package com.dbasuporte.usuariosapi.services.exceptions;

public class ClienteExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteExistenteException() {

	}

	public ClienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

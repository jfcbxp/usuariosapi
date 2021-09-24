package com.dbasuporte.usuariosapi.services.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException() {

	}

	public ClienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

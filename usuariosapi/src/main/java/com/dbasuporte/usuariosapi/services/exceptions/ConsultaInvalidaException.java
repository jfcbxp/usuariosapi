package com.dbasuporte.usuariosapi.services.exceptions;

public class ConsultaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConsultaInvalidaException() {

	}

	public ConsultaInvalidaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

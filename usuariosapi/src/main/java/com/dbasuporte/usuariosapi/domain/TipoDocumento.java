package com.dbasuporte.usuariosapi.domain;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDocumento {
	DEFAULT(0), CPF(1), CNPJ(2), OUTROS(3);

	private int codigo;

	TipoDocumento(int codigo) {
		this.codigo = codigo;
	}

	@JsonCreator
	public static TipoDocumento decode(final int code) {
		return Stream.of(TipoDocumento.values()).filter(targetEnum -> targetEnum.codigo == code).findFirst()
				.orElse(null);
	}

	@JsonValue
	public int getCodigo() {
		return codigo;
	}

}
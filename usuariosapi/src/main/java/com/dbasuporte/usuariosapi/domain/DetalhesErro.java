package com.dbasuporte.usuariosapi.domain;

public class DetalhesErro {

	private Long codigoRetorno;

	private String mensagem;

	public DetalhesErro() {

	}

	public Long getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(Long codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

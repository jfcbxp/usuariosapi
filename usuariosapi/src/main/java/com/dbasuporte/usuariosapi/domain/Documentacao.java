package com.dbasuporte.usuariosapi.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.dbasuporte.usuariosapi.converter.DocumentoConverter;
import com.dbasuporte.usuariosapi.validation.DocumentoValido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Documentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocumentacao;

	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Tipo do documento e de preenchimento obrigatorio")
	@Enumerated(EnumType.ORDINAL)
	private TipoDocumento tipoDocumento;

	@JsonInclude(Include.NON_NULL)
	@DocumentoValido
	@NotNull(message = "documento e de preenchimento obrigatorio")
	@Lob
	@Convert(converter = DocumentoConverter.class)
	private byte[] documento;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonIgnore
	private Cliente cliente;

	public Documentacao() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdDocumentacao() {
		return idDocumentacao;
	}

	public void setIdDocumentacao(Long idDocumentacao) {
		this.idDocumentacao = idDocumentacao;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

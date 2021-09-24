package com.dbasuporte.usuariosapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dbasuporte.usuariosapi.validation.CpfCnpjValido;
import com.dbasuporte.usuariosapi.validation.TelefoneValido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long idCliente;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Nome completo e de preenchimento obrigatorio")
	@Size(max = 50, message = "O nome completo nao pode conter mais de 50 caracteres")
	private String nomeCompleto;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Telefone e de preenchimento obrigatorio")
	@Size(max = 13, message = "O telefone nao pode conter mais de 13 caracteres")
	@TelefoneValido
	private String telefone;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Cpf ou cnpj é de preenchimento obrigatorio")
	@Size(max = 14, message = "O cpf ou cnpj nao pode conter mais de 14 caracteres")
	@CpfCnpjValido
	private String cpfCnpj;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Campo nome completo e de preenchimento obrigatorio")
	@Size(max = 500, message = "O email nao pode conter mais de 500 caracteres")
	@Email(message = "Email invalido")
	private String email;

	@OneToMany(mappedBy = "cliente")
	private List<Documentacao> documentacoes;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public List<Documentacao> getDocumentacoes() {
		return documentacoes;
	}

	public void setDocumentacoes(List<Documentacao> documentacoes) {
		this.documentacoes = documentacoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

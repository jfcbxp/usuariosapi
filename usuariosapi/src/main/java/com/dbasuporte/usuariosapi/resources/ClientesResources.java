package com.dbasuporte.usuariosapi.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dbasuporte.usuariosapi.domain.Cliente;
import com.dbasuporte.usuariosapi.services.ClientesServices;
import com.dbasuporte.usuariosapi.services.exceptions.ClienteNaoEncontradoException;
import com.dbasuporte.usuariosapi.services.exceptions.ConsultaInvalidaException;

@RestController
@RequestMapping("/usuario")
public class ClientesResources {

	@Autowired
	private ClientesServices clientesServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Cliente> listar(@RequestParam(required = false, defaultValue = "") String nomeCompleto,
			@RequestParam(required = false, defaultValue = "") String email,
			@RequestParam(required = false, defaultValue = "") String cpfCnpj) {

		if (nomeCompleto.isEmpty() && email.isEmpty() && cpfCnpj.isEmpty()) {
			throw new ConsultaInvalidaException();
		}
		Cliente cliente = null;

		if (!nomeCompleto.isEmpty()) {
			cliente = clientesServices.buscarPorNomeCompleto(nomeCompleto);
		}

		if (!email.isEmpty() && cliente == null) {
			cliente = clientesServices.buscarPorEmail(email);
		}

		if (!cpfCnpj.isEmpty() && cliente == null) {
			cliente = clientesServices.buscarPorCpfCnpj(cpfCnpj);
		}

		if (cliente == null) {
			throw new ClienteNaoEncontradoException();

		}

		return ResponseEntity.ok().body(cliente);

	}

	/*
	 * Tambem seria possivel utilizar o MultipartFile para receber o arquivo
	 * separando o arquivo da requisição pelo @RequestPart a desvantagem que
	 * dependeria do front-end enviar corretamente a ordem do arquivo e do tipo de
	 * documento
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {
		cliente = clientesServices.salvar(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{cpfCnpj}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("cpfCnpj") String cpfCnpj) {
		clientesServices.deletar(cpfCnpj);
		return ResponseEntity.ok().build();

	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cliente cliente) {

		clientesServices.atualizar(cliente);
		return ResponseEntity.ok().build();

	}

}

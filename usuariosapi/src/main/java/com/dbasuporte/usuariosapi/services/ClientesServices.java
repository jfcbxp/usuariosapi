package com.dbasuporte.usuariosapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dbasuporte.usuariosapi.domain.Cliente;
import com.dbasuporte.usuariosapi.domain.Documentacao;
import com.dbasuporte.usuariosapi.repository.ClientesRepository;
import com.dbasuporte.usuariosapi.repository.DocumentacoesRepository;
import com.dbasuporte.usuariosapi.services.exceptions.ClienteExistenteException;
import com.dbasuporte.usuariosapi.services.exceptions.ClienteNaoEncontradoException;

@Service
public class ClientesServices {

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private DocumentacoesRepository documentacoesRepository;

	public Cliente buscarPorNomeCompleto(String nomeCompleto) {
		return clientesRepository.findByNomeCompleto(nomeCompleto);

	}

	public Cliente buscarPorEmail(String email) {
		return clientesRepository.findByEmail(email);

	}

	public Cliente buscarPorCpfCnpj(String cpfCnpj) {
		return clientesRepository.findByCpfCnpj(cpfCnpj);

	}

	@Transactional(rollbackOn = Exception.class)
	public Cliente salvar(Cliente cliente) {

		if (isClienteCadastrado(cliente)) {
			throw new ClienteExistenteException();
		}
		cliente = clientesRepository.save(cliente);
		cliente = salvarDocumentacoes(cliente);
		return cliente;

	}

	@Transactional(rollbackOn = Exception.class)
	public void atualizar(Cliente cliente) {
		try {
			Cliente clienteId = buscarPorCpfCnpj(cliente.getCpfCnpj());
			if (clienteId != null) {
				cliente.setIdCliente(clienteId.getIdCliente());
				clientesRepository.save(cliente);
				cliente = salvarDocumentacoes(cliente);
			} else {
				throw new ClienteNaoEncontradoException();

			}

		} catch (EmptyResultDataAccessException | EntityNotFoundException | JpaObjectRetrievalFailureException e) {
			throw new ClienteNaoEncontradoException();
		}

	}

	@Transactional(rollbackOn = Exception.class)
	public void deletar(String cpfCnpj) {
		try {
			Cliente cliente = buscarPorCpfCnpj(cpfCnpj);
			if (cliente != null) {
				List<Documentacao> documentacoes = documentacoesRepository.findByCliente(cliente);
				for (Documentacao documentacao : documentacoes) {
					documentacoesRepository.delete(documentacao);
				}
				clientesRepository.delete(cliente);
			} else {
				throw new ClienteNaoEncontradoException();

			}

		} catch (EmptyResultDataAccessException | EntityNotFoundException | JpaObjectRetrievalFailureException e) {
			throw new ClienteNaoEncontradoException();
		}

	}

	
	private Cliente salvarDocumentacoes(Cliente cliente) {
		for (Documentacao documentacao : cliente.getDocumentacoes()) {
			documentacao.setCliente(cliente);
			documentacoesRepository.save(documentacao);
		}
		return cliente;
	}

	private boolean isClienteCadastrado(Cliente cliente) {
		Cliente consulta;
		if (cliente.getIdCliente() != null) {
			consulta = clientesRepository.findById(cliente.getIdCliente()).orElse(null);
		} else {
			consulta = clientesRepository.findByCpfCnpj(cliente.getCpfCnpj());
		}

		return consulta != null ? true : false;

	}

}

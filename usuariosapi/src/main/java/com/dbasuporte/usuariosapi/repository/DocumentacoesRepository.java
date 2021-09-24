package com.dbasuporte.usuariosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbasuporte.usuariosapi.domain.Cliente;
import com.dbasuporte.usuariosapi.domain.Documentacao;

public interface DocumentacoesRepository extends JpaRepository<Documentacao, Long> {

	List<Documentacao> findByCliente(Cliente cliente);

}

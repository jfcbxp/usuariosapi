package com.dbasuporte.usuariosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbasuporte.usuariosapi.domain.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

	Cliente findByCpfCnpj(String cpfCnpj);

	Cliente findByEmail(String email);

	Cliente findByNomeCompleto(String nomeCompleto);

}

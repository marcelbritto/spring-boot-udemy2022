package br.com.marcbritto.pontointeligente.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcbritto.pontointeligente.api.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	/**
	 * O Spring, através do JpaRepository identifica o atributo que vem após o 'findBy' e monta, sozinho
	 * a query.
	 * Busca por CPF
	 * @param cpf
	 * @return
	 */
	Funcionario findByCpf(String cpf);
	
	/**
	 * O Spring, através do JpaRepository identifica o atributo que vem após o 'findBy' e monta, sozinho
	 * a query.
	 * Busca por Email
	 * @param email
	 * @return
	 */
	Funcionario findByEmail(String email);
	
	/**
	 * O 'Or' também é uma convenção do Spring para montar a query com Ou.
	 * 
	 * Busca por CPF ou Email.
	 * @param cpf
	 * @param email
	 * @return
	 */
	Funcionario findByCpfOrEmail(String cpf, String email);
}
package br.com.marcbritto.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcbritto.pontointeligente.api.entities.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	/**
	 * O Spring, através do JpaRepository identifica o atributo que vem após o 'findBy' e monta, sozinho
	 * a query.
	 * 
	 * @param cnpj
	 * @return
	 */
	Empresa findByCnpj (String cnpj);
	
}

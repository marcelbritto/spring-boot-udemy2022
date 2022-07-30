package br.com.marcbritto.pontointeligente.api.repositories;


import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcbritto.pontointeligente.api.entities.Lancamento;

//TODO: montar essa query com nome de método
@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
				query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	/**
	 * Busca de funcionário por Id.
	 * 
	 * @param funcionarioId
	 * @return
	 */
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	/**
	 * Busca de funcionário por Id, com paginação.
	 * @param funcionarioId
	 * @param pageable
	 * @return
	 */
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
	
	/**
	 * Mesmo método, porém utilizando Method Query no lugar da NamedQuery
	 * @param funcionarioId
	 * @return
	 */
	List<Lancamento> findByFuncionario_Id(@Param("funcionarioId") Long funcionarioId);
}

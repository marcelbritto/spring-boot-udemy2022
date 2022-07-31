package br.com.marcbritto.pontointeligente.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import br.com.marcbritto.pontointeligente.api.entities.Lancamento;
import br.com.marcbritto.pontointeligente.api.repositories.LancamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository LancamentoRepository;
	
	@Autowired
	private LancamentoService LancamentoService;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		BDDMockito.given(this.LancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
		BDDMockito.given(this.LancamentoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Lancamento()));
		BDDMockito.given(this.LancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
						.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
	}
	
	@Test
	public void testPersistirLancamento() {
		Lancamento Lancamento = this.LancamentoService.persistir(new Lancamento());
		
		assertNotNull(Lancamento);
	}
	
	@Test
	public void testBuscarLancamentoPorID() {
		Optional<Lancamento> Lancamento = this.LancamentoService.buscarPorId(1L);
		
		assertTrue(Lancamento.isPresent());
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		Page<Lancamento> lancamento = this.LancamentoService.buscarPorFuncionarioId(1L, PageRequest.of(0, 10));
		
		assertNotNull(lancamento);
	}
	
	
}

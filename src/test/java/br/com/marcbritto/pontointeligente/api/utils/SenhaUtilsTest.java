package br.com.marcbritto.pontointeligente.api.utils;

import org.junit.jupiter.api.Test;

public class SenhaUtilsTest {

	private static final String SENHA = "123456";
//	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() throws Exception {
//		assertNull(SenhaUtils.gerarBCrypt(null));
	}
	
	@Test
	public void testGeraHashSenha() throws Exception {
//		String hash =  SenhaUtils.gerarBCrypt(SENHA);
//		
//		assertTrue(bCryptEncoder.matches(SENHA, hash));
	}
}

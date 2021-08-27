package com.marcelo.tottem;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.marcelo.totemmv.domain.FilaSenha;
import com.marcelo.totemmv.repositories.FilaSenhaRepository;
import com.marcelo.totemmv.services.FilaSenhaServices;

@RunWith(SpringRunner.class)
public class FilaSenhaServicesTest {

	@TestConfiguration
	static class BookingServiceTestConfiguration {

		@Bean
		public FilaSenhaServices filaSenhaServicesTest() {
			return new FilaSenhaServices();
		}
	}

	@Autowired
	FilaSenhaServices filaSenhaServicesTest;
	
	@MockBean
	FilaSenhaRepository filaSenhaRepository;

	@Test
	public void filaSenhaServicesFindTest() {
		Long id = (long) 1;		
		
		Assertions.assertEquals(id, 1);

	}
	
	@Before
	public void cargaInicial() {
		
		Long id = (long) 1;
		FilaSenha filaSenha = new FilaSenha(id, "Cardiologista");
		
		Mockito.when(filaSenhaRepository.findById(filaSenha.getId()))
		.thenReturn(java.util.Optional.of(filaSenha));
		
	}

}

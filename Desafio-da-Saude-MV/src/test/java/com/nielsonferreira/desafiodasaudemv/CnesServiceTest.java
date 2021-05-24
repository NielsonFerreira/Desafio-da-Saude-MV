package com.nielsonferreira.desafiodasaudemv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nielsonferreira.desafiodasaudemv.models.Cnes;
import com.nielsonferreira.desafiodasaudemv.services.CnesService;
/*
 * Foi criado apenas um teste para servir como exemplo que verifica se os dados do response estão de acordo com o esperado
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CnesServiceTest {

	@Autowired
	private CnesService cnesService;
	
	@Test
	@Transactional
	public void buscarPeloCodigoCnesTest() {
		ResponseEntity<Optional<Cnes>> cnes = cnesService.buscarPeloCodigoCnes(6590640L);
		
		assertEquals("261160", cnes.getBody().get().getIbge());
		assertEquals("CLINICA JC BASTO", cnes.getBody().get().getNomeFantasia());
		assertEquals("CLINICA/CENTRO DE ESPECIALIDADE", cnes.getBody().get().getTipoUnidade());
	}
}

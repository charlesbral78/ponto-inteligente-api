package com.example.pontoeletronico;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("prod")
public class PontoEletronicoApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCarregarContextoDeTeste(){
		assertEquals(100, qtdPorPagina);

	}

}

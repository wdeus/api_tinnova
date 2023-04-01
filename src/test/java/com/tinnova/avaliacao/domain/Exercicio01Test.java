package com.tinnova.avaliacao.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercicio01Test {

	private Exercicio01 exer01 = new Exercicio01();
	
	@Test
	void percentualVotosValidos() {
		Double percentualVotosValidos = exer01.percentualVotosValidos();
		assertEquals(80d, percentualVotosValidos);
	}
	
	@Test
	void percentualVotosBrancos() {
		Double percentualVotosBrancos = exer01.percentualVotosBrancos();
		assertEquals(15d, percentualVotosBrancos);
	}
	
	@Test
	void percentualVotosNulos() {
		Double percentualVotosNulos = exer01.percentualVotosNulos();
		assertEquals(5d, percentualVotosNulos);
	}
	

}

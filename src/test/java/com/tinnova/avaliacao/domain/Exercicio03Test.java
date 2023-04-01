package com.tinnova.avaliacao.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercicio03Test {

	@Test
	void calcularFatorialDe6() {
		Exercicio03 exer03 = new Exercicio03();
		assertEquals(720, exer03.calcularFatorial(6));
	}

}

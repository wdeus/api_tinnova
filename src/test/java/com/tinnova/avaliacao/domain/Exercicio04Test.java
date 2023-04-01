package com.tinnova.avaliacao.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercicio04Test {

	@Test
	void somarMultiplosDe3E5Ate10() {
		Exercicio04 exer04 = new Exercicio04();
		assertEquals(23, exer04.somaMultiplos3E5(10));
	}

}

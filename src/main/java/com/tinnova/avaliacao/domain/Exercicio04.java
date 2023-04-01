package com.tinnova.avaliacao.domain;

public class Exercicio04 {

	public int somaMultiplos3E5(int n) {
		int resultado = 0;
		for(int i =0; i<n; i++) {
			if(i % 3 == 0 || i % 5 == 0)
				resultado += i;
		}
		return resultado;
	}
}

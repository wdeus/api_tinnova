package com.tinnova.avaliacao.domain;

public class Exercicio03 {

	public int calcularFatorial(int n) {
		int fatorial = 1;
		for (int i = 1; i <= n; i++) {
			fatorial *= i;

			System.out.println("Fatorial: " + i + " = " + fatorial);
		}
		return fatorial;
	}
}

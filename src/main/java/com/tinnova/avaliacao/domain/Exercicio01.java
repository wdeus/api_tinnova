package com.tinnova.avaliacao.domain;

public class Exercicio01 {

	private Double totalEleitores = 1000d;
	private Double votosValidos = 800d;
	private Double votosBrancos = 150d;
	private Double votosNulos = 50d;

	public Double percentualVotosValidos() {
		return (this.votosValidos / this.totalEleitores) * 100;
	}
	
	public Double percentualVotosBrancos() {
		return (this.votosBrancos / this.totalEleitores) * 100;
	}
	
	public Double percentualVotosNulos() {
		return (this.votosNulos / this.totalEleitores) * 100;
	}
	
	public static void main(String[] args) {
		Exercicio01 exer01 = new Exercicio01();
		System.out.println(exer01.percentualVotosValidos());
	}
}

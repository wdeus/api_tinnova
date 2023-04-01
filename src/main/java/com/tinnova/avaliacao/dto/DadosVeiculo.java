package com.tinnova.avaliacao.dto;

public record DadosVeiculo(
		String veiculo,
		String marca,
		Integer ano,
		String descricao,
		boolean vendido
		) {

}

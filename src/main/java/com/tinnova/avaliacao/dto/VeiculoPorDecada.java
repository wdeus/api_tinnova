package com.tinnova.avaliacao.dto;

import lombok.Data;

@Data
public class VeiculoPorDecada {

	private String decada;
	private Long quantidadeVeiculos;
	
	public VeiculoPorDecada(String decada, Long quantidadeVeiculos) {
		this.decada = decada;
		this.quantidadeVeiculos = quantidadeVeiculos;
	}
}

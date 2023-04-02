package com.tinnova.avaliacao.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VeiculoPorFabricante {

	private String fabricante;
	private Long quantidadeVeiculos;
	
	public VeiculoPorFabricante(String fabricante, Long quantidadeVeiculos) {
		super();
		this.fabricante = fabricante;
		this.quantidadeVeiculos = quantidadeVeiculos;
	}
	
	
}

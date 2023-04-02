package com.tinnova.avaliacao.service;

import java.sql.Date;
import java.time.LocalDate;

import com.tinnova.avaliacao.dto.DadosAtualizacaoVeiculo;
import com.tinnova.avaliacao.dto.DadosVeiculo;
import com.tinnova.avaliacao.model.Veiculo;

public class VeiculoService {

	public Veiculo atualizarVeiculo(Veiculo veiculo, DadosVeiculo dadosVeiculo) {
		veiculo.setVeiculo(dadosVeiculo.veiculo());
		veiculo.setMarca(dadosVeiculo.marca());
		veiculo.setAno(dadosVeiculo.ano());
		veiculo.setDescricao(dadosVeiculo.descricao());
		veiculo.setVendido(dadosVeiculo.vendido());
		veiculo.setUpdated(Date.valueOf(LocalDate.now()));
		return veiculo;
	}
	
	public Veiculo atualizarVeiculoParcialmente(Veiculo veiculo, DadosAtualizacaoVeiculo dadosVeiculo) {
		veiculo.setMarca(dadosVeiculo.marca());
		veiculo.setAno(dadosVeiculo.ano());
		return veiculo;
	}
}

package com.tinnova.avaliacao.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.tinnova.avaliacao.dto.DadosAtualizacaoVeiculo;
import com.tinnova.avaliacao.dto.DadosVeiculo;
import com.tinnova.avaliacao.model.Veiculo;

public class VeiculoService {

	private List<String> marcas = Arrays.asList("MERCEDES", "FORD", "CITROEN", "BMW", "CHEVROLET", "VOLKSWAGEN");
	
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
	
	public Veiculo salvarVeiculo(Veiculo veiculo, DadosVeiculo dadosVeiculo) {
		veiculo.setVeiculo(dadosVeiculo.veiculo());
		veiculo.setMarca(verificaMarcaValida(dadosVeiculo.marca()));
		veiculo.setAno(dadosVeiculo.ano());
		veiculo.setDescricao(dadosVeiculo.descricao());
		veiculo.setVendido(dadosVeiculo.vendido());
		veiculo.setCreated(Date.valueOf(LocalDate.now()));
		veiculo.setUpdated(Date.valueOf(LocalDate.now()));
		return veiculo;
	}
	
	private String verificaMarcaValida(String marca) {
		if(!marcas.contains(marca.toUpperCase())) 
			throw new IllegalArgumentException("Marca inválida");	
		return marca;
	}
}

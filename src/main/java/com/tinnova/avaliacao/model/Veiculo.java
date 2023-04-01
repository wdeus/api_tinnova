package com.tinnova.avaliacao.model;

import java.sql.Date;
import java.time.LocalDate;

import com.tinnova.avaliacao.dto.DadosVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "VEICULO")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Veiculo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private boolean vendido;
	private Date created;
	private Date updated;
	
	public Veiculo(DadosVeiculo dadosVeiculo) {
		this.veiculo = dadosVeiculo.veiculo();
		this.marca = dadosVeiculo.marca();
		this.ano = dadosVeiculo.ano();
		this.descricao = dadosVeiculo.descricao();
		this.vendido = dadosVeiculo.vendido();
		this.created = Date.valueOf(LocalDate.now());
		this.updated = Date.valueOf(LocalDate.now());
	}
	
}

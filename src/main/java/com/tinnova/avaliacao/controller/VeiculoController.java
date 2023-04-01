package com.tinnova.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.avaliacao.dto.DadosAtualizacaoVeiculo;
import com.tinnova.avaliacao.dto.DadosVeiculo;
import com.tinnova.avaliacao.model.Veiculo;
import com.tinnova.avaliacao.repository.VeiculoRepository;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repository;
	
	@GetMapping
	public List<Veiculo> listarTodosVeiculos(@RequestParam(value="marca" , required = false) String marca, @RequestParam(value="ano", required = false) Integer ano ){
		if(marca == null || ano == null) return repository.findAll();
		return repository.findByMarcaAndAno(marca, ano);
	}
	
	@GetMapping("/{id}")
	public Optional<Veiculo> listarVeiculoPorId(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosVeiculo dadosVeiculo) {
		repository.save(new Veiculo(dadosVeiculo));
	}
	
	@PatchMapping("/{id}")
	@Transactional
	public void alterarVeiculoParcialmente(@PathVariable Long id, @RequestBody DadosAtualizacaoVeiculo dadosAtualizacaoVeiculo) {
		var veiculo = repository.getReferenceById(id);
		//pendente
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}	
}

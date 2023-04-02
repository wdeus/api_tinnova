package com.tinnova.avaliacao.controller;

import java.sql.Date;
import java.time.LocalDate;
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
import com.tinnova.avaliacao.dto.VeiculoPorDecada;
import com.tinnova.avaliacao.dto.VeiculoPorFabricante;
import com.tinnova.avaliacao.model.Veiculo;
import com.tinnova.avaliacao.repository.VeiculoCustomRepository;
import com.tinnova.avaliacao.repository.VeiculoRepository;
import com.tinnova.avaliacao.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private VeiculoCustomRepository repositoryCustom;
	
	private VeiculoService service = new VeiculoService();
	
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
		Veiculo veiculo = repository.getReferenceById(id);
		veiculo = service.atualizarVeiculoParcialmente(veiculo, dadosAtualizacaoVeiculo);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void alterarVeiculo(@PathVariable Long id, @RequestBody DadosVeiculo dadosVeiculo) {
		Veiculo veiculo = repository.getReferenceById(id);
		veiculo = service.atualizarVeiculo(veiculo, dadosVeiculo);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}	
	
	@GetMapping("/veiculosPorFabricante")
	public List<VeiculoPorFabricante> getVeiculosPorFabricante(){
		return repositoryCustom.findVeiculosPorFabricante();
	}
	
	@GetMapping("/veiculosNaoVendidos")
	public int getQuantidadeVeiculosNaoVendidos() {
		return repository.findAllByVendidoFalse().size();
	}
	
	@GetMapping("/veiculosPorDecada")
	public List<VeiculoPorDecada> getVeiculosPorDecada(){
		return repositoryCustom.findVeiculosPorDecada();
	}
	
	@GetMapping("/veiculosUltimaSemana")
	public List<String> getCarrosRegistradoUltimaSemana(){
		return repositoryCustom.findCarrosRegistradosUltimaSemana(Date.valueOf(LocalDate.now().plusDays(-7l)), Date.valueOf(LocalDate.now().plusDays(-1l)));
	}
	
}

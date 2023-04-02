package com.tinnova.avaliacao.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Veiculo>> listarTodosVeiculos(@RequestParam(value="marca" , required = false) String marca, @RequestParam(value="ano", required = false) Integer ano ){
		List<Veiculo> retorno = new ArrayList<Veiculo>();
		if (marca != null && ano != null)
			retorno = repository.findByMarcaAndAno(marca, ano);
		retorno = repository.findAll();
		
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Veiculo>> listarVeiculoPorId(@PathVariable Long id){
		var retorno = repository.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody DadosVeiculo dadosVeiculo) {
		try {
			Veiculo veiculo = new Veiculo();
			veiculo = service.salvarVeiculo(veiculo, dadosVeiculo);
			repository.save(veiculo);
			return ResponseEntity.ok(veiculo.getId());
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PatchMapping("/{id}")
	@Transactional
	public ResponseEntity alterarVeiculoParcialmente(@PathVariable Long id, @RequestBody DadosAtualizacaoVeiculo dadosAtualizacaoVeiculo) {
		Veiculo veiculo = repository.getReferenceById(id);
		veiculo = service.atualizarVeiculoParcialmente(veiculo, dadosAtualizacaoVeiculo);
		return ResponseEntity.ok(veiculo.getId());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity alterarVeiculo(@PathVariable Long id, @RequestBody DadosVeiculo dadosVeiculo) {
		Veiculo veiculo = repository.getReferenceById(id);
		veiculo = service.atualizarVeiculo(veiculo, dadosVeiculo);
		return ResponseEntity.ok(veiculo.getId());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}	
	
	@GetMapping("/veiculosPorFabricante")
	public ResponseEntity<List<VeiculoPorFabricante>> getVeiculosPorFabricante(){
		var retorno = repositoryCustom.findVeiculosPorFabricante();
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/veiculosNaoVendidos")
	public ResponseEntity<Integer> getQuantidadeVeiculosNaoVendidos() {
		var retorno = repository.findAllByVendidoFalse().size();
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/veiculosPorDecada")
	public ResponseEntity<List<VeiculoPorDecada>> getVeiculosPorDecada(){
		var retorno = repositoryCustom.findVeiculosPorDecada();
		return ResponseEntity.ok(retorno);
	}
	
	@GetMapping("/veiculosUltimaSemana")
	public ResponseEntity<List<String>> getCarrosRegistradoUltimaSemana(){
		var retorno = repositoryCustom.findCarrosRegistradosUltimaSemana(Date.valueOf(LocalDate.now().plusDays(-7l)), Date.valueOf(LocalDate.now().plusDays(-1l)));
		return ResponseEntity.ok(retorno);
	}
	
}

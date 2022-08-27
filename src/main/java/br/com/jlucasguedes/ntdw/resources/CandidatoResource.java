package br.com.jlucasguedes.ntdw.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jlucasguedes.ntdw.domain.Candidato;
import br.com.jlucasguedes.ntdw.domain.Cidade;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.services.CandidatoService;
import br.com.jlucasguedes.ntdw.services.CidadeService;
import br.com.jlucasguedes.ntdw.services.UnidadeFederativaService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResource {

	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private UnidadeFederativaService unidadeFederativaService;

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(candidatoService.findAll());
	}

	@GetMapping("/{ufId}")
	public ResponseEntity<?> buscarPorUF(@PathVariable Long ufId) {
		UnidadeFederativa uf = unidadeFederativaService.findById(ufId);
		return ResponseEntity.ok(candidatoService.findByUF(uf));
	}

	@GetMapping("/cidades")
	public ResponseEntity<?> buscarPorCIdade(@RequestParam(name = "cidadeId") Long cidadeId) {
		Cidade cidade = cidadeService.findById(cidadeId);
		return ResponseEntity.ok(candidatoService.findByCidade(cidade));
	}

	@GetMapping("/cargos")
	public ResponseEntity<?> buscarPorCIdade(@RequestParam(name = "cargo") String cargo) {
		return ResponseEntity.ok(candidatoService.findByCargo(cargo));
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Candidato candidato) {
		candidato = candidatoService.salvar(candidato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidato.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
		candidato.setId(id);
		candidatoService.atualizar(candidato);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		candidatoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

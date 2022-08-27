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

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.Vaga;
import br.com.jlucasguedes.ntdw.services.EmpresaService;
import br.com.jlucasguedes.ntdw.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {

	@Autowired
	private VagaService vagaService;

	@Autowired
	private EmpresaService empresaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(vagaService.findAll());
	}

	@GetMapping("/{empresaId}")
	public ResponseEntity<?> buscarPorEmpresa(@PathVariable Long empresaId) {
		Empresa empresa = empresaService.findById(empresaId);
		return ResponseEntity.ok(vagaService.findByEmpresa(empresa));
	}
	
	@GetMapping("/cargos")
	public ResponseEntity<?> buscarPorCargo(@RequestParam(name = "cargo") String cargo) {
		return ResponseEntity.ok(vagaService.findByCargo(cargo));
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Vaga vaga) {
		vaga = vagaService.salvar(vaga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Vaga vaga, @PathVariable Long id) {
		vaga.setId(id);
		vagaService.atualizar(vaga);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		vagaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jlucasguedes.ntdw.domain.ExperienciaProfissional;
import br.com.jlucasguedes.ntdw.services.ExperienciaProfissionalService;

@RestController
@RequestMapping(value = "/experiencias_profissionais")
public class ExperienciaProfissionalResource {

	@Autowired
	private ExperienciaProfissionalService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody ExperienciaProfissional experienciaProfissional) {
		experienciaProfissional = service.salvar(experienciaProfissional);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(experienciaProfissional.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody ExperienciaProfissional experienciaProfissional,
			@PathVariable Long id) {
		experienciaProfissional.setId(id);
		service.atualizar(experienciaProfissional);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

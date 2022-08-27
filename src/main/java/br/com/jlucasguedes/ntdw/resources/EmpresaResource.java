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

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.services.EmpresaService;
import br.com.jlucasguedes.ntdw.services.UnidadeFederativaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private UnidadeFederativaService unidadeFederativaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(empresaService.findAll());
	}

	@GetMapping("/{ufId}")
	public ResponseEntity<?> buscarPorUF(@PathVariable Long ufId) {
		UnidadeFederativa uf = unidadeFederativaService.findById(ufId);
		return ResponseEntity.ok(empresaService.findByUnidadeFederativa(uf));
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Empresa empresa) {
		empresa = empresaService.salvar(empresa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Empresa empresa, @PathVariable Long id) {
		empresa.setId(id);
		empresaService.atualizar(empresa);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		empresaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

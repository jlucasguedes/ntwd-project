package br.com.jlucasguedes.ntdw.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.services.CidadeService;
import br.com.jlucasguedes.ntdw.services.UnidadeFederativaService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResources {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private UnidadeFederativaService unidadeFederativaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(cidadeService.findAll());

	}

	@GetMapping(value = "/{ufId}")
	public ResponseEntity<?> listarPorUf(@PathVariable Long ufId) {
		UnidadeFederativa ufEncontrada = unidadeFederativaService.findById(ufId);
		return ResponseEntity.ok(cidadeService.findByUf(ufEncontrada));
	}
}

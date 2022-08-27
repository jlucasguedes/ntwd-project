package br.com.jlucasguedes.ntdw.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jlucasguedes.ntdw.services.UnidadeFederativaService;

@RestController
@RequestMapping(value = "/ufs")
public class UnidadeFederativaResources {

	@Autowired
	private UnidadeFederativaService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}
}

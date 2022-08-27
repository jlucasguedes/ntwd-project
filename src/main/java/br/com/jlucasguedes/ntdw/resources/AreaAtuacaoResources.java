package br.com.jlucasguedes.ntdw.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jlucasguedes.ntdw.services.AreaAtuacaoService;

@RestController
@RequestMapping(value = "/areas_atuacao")
public class AreaAtuacaoResources {

	@Autowired
	private AreaAtuacaoService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

}

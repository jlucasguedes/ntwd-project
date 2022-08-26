package br.com.jlucasguedes.ntwd.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloResource {
	@GetMapping
	public ResponseEntity<String> listar() {
		return ResponseEntity.ok("Olá API REST");
	}
}

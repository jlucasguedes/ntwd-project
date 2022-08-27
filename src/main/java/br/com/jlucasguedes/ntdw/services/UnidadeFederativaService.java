package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.UnidadeFederativaRepository;

@Service
public class UnidadeFederativaService {

	@Autowired
	private UnidadeFederativaRepository repository;

	public List<UnidadeFederativa> findAll() {
		return repository.findAll();
	}

	public UnidadeFederativa findById(Long id) {
		Optional<UnidadeFederativa> optional = repository.findById(id);
		return optional.orElseThrow(() -> new NaoEncontradoException("Nenhuma unidade federativa encontrada."));
	}
}

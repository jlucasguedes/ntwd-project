package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.Cidade;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public List<Cidade> findByUf(UnidadeFederativa uf) {
		List<Cidade> cidades = repository.findByUf(uf);
		if (cidades.isEmpty())
			new NaoEncontradoException("Nenhuma cidade encontrada para a UF informada.");
		return cidades;
	}

	public Cidade findById(Long id) {
		Optional<Cidade> cidade = repository.findById(id);
		return cidade.orElseThrow(() -> new NaoEncontradoException("Nenhuma cidade encontrada."));
	}
}

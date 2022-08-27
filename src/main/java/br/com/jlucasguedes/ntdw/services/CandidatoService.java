package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.Candidato;
import br.com.jlucasguedes.ntdw.domain.Cidade;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.exceptions.JaExistenteException;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository repository;

	public Candidato findById(Long id) {
		Optional<Candidato> candidato = repository.findById(id);
		return candidato.orElseThrow(() -> new NaoEncontradoException("Nenhum candidato encontrado."));
	}

	public Candidato findByCpf(String cpf) {
		Optional<Candidato> candidato = repository.findByCpf(cpf);
		return candidato.orElseThrow(() -> new NaoEncontradoException("Nenhum candidato encontrado."));
	}

	public List<Candidato> findByUF(UnidadeFederativa uf) {
		return repository.findByUnidadeFederativa(uf);
	}

	public List<Candidato> findByCidade(Cidade cidade) {
		return repository.findByCidade(cidade);
	}

	public List<Candidato> findByCargo(String cargo) {
		return repository.findByCargo(cargo.toUpperCase());
	}

	public List<Candidato> findAll() {
		return repository.findAll();
	}

	public Candidato salvar(Candidato candidato) {
		candidato.setId(null);
		verificarExistenciaPorCPF(candidato.getCpf());
		return repository.save(candidato);
	}

	public void atualizar(Candidato candidato) {
		verificarExistencia(candidato);
		repository.save(candidato);
	}

	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NaoEncontradoException("O candidato não foi encontrado.");
		}
	}

	private void verificarExistencia(Candidato candidato) {
		findById(candidato.getId());
	}

	private void verificarExistenciaPorCPF(String cpf) {
		Optional<Candidato> candidato = repository.findByCpf(cpf);
		if (candidato.isPresent()) {
			throw new JaExistenteException("Sistema já possui um candidato cadastrado com o CPF " + cpf);
		}
	}
}

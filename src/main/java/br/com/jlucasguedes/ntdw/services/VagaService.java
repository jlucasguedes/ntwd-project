package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.Vaga;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repository;

	public Vaga findById(Long id) {
		Optional<Vaga> vaga = repository.findById(id);
		return vaga.orElseThrow(() -> new NaoEncontradoException("Nenhuma vaga encontrada."));
	}

	public List<Vaga> findAll() {
		return repository.findAll();
	}

	public List<Vaga> findByEmpresa(Empresa empresa) {
		return repository.findByEmpresa(empresa);
	}

	public List<Vaga> findByCargo(String cargo) {
		return repository.findByCargoContainingIgnoreCase(cargo);
	}

	public Vaga salvar(Vaga vaga) {
		vaga.setId(null);
		return repository.save(vaga);
	}

	public void atualizar(Vaga vaga) {
		verificarExistencia(vaga);
		repository.save(vaga);
	}

	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NaoEncontradoException("A vaga não foi encontrada.");
		}
	}

	private void verificarExistencia(Vaga vaga) {
		findById(vaga.getId());
	}
}

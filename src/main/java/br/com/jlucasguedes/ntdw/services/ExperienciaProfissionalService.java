package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.Candidato;
import br.com.jlucasguedes.ntdw.domain.ExperienciaProfissional;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.ExperienciaProfissionalRepository;

@Service
public class ExperienciaProfissionalService {

	@Autowired
	private ExperienciaProfissionalRepository repository;

	public ExperienciaProfissional buscarPorId(Long id) {
		Optional<ExperienciaProfissional> experienciaProfissional = repository.findById(id);
		return experienciaProfissional
				.orElseThrow(() -> new NaoEncontradoException("Nenhuma experiência profissional encontrada."));
	}

	public List<ExperienciaProfissional> findByCandidato(Candidato candidato) {
		return repository.findByCandidato(candidato);
	}

	public List<ExperienciaProfissional> findAll() {
		return repository.findAll();
	}

	public ExperienciaProfissional salvar(ExperienciaProfissional experienciaProfissional) {
		experienciaProfissional.setId(null);
		return repository.save(experienciaProfissional);
	}

	public void atualizar(ExperienciaProfissional experienciaProfissional) {
		verificarExistencia(experienciaProfissional);
		repository.save(experienciaProfissional);
	}

	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NaoEncontradoException("A experiência profissional não foi encontrada.");
		}
	}

	private void verificarExistencia(ExperienciaProfissional experienciaProfissional) {
		buscarPorId(experienciaProfissional.getId());
	}

}

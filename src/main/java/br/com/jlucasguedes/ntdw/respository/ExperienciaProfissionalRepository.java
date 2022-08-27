package br.com.jlucasguedes.ntdw.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jlucasguedes.ntdw.domain.Candidato;
import br.com.jlucasguedes.ntdw.domain.ExperienciaProfissional;

public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {

	public List<ExperienciaProfissional> findByCandidato(Candidato candidato);
}

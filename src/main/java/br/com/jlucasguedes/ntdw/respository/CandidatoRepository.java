package br.com.jlucasguedes.ntdw.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jlucasguedes.ntdw.domain.Candidato;
import br.com.jlucasguedes.ntdw.domain.Cidade;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	public Optional<Candidato> findByCpf(String cpf);

	@Query("SELECT ca FROM Candidato ca INNER JOIN ca.endereco e INNER JOIN e.cidade ci WHERE ci.uf = :uf")
	List<Candidato> findByUnidadeFederativa(@Param("uf") UnidadeFederativa uf);

	@Query("SELECT ca FROM Candidato ca INNER JOIN ca.endereco e WHERE e.cidade = :cidade")
	List<Candidato> findByCidade(@Param("cidade") Cidade cidade);

	@Query("SELECT ca FROM Candidato ca INNER JOIN ca.vaga va WHERE UPPER(va.cargo) like %:cargo%")
	List<Candidato> findByCargo(@Param("cargo") String cargo);
}

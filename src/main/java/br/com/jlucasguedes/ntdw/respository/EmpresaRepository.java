package br.com.jlucasguedes.ntdw.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	public Optional<Empresa> findByCnpj(@Param("cnpj") String cnpj);

	public List<Empresa> findByRazaoSocial(String razaoSocial);

	@Query("SELECT emp FROM Empresa emp INNER JOIN emp.endereco e INNER JOIN e.cidade ci WHERE ci.uf = :uf")
	List<Empresa> findByUnidadeFederativa(@Param("uf") UnidadeFederativa uf);
}

package br.com.jlucasguedes.ntdw.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.jlucasguedes.ntdw.domain.Cidade;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public List<Cidade> findByUf(@Param("uf") UnidadeFederativa uf);

}

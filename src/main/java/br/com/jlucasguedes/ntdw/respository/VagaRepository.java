package br.com.jlucasguedes.ntdw.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.domain.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

	public List<Vaga> findByEmpresa(Empresa empresa);

	public List<Vaga> findByCargoContainingIgnoreCase(String cargo);

	public List<Vaga> findByUf(UnidadeFederativa uf);

}

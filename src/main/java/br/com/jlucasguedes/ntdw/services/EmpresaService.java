package br.com.jlucasguedes.ntdw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.Empresa;
import br.com.jlucasguedes.ntdw.domain.UnidadeFederativa;
import br.com.jlucasguedes.ntdw.exceptions.JaExistenteException;
import br.com.jlucasguedes.ntdw.exceptions.NaoEncontradoException;
import br.com.jlucasguedes.ntdw.respository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public Empresa findById(Long id) {
		Optional<Empresa> empresa = repository.findById(id);
		return empresa.orElseThrow(() -> new NaoEncontradoException("Nenhuma empresa encontrada."));
	}

	public void findByCnpj(String cnpj) {
		Optional<Empresa> empresa = repository.findByCnpj(cnpj);
		if (empresa.isPresent()) {
			throw new JaExistenteException("Sistema já possui uma empresa com o CNPJ: " + empresa.get().getCnpj());
		}
	}

	public List<Empresa> findByUnidadeFederativa(UnidadeFederativa uf) {
		List<Empresa> empresa = repository.findByUnidadeFederativa(uf);
		if (empresa.isEmpty()) {
			throw new NaoEncontradoException("Nenhuma empresa encontrada para uf informada");
		} else {
			return empresa;
		}
	}

	public List<Empresa> findAll() {
		return repository.findAll();
	}

	public Empresa salvar(Empresa empresa) {
		empresa.setId(null);
		verificarExistenciaPorCnpj(empresa);
		return repository.save(empresa);
	}

	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NaoEncontradoException("A empresa não foi encontrada.");
		}
	}

	public void atualizar(Empresa empresa) {
		verificarExistencia(empresa);
		repository.save(empresa);
	}

	private void verificarExistenciaPorCnpj(Empresa empresa) {
		findByCnpj(empresa.getCnpj());
	}

	private void verificarExistencia(Empresa empresa) {
		findById(empresa.getId());
	}
}

package br.com.jlucasguedes.ntdw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.AreaAtuacao;
import br.com.jlucasguedes.ntdw.respository.AreaAtuacaoRepository;

@Service
public class AreaAtuacaoService {

	@Autowired
	private AreaAtuacaoRepository repository;

	public List<AreaAtuacao> findAll() {
		return repository.findAll();
	}
}

package br.com.jlucasguedes.ntdw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jlucasguedes.ntdw.domain.FormaContratacao;
import br.com.jlucasguedes.ntdw.respository.FormaContratacaoRepository;

@Service
public class FormaContratacaoService {

	@Autowired
	private FormaContratacaoRepository repository;

	public List<FormaContratacao> findAll() {
		return repository.findAll();
	}
}

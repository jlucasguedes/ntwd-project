package br.com.jlucasguedes.ntdw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "uf_seq_gen", sequenceName = "uf_id_seq", allocationSize = 1)
public class UnidadeFederativa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf_seq_gen")
	private Long id;
	private int codigo;
	private String nome;
	private String sigla;

}

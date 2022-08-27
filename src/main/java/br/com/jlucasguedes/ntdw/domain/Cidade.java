package br.com.jlucasguedes.ntdw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "cidade_seq_gen", sequenceName = "cidade_id_seq", allocationSize = 1)
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq_gen")
	private Long id;
	private String codigo;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "uf_id", referencedColumnName = "id")
	private UnidadeFederativa uf;
}

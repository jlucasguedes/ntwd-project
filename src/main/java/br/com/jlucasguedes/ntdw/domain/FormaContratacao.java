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
@SequenceGenerator(name = "forma_contratacao_seq_gen", sequenceName = "forma_contratacao_id_seq", allocationSize = 1)
public class FormaContratacao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forma_contratacao_seq_gen")
	private Long id;
	private String descricao;
}

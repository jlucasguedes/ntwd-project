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
@SequenceGenerator(name = "area_atuacao_seq_gen", sequenceName = "area_atuacao_id_seq", allocationSize = 1)
public class AreaAtuacao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_atuacao_seq_gen")
	private Long id;
	private String descricao;
}

package br.com.jlucasguedes.ntdw.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@SequenceGenerator(name = "endereco_seq_gen", sequenceName = "endereco_id_seq", allocationSize = 1)
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq_gen")
	private Long id;
	private String logradouro;
	private String cep;
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	@ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;
}

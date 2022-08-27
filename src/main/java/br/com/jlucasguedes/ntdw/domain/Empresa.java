package br.com.jlucasguedes.ntdw.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "empresa_seq_gen", sequenceName = "empresa_id_seq", allocationSize = 1)
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_seq_gen")
	private Long id;
	private String razaoSocial;
	@CNPJ
	private String cnpj;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	@ManyToOne
	@JoinColumn(name = "area_atuacao_id", referencedColumnName = "id")
	private AreaAtuacao areaAtuacao;
	private String email;
	private boolean receberNoticias;

}

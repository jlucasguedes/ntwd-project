package br.com.jlucasguedes.ntdw.domain;

import java.math.BigDecimal;

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
@SequenceGenerator(name = "vaga_seq_gen", sequenceName = "vaga_id_seq", allocationSize = 1)
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaga_seq_gen")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	private Empresa empresa;
	private String cargo;
	private String especificacao;
	private BigDecimal remuneracao;
	private boolean valeTransporte;
	private boolean valeRefeicao;
	private String outro;
	@Enumerated(EnumType.STRING)
	private Turno turno;
	@ManyToOne
	@JoinColumn(name = "forma_contratacao_id", referencedColumnName = "id")
	private FormaContratacao formaContratacao;
	@ManyToOne
	@JoinColumn(name = "uf_id", referencedColumnName = "id")
	private UnidadeFederativa uf;
}

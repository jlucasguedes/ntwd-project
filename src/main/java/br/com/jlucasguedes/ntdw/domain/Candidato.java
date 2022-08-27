package br.com.jlucasguedes.ntdw.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "candidato_seq_gen", sequenceName = "candidato_id_seq", allocationSize = 1)
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato_seq_gen")
	private Long id;
	private String nome;
	private String rg;
	private String orgaoExpedidor;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataExpedicao;
	@CPF
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	@Email
	private String email;
	private String telefoneResidencial;
	private String telefoneCelular;
	private boolean receberNoticias = false;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	@ManyToOne
	@JoinColumn(name = "vaga_id", referencedColumnName = "id")
	private Vaga vaga;
	@OneToMany(mappedBy = "candidato")
	private List<ExperienciaProfissional> experienciasProfissionais;
}

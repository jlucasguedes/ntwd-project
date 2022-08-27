package br.com.jlucasguedes.ntdw.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "experiencia_profissional_seq_gen", sequenceName = "experiencia_profissional_id_seq", allocationSize = 1)
public class ExperienciaProfissional {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiencia_profissional_seq_gen")
	private Long id;
	private String empresa;
	private String cargo;
	private String tarefasExecutadas;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataConclusao;
	@ManyToOne
	@JoinColumn(name = "candidato_id", referencedColumnName = "id")
	@JsonIgnore
	private Candidato candidato;
}

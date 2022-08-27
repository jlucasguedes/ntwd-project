package br.com.jlucasguedes.ntdw.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalheErro {

	private String titulo;
	private Long status;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime timestamp;
	private String mensagemDesenvolvedor;

}

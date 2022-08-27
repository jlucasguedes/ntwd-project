package br.com.jlucasguedes.ntdw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Turno {
	@JsonProperty("Diurno")
	DIURNO, 
	@JsonProperty("Noturno")
	NOTURNO;
}

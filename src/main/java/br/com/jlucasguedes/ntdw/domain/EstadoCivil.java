package br.com.jlucasguedes.ntdw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EstadoCivil {
	@JsonProperty("Solteiro")
	SOLTEIRO, 
	@JsonProperty("Viúvo")
	VIUVO, 
	@JsonProperty("Divorciado")
	DIVORCIADO, 
	@JsonProperty("Casado")
	CASADO;
}

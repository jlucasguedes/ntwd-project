package br.com.jlucasguedes.ntdw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoEndereco {
	@JsonProperty("Rural")
	RURAL, 
	@JsonProperty("Urbano")
	URBANO;
}

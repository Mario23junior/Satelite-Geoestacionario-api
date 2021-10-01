package com.projeto.satellite.GeostationarySatellite.ModelDTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AeroespacialDTO {
   
	private Double peso;
	private String vidaUtil;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date lancamento;
	private String operador;

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(String vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

}

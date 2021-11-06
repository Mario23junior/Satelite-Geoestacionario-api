package com.projeto.satellite.GeostationarySatellite.ModelDTO;

import javax.persistence.ManyToOne;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;

public class ComunicacaoDTO {

	private String tipoBanda;
	private Boolean ativo;
	private Double periodoOrbital;
	private Double anomaliaMedia;
	
	@ManyToOne
	private Satelite satelite;
	
	public String getTipoBanda() {
		return tipoBanda;
	}
	public void setTipoBanda(String tipoBanda) {
		this.tipoBanda = tipoBanda;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Double getPeriodoOrbital() {
		return periodoOrbital;
	}
	public void setPeriodoOrbital(Double periodoOrbital) {
		this.periodoOrbital = periodoOrbital;
	}
	public Double getAnomaliaMedia() {
		return anomaliaMedia;
	}
	public void setAnomaliaMedia(Double anomaliaMedia) {
		this.anomaliaMedia = anomaliaMedia;
	}
	public Satelite getSatelite() {
		return satelite;
	}
	public void setSatelite(Satelite satelite) {
		this.satelite = satelite;
	}

	
	

}

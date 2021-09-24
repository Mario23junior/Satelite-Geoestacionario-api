package com.projeto.satellite.GeostationarySatellite.ModelDTO;

public class ComunicacaoDTO {

	private String tipoBanda;
	private Boolean ativo;
	private Double periodoOrbital;
	private Double AnomaliaMedia;

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
		return AnomaliaMedia;
	}

	public void setAnomaliaMedia(Double anomaliaMedia) {
		AnomaliaMedia = anomaliaMedia;
	}

}

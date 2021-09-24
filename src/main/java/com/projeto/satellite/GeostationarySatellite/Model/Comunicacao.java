package com.projeto.satellite.GeostationarySatellite.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comunicacao {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipoBanda;
	private Boolean ativo;
	private Double periodoOrbital;
	private Double AnomaliaMedia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

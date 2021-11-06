package com.projeto.satellite.GeostationarySatellite.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comunicacao {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipoBanda;
	private Boolean ativo;
	private Double periodoOrbital;
	private Double anomaliaMedia;
	
	@ManyToOne
	private Satelite satelite;
	
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

package com.projeto.satellite.GeostationarySatellite.ModelDTO;

import javax.persistence.ManyToOne;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;

public class GeolocalizacaoDTO {
   
	private String orbita;
	private String posicaoEmOrbita;
	private String localizacaoOrbital;
	private String cobertura;
	
	@ManyToOne
	private Satelite satelite;
	
	public String getOrbita() {
		return orbita;
	}
	public void setOrbita(String orbita) {
		this.orbita = orbita;
	}
	public String getPosicaoEmOrbita() {
		return posicaoEmOrbita;
	}
	public void setPosicaoEmOrbita(String posicaoEmOrbita) {
		this.posicaoEmOrbita = posicaoEmOrbita;
	}
	public String getLocalizacaoOrbital() {
		return localizacaoOrbital;
	}
	public void setLocalizacaoOrbital(String localizacaoOrbital) {
		this.localizacaoOrbital = localizacaoOrbital;
	}
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	public Satelite getSatelite() {
		return satelite;
	}
	public void setSatelite(Satelite satelite) {
		this.satelite = satelite;
	}
	
	
}

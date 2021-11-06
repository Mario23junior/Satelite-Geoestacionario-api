package com.projeto.satellite.GeostationarySatellite.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Geolocalizacao {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String orbita;
	private String posicaoEmOrbita;
	private String localizacaoOrbital;
	private String cobertura;
	
	@ManyToOne
	private Satelite satelite;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

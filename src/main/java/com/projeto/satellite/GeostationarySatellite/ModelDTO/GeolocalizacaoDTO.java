package com.projeto.satellite.GeostationarySatellite.ModelDTO;

public class GeolocalizacaoDTO {
   
	private String orbita;
	private String posicaoEmOrbita;
	private String localizacaoOrbital;
	private String cobertura;
	
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
}

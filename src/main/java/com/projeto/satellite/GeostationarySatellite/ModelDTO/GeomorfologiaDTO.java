package com.projeto.satellite.GeostationarySatellite.ModelDTO;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;

public class GeomorfologiaDTO {
   
	private Double altitudeMinima;
	private Double altitudeMedia;
	private Double altitudeDePico;
	
 	private Satelite satelite;
	
	public Double getAltitudeMinima() {
		return altitudeMinima;
	}
	public void setAltitudeMinima(Double altitudeMinima) {
		this.altitudeMinima = altitudeMinima;
	}
	public Double getAltitudeMedia() {
		return altitudeMedia;
	}
	public void setAltitudeMedia(Double altitudeMedia) {
		this.altitudeMedia = altitudeMedia;
	}
	public Double getAltitudeDePico() {
		return altitudeDePico;
	}
	public void setAltitudeDePico(Double altitudeDePico) {
		this.altitudeDePico = altitudeDePico;
	}
	public Satelite getSatelite() {
		return satelite;
	}
	public void setSatelite(Satelite satelite) {
		this.satelite = satelite;
	}
	
	
	
	

}

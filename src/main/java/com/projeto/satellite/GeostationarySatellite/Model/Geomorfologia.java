package com.projeto.satellite.GeostationarySatellite.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Geomorfologia {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double altitudeMinima;
	private Double altitudeMedia;
	private Double altitudeDePico;
	
	@ManyToOne
	private Satelite satelite;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

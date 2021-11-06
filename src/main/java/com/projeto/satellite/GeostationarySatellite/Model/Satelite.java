package com.projeto.satellite.GeostationarySatellite.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Satelite {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeDeDiretriz;
	private String nomeComun;
	private String fabricante;
	private String veiculo;
	
	@OneToMany(mappedBy = "satelite")
	private List<Aeroespacial> aeroespacial;
	
	@OneToMany(mappedBy = "satelite")
	private List<Comunicacao> comunicacao;
	
	@OneToMany(mappedBy = "satelite")
	private List<Geolocalizacao> geolocalizacaos;
	
	@OneToMany(mappedBy = "satelite")
	private List<Geomorfologia> geomorfologias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDeDiretriz() {
		return nomeDeDiretriz;
	}

	public void setNomeDeDiretriz(String nomeDeDiretriz) {
		this.nomeDeDiretriz = nomeDeDiretriz;
	}

	public String getNomeComun() {
		return nomeComun;
	}

	public void setNomeComun(String nomeComun) {
		this.nomeComun = nomeComun;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public List<Aeroespacial> getAeroespacial() {
		return aeroespacial;
	}

	public void setAeroespacial(List<Aeroespacial> aeroespacial) {
		this.aeroespacial = aeroespacial;
	}

	public List<Comunicacao> getComunicacao() {
		return comunicacao;
	}

	public void setComunicacao(List<Comunicacao> comunicacao) {
		this.comunicacao = comunicacao;
	}

	public List<Geolocalizacao> getGeolocalizacaos() {
		return geolocalizacaos;
	}

	public void setGeolocalizacaos(List<Geolocalizacao> geolocalizacaos) {
		this.geolocalizacaos = geolocalizacaos;
	}

	public List<Geomorfologia> getGeomorfologias() {
		return geomorfologias;
	}

	public void setGeomorfologias(List<Geomorfologia> geomorfologias) {
		this.geomorfologias = geomorfologias;
	}
	
	
}

package com.projeto.satellite.GeostationarySatellite.ModelDTO;

import java.util.List;

import javax.persistence.OneToMany;

public class SateliteDTO {

	private String nomeDeDiretriz;
	private String nomeComun;
	private String fabricante;
	private String veiculo;
	
	@OneToMany(mappedBy = "satelite")
	private List<AeroespacialDTO> aeroespacialDto;
	
	@OneToMany(mappedBy = "satelite")
	private List<ComunicacaoDTO> comunicacaoDto;
	
	@OneToMany(mappedBy = "satelite")
	private List<GeolocalizacaoDTO> geolocalizacaosDto;
	
	@OneToMany(mappedBy = "satelite")
	private List<GeomorfologiaDTO> geomorfologiasDto;
 
	public SateliteDTO() {
		// TODO Auto-generated constructor stub
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

	public List<AeroespacialDTO> getAeroespacialDto() {
		return aeroespacialDto;
	}

	public void setAeroespacialDto(List<AeroespacialDTO> aeroespacialDto) {
		this.aeroespacialDto = aeroespacialDto;
	}

	public List<ComunicacaoDTO> getComunicacaoDto() {
		return comunicacaoDto;
	}

	public void setComunicacaoDto(List<ComunicacaoDTO> comunicacaoDto) {
		this.comunicacaoDto = comunicacaoDto;
	}

	public List<GeolocalizacaoDTO> getGeolocalizacaosDto() {
		return geolocalizacaosDto;
	}

	public void setGeolocalizacaosDto(List<GeolocalizacaoDTO> geolocalizacaosDto) {
		this.geolocalizacaosDto = geolocalizacaosDto;
	}

	public List<GeomorfologiaDTO> getGeomorfologiasDto() {
		return geomorfologiasDto;
	}

	public void setGeomorfologiasDto(List<GeomorfologiaDTO> geomorfologiasDto) {
		this.geomorfologiasDto = geomorfologiasDto;
	}
	
}
package com.projeto.satellite.GeostationarySatellite.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Satelite {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeDeDiretriz;
	private String nomeComun;
	private String fabricante;
	private String veiculo;

	
	
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

}

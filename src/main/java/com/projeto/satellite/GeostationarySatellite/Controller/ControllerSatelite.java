package com.projeto.satellite.GeostationarySatellite.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.SateliteDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceSatelite;

@RestController
@RequestMapping("/api/v1/project/satelite/")
public class ControllerSatelite {

	private ServiceSatelite serviceSatelite;

	public ControllerSatelite(ServiceSatelite serviceSatelite) {
		this.serviceSatelite = serviceSatelite;
	}

	@PostMapping
	public ResponseEntity<SateliteDTO> save(@RequestBody @Valid SateliteDTO sateliteDto) {
		return serviceSatelite.saveSatelite(sateliteDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SateliteDTO> list(@PathVariable Long id) {
		return serviceSatelite.listSateliteId(id);
	}
	
	@GetMapping("nomeIndentification/{nomeComun}")
	public ResponseEntity<SateliteDTO> listNameComun(@PathVariable @Valid String nomeComun) {
		 return serviceSatelite.findByNameCommun(nomeComun);
	}
	
	@GetMapping("nomeDiretriz/{nomeDeDiretriz}")
	public ResponseEntity<SateliteDTO> listNameDeDiretriz(@PathVariable @Valid String nomeDeDiretriz) {
		 return serviceSatelite.findByNomeDeDiretriz(nomeDeDiretriz);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SateliteDTO> updateSatelite(@PathVariable Long id, @RequestBody Satelite satelite) {
		return serviceSatelite.updateSatelite(id, satelite);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SateliteDTO> deleteSatelite(@PathVariable Long id) {
		return serviceSatelite.deleteSatelite(id);
	}
}














package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.ModelDTO.GeolocalizacaoDTO;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.GeomorfologiaDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceGeomorfologia;

@RestController
@RequestMapping("/api/v1/project/geomorfologia/")
public class ControllerGeomorfologia {
   
	private ServiceGeomorfologia service;
	
	public ControllerGeomorfologia(ServiceGeomorfologia service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<GeomorfologiaDTO> saveGeomor(@RequestBody GeomorfologiaDTO geomorfologiaDto) {
		return service.saveGeomor(geomorfologiaDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GeomorfologiaDTO> listIdGeomor(@PathVariable Long id) {
		return service.listIdGeomorfo(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<GeomorfologiaDTO> updateGeomorfologia(@PathVariable Long id, @RequestBody GeomorfologiaDTO geoDto) {
		return service.updateGemorfolos(id, geoDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<GeolocalizacaoDTO> deleteGeomor(@PathVariable Long id) {
		return service.deleteGeomor(id);
	}
	
}











package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

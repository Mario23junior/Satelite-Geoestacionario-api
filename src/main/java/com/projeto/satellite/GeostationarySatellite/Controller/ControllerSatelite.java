package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<SateliteDTO> save(@RequestBody SateliteDTO sateliteDto) {
		return serviceSatelite.saveSatelite(sateliteDto);
	}
}
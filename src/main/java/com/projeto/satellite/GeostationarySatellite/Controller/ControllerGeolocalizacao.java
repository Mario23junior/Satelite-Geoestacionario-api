package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.ModelDTO.GeolocalizacaoDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceGeolocalizacao;

@RestController
@RequestMapping("/api/v1/project/geolocalizacao/")
public class ControllerGeolocalizacao {
   
	private ServiceGeolocalizacao geolocalizacaoService;
	
	public ControllerGeolocalizacao(ServiceGeolocalizacao geolocalizacaoService) {
		this.geolocalizacaoService = geolocalizacaoService;
	}
	
	@PostMapping
	public ResponseEntity<GeolocalizacaoDTO> save(@RequestBody GeolocalizacaoDTO geolocalizacaoDto) {
	   return geolocalizacaoService.saveGeolocalizacao(geolocalizacaoDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeolocalizacaoDTO> listId(@PathVariable Long id) {
		return geolocalizacaoService.listGeo(id);
	}
}

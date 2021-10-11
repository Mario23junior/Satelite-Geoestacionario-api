package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.ModelDTO.AeroespacialDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceAeroespacial;

@RestController
@RequestMapping("/api/v1/project/aeroespacial/")
public class ControllerAeroespacial {
   
	private ServiceAeroespacial aeroespacial;
	
	public ControllerAeroespacial(ServiceAeroespacial aeroespacial) {
		this.aeroespacial = aeroespacial;
	}
	
	@PostMapping
	public ResponseEntity<AeroespacialDTO> saveAeroespacial(@RequestBody AeroespacialDTO aeroespacialDTO){
		return aeroespacial.saveAeroespacial(aeroespacialDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AeroespacialDTO> listAero(@PathVariable Long id) {
		return aeroespacial.listAreoespacial(id);
	}
}

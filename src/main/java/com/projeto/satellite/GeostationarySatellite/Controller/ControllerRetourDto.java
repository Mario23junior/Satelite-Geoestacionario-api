package com.projeto.satellite.GeostationarySatellite.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.ModelDTO.SateliteDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceListDataEntity;

@RestController
@RequestMapping("/api/v1/project/return/valour/")
public class ControllerRetourDto {
  
	private ServiceListDataEntity serviceListDataEntity;
 	
	public ControllerRetourDto(ServiceListDataEntity serviceListDataEntity) {
 		this.serviceListDataEntity = serviceListDataEntity;
 	}
	
	@GetMapping
	public List<SateliteDTO> listAll() {
		return serviceListDataEntity.ListAllDataDTO();
	}	
}

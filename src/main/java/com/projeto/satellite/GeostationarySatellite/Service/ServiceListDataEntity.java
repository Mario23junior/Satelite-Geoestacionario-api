package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.SateliteDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.SateliteRepository;

@Service
public class ServiceListDataEntity {
  
	private SateliteRepository sateliteRepository;
	private ModelMapper mapper;
	
	public ServiceListDataEntity(SateliteRepository sateliteRepository, ModelMapper mapper) {
		this.sateliteRepository = sateliteRepository;
		this.mapper = mapper;
	}
	
	public List<SateliteDTO> listAllInformationData() {
	    return ((List<Satelite>) sateliteRepository
	    		.findAll())
	    		.stream()
	    		.map(this::ConvertEntityAllDTO)
                .collect(Collectors.toList());

	}
	
	private SateliteDTO ConvertEntityAllDTO(Satelite satelite) {
		SateliteDTO vulcaoDataConvert = mapper.map(satelite, SateliteDTO.class);
 		return vulcaoDataConvert;
	}
	
	public List<SateliteDTO> ListAllDataDTO() {
		List<SateliteDTO> list = listAllInformationData();
		return list
				.stream()
				.collect(Collectors.toList());
	}
	
	
}

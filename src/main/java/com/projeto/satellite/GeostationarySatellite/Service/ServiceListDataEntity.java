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
		super();
		this.sateliteRepository = sateliteRepository;
		this.mapper = mapper;
	}
	
	public List<SateliteDTO> ListAll() {
		return ((List<Satelite>) sateliteRepository
				       .findAll())
				       .stream()
				       .map(this::ConvertEntidade)
				       .collect(Collectors.toList());
	}
	
	private SateliteDTO ConvertEntidade(Satelite satelite) {
		SateliteDTO converter = mapper.map(satelite, SateliteDTO.class);
		return converter;
	}
	
	public List<SateliteDTO> ListAllDataValue() {
		List<SateliteDTO> list = ListAll();
		return list
			   .stream()
			   .collect(Collectors.toList());
	}
	
	
}

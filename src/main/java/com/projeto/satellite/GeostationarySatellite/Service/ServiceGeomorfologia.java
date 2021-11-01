package com.projeto.satellite.GeostationarySatellite.Service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Model.Geomorfologia;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.GeomorfologiaDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.GeomorfologiaRepository;

@Service
public class ServiceGeomorfologia {
   
	private GeomorfologiaRepository geomorRepository;
	private ModelMapper mapper;
	
	public ServiceGeomorfologia(GeomorfologiaRepository geomorRepository, ModelMapper mapper) {
		this.geomorRepository = geomorRepository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<GeomorfologiaDTO> saveGeomor(GeomorfologiaDTO geomorDto) {
		Geomorfologia saveGeo = saveBody(mapper.map(geomorDto, Geomorfologia.class));
		return ResponseEntity
		       .status(HttpStatus.OK)
		       .body(mapper.map(saveGeo, GeomorfologiaDTO.class));
	}
	
	public Geomorfologia saveBody (Geomorfologia geomorfologia) {
		return geomorRepository.save(geomorfologia);
	}
} 

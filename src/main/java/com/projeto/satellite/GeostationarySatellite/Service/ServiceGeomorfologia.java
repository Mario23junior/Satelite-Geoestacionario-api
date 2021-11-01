package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;
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
		ExceptionDuplicateGeomorfologia(geomorfologia);
		return geomorRepository.save(geomorfologia);
	}
	
	public void  ExceptionDuplicateGeomorfologia(Geomorfologia geomorfologia) {
		Geomorfologia findNameAltitudeMinima = geomorRepository.findByAltitudeMinima(geomorfologia.getAltitudeMinima());
		if(findNameAltitudeMinima != null && findNameAltitudeMinima.getId() != geomorfologia.getId()) {
			throw new ValidatingDuplicateValues(String.format("Estas informações já foram cadastradas"));
		}
	}
	
	public ResponseEntity<GeomorfologiaDTO> listIdGeomorfo(@PathVariable Long id) {
		Optional<Geomorfologia> listId = geomorRepository.findById(id);
		if(listId.isPresent()) {
			return ResponseEntity.ok(mapper.map(listId.get(), GeomorfologiaDTO.class));
		} else {
 			throw new ReturnMessageWhenNoSavedIdFound(String.format("Este %s nã foi encontrado no banco de dados",id));
		}
	}
} 

















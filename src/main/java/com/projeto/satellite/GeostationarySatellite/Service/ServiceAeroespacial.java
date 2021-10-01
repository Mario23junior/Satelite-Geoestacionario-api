package com.projeto.satellite.GeostationarySatellite.Service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Model.Aeroespacial;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.AeroespacialDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.AeroespacialRepositry;

@Service
public class ServiceAeroespacial {
   
	private ModelMapper modelMapper;
	private AeroespacialRepositry aereoRepository;
	
	public ServiceAeroespacial(ModelMapper modelMapper, AeroespacialRepositry aereoRepository) {
 		this.modelMapper = modelMapper;
		this.aereoRepository = aereoRepository;
	}
	
	public ResponseEntity<AeroespacialDTO> saveAeroespacial(AeroespacialDTO areoDto) {
		Aeroespacial saveDataId = saveBody(modelMapper.map(areoDto, Aeroespacial.class));
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(modelMapper.map(saveDataId, AeroespacialDTO.class));
	}
	
	public Aeroespacial saveBody(Aeroespacial aeroespacial) {
		return aereoRepository.save(aeroespacial);
	}
}

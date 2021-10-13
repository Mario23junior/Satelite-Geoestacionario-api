package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
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
	
	public ResponseEntity<AeroespacialDTO> listAreoespacial(Long id) {
		Optional<Aeroespacial> listId = aereoRepository.findById(id);
		if(listId.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listId.get(), AeroespacialDTO.class));
		} else {
            throw new ReturnMessageWhenNoSavedIdFound(String.format("Informação não encontrada"));
		}
	}
	
	public ResponseEntity<AeroespacialDTO> findByOperador(String operador) {
		Optional<Aeroespacial> listDataOperador = aereoRepository
				.findByoperadorIgnoreCaseContaining(operador);
		
		if(listDataOperador.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listDataOperador.get(), AeroespacialDTO.class));
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("O %s não encontrado cadastrado no banco de dados", operador));
		}
				
	}
}

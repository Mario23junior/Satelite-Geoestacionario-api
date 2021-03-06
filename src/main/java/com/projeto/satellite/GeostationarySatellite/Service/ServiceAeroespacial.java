package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;
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
				.status(HttpStatus.CREATED)
				.body(modelMapper.map(saveDataId, AeroespacialDTO.class));
	}
	
	public Aeroespacial saveBody(Aeroespacial aeroespacial) {
		ExceptionDuplicateDataAeroespacial(aeroespacial);
		return aereoRepository.save(aeroespacial);
	}
	
	
	public void ExceptionDuplicateDataAeroespacial(Aeroespacial aero) {
	Aeroespacial findOperador = aereoRepository.findByOperadorIgnoreCaseContaining(aero.getOperador());
		if(findOperador != null && findOperador.getId() != aero.getId()) {
			throw new ValidatingDuplicateValues(String.format("Informação já cadastrada no banco de dados."));
		}
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
				.findByVidaUtilIgnoreCaseContaining(operador);
		if(listDataOperador.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listDataOperador.get(), AeroespacialDTO.class));
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("O %s não encontrado cadastrado no banco de dados", operador));
		}
	}
		
	public ResponseEntity<AeroespacialDTO> updateAeroespacial(Long id, AeroespacialDTO aeroespacialDTO) {
		Optional<Aeroespacial> listId = aereoRepository.findById(id);
		if(listId.isPresent()) {
			Aeroespacial aero = listId.get();
			ExceptionDuplicateDataAeroespacial(aero);
 			aero.setPeso(aeroespacialDTO.getPeso());
			aero.setVidaUtil(aeroespacialDTO.getVidaUtil());
			aero.setLancamento(aeroespacialDTO.getLancamento());
			aero.setOperador(aeroespacialDTO.getOperador());
			aereoRepository.save(aero);
			return ResponseEntity.ok(modelMapper.map(aero, AeroespacialDTO.class));
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("falha ao atualizar informações de tipos de informação espacial"));
		}
 	}
	
	public ResponseEntity<AeroespacialDTO> deleteAeroespacial(Long id) {
		Optional<Aeroespacial> findId = aereoRepository.findById(id);
		if(findId.isPresent()) {
			aereoRepository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("Não foi encontrada codigo de indenficação para esclusão"));
		}
	}
}



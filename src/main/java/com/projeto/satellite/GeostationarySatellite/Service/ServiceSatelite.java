package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;
import com.projeto.satellite.GeostationarySatellite.Model.Satelite;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.SateliteDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.SateliteRepository;

@Service
public class ServiceSatelite {
   
	private ModelMapper modelMapper;
	private SateliteRepository sateliteRepository;

	public ServiceSatelite(ModelMapper modelMapper, SateliteRepository sateliteRepository) {
		this.modelMapper = modelMapper;
		this.sateliteRepository = sateliteRepository;
	}

	public ResponseEntity<SateliteDTO> saveSatelite(SateliteDTO sateliteDTO) {
		Satelite saveEntity = saveBody(modelMapper.map(sateliteDTO,Satelite.class));
		return ResponseEntity
				            .status(HttpStatus.CREATED)
				            .body(modelMapper.map(saveEntity, SateliteDTO.class));
	}
	
	public Satelite saveBody (Satelite satelite) {
		ExceptionDuplicateDataSatelite(satelite);
		return sateliteRepository.save(satelite);
	}
	
	public void  ExceptionDuplicateDataSatelite(Satelite satelite) {
		Satelite findNameDiretriz = sateliteRepository.findBynomeDeDiretrizIgnoreCaseContaining(satelite.getNomeDeDiretriz());
		if(findNameDiretriz != null && findNameDiretriz.getId() != satelite.getId()) {
			throw new ValidatingDuplicateValues(String.format(" O Satelite %s já está cadastrado no banco de dados", satelite.getNomeComun()));
		}
	}
	
	public ResponseEntity<SateliteDTO> listSateliteId(Long id) {
		Optional<Satelite> listId = sateliteRepository.findById(id);
		if(listId.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listId.get(), SateliteDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
 	public ResponseEntity<SateliteDTO> findByNameCommun(String nomeComun) {
		Optional<Satelite> listNomeIndenti = sateliteRepository.findBynomeComunIgnoreCaseContaining(nomeComun);
		if(listNomeIndenti.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listNomeIndenti.get(), SateliteDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
 	
 	public ResponseEntity<SateliteDTO> findByNomeDeDiretriz(String nomeDeDiretriz) {
		Optional<Satelite> listNomeIndenti = sateliteRepository.findByNomeDeDiretrizIgnoreCaseContaining(nomeDeDiretriz);
		if(listNomeIndenti.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listNomeIndenti.get(), SateliteDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
 	
 	
 	public ResponseEntity<SateliteDTO> updateSatelite (Long id , Satelite satelite) {
 	   ExceptionDuplicateDataSatelite(satelite);
 	   Optional<Satelite> listId = sateliteRepository.findById(id);
 	   if(listId.isPresent()) {
 		   Satelite satl = listId.get();
  		   satl.setNomeDeDiretriz(satelite.getNomeDeDiretriz());
 		   satl.setNomeComun(satelite.getNomeComun());
 		   satl.setFabricante(satelite.getFabricante());
 		   satl.setVeiculo(satelite.getVeiculo());
 		   
 		   sateliteRepository.save(satl);
 		   return ResponseEntity.ok(modelMapper.map(satl, SateliteDTO.class));
 	   } else {
 		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

 	   }
 	}	
}


















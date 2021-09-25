package com.projeto.satellite.GeostationarySatellite.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.SateliteDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.SateliteRepository;

@RestController
@RequestMapping("/api/v1/project/satelite/")
public class ControllerSatelite {

	private ModelMapper modelMapper;
	private SateliteRepository sateliteRepository;

	public ControllerSatelite(ModelMapper modelMapper, SateliteRepository sateliteRepository) {
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
		return sateliteRepository.save(satelite);
	}
	
//	public void  ExceptionDuplicateDataSatelite(Satelite satelite) {
//		Satelite findNameDiretriz = sateliteRepository.findBynomeDeDiretrizIgnoreCaseContaining(satelite.getNomeDeDiretriz());
//		if(findNameDiretriz != null && findNameDiretriz.getId() != satelite.getId()) {
//			throw new ValidatingDuplicateValues(String.format(" O Satelite %s já está cadastrado no banco de dados", satelite.getNomeComun()));
//		}
//	}
}




















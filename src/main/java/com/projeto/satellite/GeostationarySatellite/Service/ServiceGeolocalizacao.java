package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;
import com.projeto.satellite.GeostationarySatellite.Model.Geolocalizacao;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.GeolocalizacaoDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.GeolocalizacaoRepository;

@Service
public class ServiceGeolocalizacao {
    
	private ModelMapper modelmapper;
	private GeolocalizacaoRepository geoRepository;
	
	public ServiceGeolocalizacao(ModelMapper modelmapper, GeolocalizacaoRepository geoRepository) {
 		this.modelmapper = modelmapper;
		this.geoRepository = geoRepository;
	}
	
	public ResponseEntity<GeolocalizacaoDTO> saveGeolocalizacao(GeolocalizacaoDTO geolocalizacaoDto) {
	    Geolocalizacao saveBody = saveEntityBody(modelmapper.map(geolocalizacaoDto, Geolocalizacao.class));
	    return ResponseEntity
	    		.status(HttpStatus.CREATED)
	    		.body(modelmapper.map(saveBody, GeolocalizacaoDTO.class));
	}
	
	public Geolocalizacao saveEntityBody(Geolocalizacao geolocalizacao) {
		ExceptionDuplicateDataGeolocalizacao(geolocalizacao);
		return geoRepository.save(geolocalizacao);
	}
	
	public void ExceptionDuplicateDataGeolocalizacao(Geolocalizacao geo) {
		Geolocalizacao findOrbita = geoRepository.findByOrbitaIgnoreCaseContaining(geo.getOrbita());
		if(findOrbita != null && findOrbita.getId() != geo.getId()) {
			throw new ValidatingDuplicateValues(String.format("Informação já cadastrada no banco de dados."));
		}
	}
	
	public ResponseEntity<GeolocalizacaoDTO> listGeo(Long id) {
		Optional<Geolocalizacao> listId = geoRepository.findById(id);
		if(listId.isPresent()) {
			return ResponseEntity.ok(modelmapper.map(listId.get(), GeolocalizacaoDTO.class));
		} else {
 			throw new ReturnMessageWhenNoSavedIdFound(String.format("id de indentificação %s não existe em nosso cadastro",id));
		}
	}
	
	
	public ResponseEntity<GeolocalizacaoDTO> listGeoOrbita(String orbita) {
		Optional<Geolocalizacao> listOrbita = geoRepository.findByorbitaIgnoreCaseContaining(orbita);
		if(listOrbita.isPresent()) {
			return ResponseEntity.ok(modelmapper.map(listOrbita.get(), GeolocalizacaoDTO.class));
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("Por favor a orbita %s não esta cadastrada na base",orbita));
		}
	}
}











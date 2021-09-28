package com.projeto.satellite.GeostationarySatellite.Service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
}


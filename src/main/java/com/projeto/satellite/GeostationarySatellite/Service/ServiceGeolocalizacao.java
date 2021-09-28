package com.projeto.satellite.GeostationarySatellite.Service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Repository.GeolocalizacaoRepository;

@Service
public class ServiceGeolocalizacao {
    
	private ModelMapper modelmapper;
	private GeolocalizacaoRepository geolocalizacaoRepository;
	
	public ServiceGeolocalizacao(ModelMapper modelmapper, GeolocalizacaoRepository geolocalizacaoRepository) {
 		this.modelmapper = modelmapper;
		this.geolocalizacaoRepository = geolocalizacaoRepository;
	}
	
	
	
	
}

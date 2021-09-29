package com.projeto.satellite.GeostationarySatellite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.satellite.GeostationarySatellite.Model.Geolocalizacao;

@Repository
public interface GeolocalizacaoRepository extends JpaRepository<Geolocalizacao, Long>{

	Geolocalizacao findByOrbitaIgnoreCaseContaining(String Orbita);
	Optional<Geolocalizacao> findByorbitaIgnoreCaseContaining(String Orbita);


}

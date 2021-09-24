package com.projeto.satellite.GeostationarySatellite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Geolocalizacao extends JpaRepository<Geolocalizacao, Long>{

}

package com.projeto.satellite.GeostationarySatellite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.satellite.GeostationarySatellite.Model.Aeroespacial;

@Repository
public interface AeroespacialRepositry extends JpaRepository<Aeroespacial, Long>{

	Aeroespacial findByOperadorIgnoreCaseContaining(String operador);
	Optional<Aeroespacial> findByVidaUtilIgnoreCaseContaining(String vidaUtil);



}

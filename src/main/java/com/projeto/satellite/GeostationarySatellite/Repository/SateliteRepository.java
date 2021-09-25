package com.projeto.satellite.GeostationarySatellite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.satellite.GeostationarySatellite.Model.Satelite;

@Repository
public interface SateliteRepository extends JpaRepository<Satelite, Long>{
   
	Satelite findBynomeDeDiretrizIgnoreCaseContaining (String nomeDeDiretriz);
}

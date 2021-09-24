package com.projeto.satellite.GeostationarySatellite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.satellite.GeostationarySatellite.Model.Comunicacao;

@Repository
public interface ComunicacaoRepository extends JpaRepository<Comunicacao, Long>{

}

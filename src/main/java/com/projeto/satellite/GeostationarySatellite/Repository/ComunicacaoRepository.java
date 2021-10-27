package com.projeto.satellite.GeostationarySatellite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.satellite.GeostationarySatellite.Model.Comunicacao;

@Repository
public interface ComunicacaoRepository extends JpaRepository<Comunicacao, Long>{

	Comunicacao findByTipoBandaIgnoreCaseContaining(String tipoBanda);
	Optional<Comunicacao> findByAtivo(boolean ativo);

}

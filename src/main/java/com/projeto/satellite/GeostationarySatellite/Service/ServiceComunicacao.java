package com.projeto.satellite.GeostationarySatellite.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.satellite.GeostationarySatellite.Exceptions.ReturnMessageWhenNoSavedIdFound;
import com.projeto.satellite.GeostationarySatellite.Exceptions.ValidatingDuplicateValues;
import com.projeto.satellite.GeostationarySatellite.Model.Comunicacao;
import com.projeto.satellite.GeostationarySatellite.ModelDTO.ComunicacaoDTO;
import com.projeto.satellite.GeostationarySatellite.Repository.ComunicacaoRepository;

@Service
public class ServiceComunicacao {
   
	private ComunicacaoRepository comuniRepository;
	private ModelMapper modelMapper;
	
	public ServiceComunicacao(ComunicacaoRepository comuniRepository, ModelMapper modelMapper) {
		this.comuniRepository = comuniRepository;
		this.modelMapper = modelMapper;
	}
	
	public ResponseEntity<ComunicacaoDTO> saveComunicao(ComunicacaoDTO comuniDto) {
	   Comunicacao saveId = saveBodyeComunicacao(modelMapper.map(comuniDto, Comunicacao.class));
	   return ResponseEntity
			              .status(HttpStatus.CREATED)
			              .body(modelMapper.map(saveId, ComunicacaoDTO.class));
	}
	
	public Comunicacao saveBodyeComunicacao(Comunicacao comunicacao) {
		ExceptionDuplicationComunicacao(comunicacao);
		Comunicacao saveComuni = comuniRepository.save(comunicacao);
 		return saveComuni;
	}
	
	public void ExceptionDuplicationComunicacao(Comunicacao comunicacao) {
		Comunicacao findComunicao = comuniRepository.findByTipoBandaIgnoreCaseContaining(comunicacao.getTipoBanda());
		if(findComunicao != null && findComunicao.getId() != comunicacao.getId()) {
			throw new ValidatingDuplicateValues(String.format("A %s já esta cadastrada no banco de dados"
					,comunicacao.getTipoBanda()));
		}
	}
	
	public ResponseEntity<ComunicacaoDTO> findSatellitesActivities(boolean ativo) {
 		Optional<Comunicacao> listSatelite = comuniRepository.findByAtivo(ativo);
		if(listSatelite.isPresent()) {
			return ResponseEntity.ok(modelMapper.map(listSatelite.get(), ComunicacaoDTO.class));
		} else {
			throw new ReturnMessageWhenNoSavedIdFound(String.format("Nenhum satelite encontrato com esta informação"));
		}
	}
	
}

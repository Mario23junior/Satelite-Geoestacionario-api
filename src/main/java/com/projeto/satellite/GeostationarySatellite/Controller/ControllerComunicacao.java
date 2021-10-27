package com.projeto.satellite.GeostationarySatellite.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.satellite.GeostationarySatellite.ModelDTO.ComunicacaoDTO;
import com.projeto.satellite.GeostationarySatellite.Service.ServiceComunicacao;

@RestController
@RequestMapping("/api/v1/project/comunicacao/")
public class ControllerComunicacao {
    
	private ServiceComunicacao serviceComuni;
	
	public ControllerComunicacao(ServiceComunicacao serviceComuni) {
		this.serviceComuni = serviceComuni;
	}
	
	@PostMapping
	public ResponseEntity<ComunicacaoDTO> saveComunicacao(@RequestBody ComunicacaoDTO comunicacaoDTO) {
		return serviceComuni.saveComunicao(comunicacaoDTO);
	}
	
	@GetMapping("atividade/{ativo}")
	public ResponseEntity<ComunicacaoDTO> listSateliteActivo(@PathVariable boolean ativo) {
		return serviceComuni.findSatellitesActivities(ativo);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ComunicacaoDTO> listId(@PathVariable Long id) {
		return serviceComuni.findComunicacaoId(id);
	}
}

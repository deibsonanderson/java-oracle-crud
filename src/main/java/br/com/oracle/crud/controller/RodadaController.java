package br.com.oracle.crud.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.RequestFilterDTO;
import br.com.oracle.crud.dto.RodadaDTO;
import br.com.oracle.crud.entity.RodadaEntity;
import br.com.oracle.crud.service.RodadaService;

@RestController
@RequestMapping("/rodada")
public class RodadaController  extends BaseController<RodadaEntity, RodadaDTO> {

	@Autowired
	private RodadaService rodadaService;
	
	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RodadaDTO>> queryOrderByFilter(
			@RequestParam(value = "page", defaultValue = "0") Integer skip,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer top,
			@RequestParam(value = "RodadaNome", defaultValue = StringUtils.EMPTY) String rodadaNome,
			@RequestParam(value = "jogadorNome", defaultValue = StringUtils.EMPTY) String jogadorNome,
			@RequestParam(value = "campoNome", defaultValue = StringUtils.EMPTY) String campoNome,
			@RequestParam(value = "startDate", defaultValue = StringUtils.EMPTY) String startDate,
			@RequestParam(value = "endDate", defaultValue = StringUtils.EMPTY) String endDate) {
		
		RequestFilterDTO filter = new RequestFilterDTO();
		filter.setSkip(skip);
		filter.setTop(top);
		filter.setTimeNome(rodadaNome);
		filter.setCampoNome(campoNome);
		//TODO fix later
		//filter.setStartDate(startDate);
		//filter.setEndDate(endDate);
		//filter.setJogadorNome(jogadorNome);
		return ResponseEntity.status(HttpStatus.OK).body(rodadaService.findByFilter(filter));
	}
}

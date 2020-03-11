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

import br.com.oracle.crud.dto.RequestTimeFilterDTO;
import br.com.oracle.crud.dto.TimeDTO;
import br.com.oracle.crud.entity.TimeEntity;
import br.com.oracle.crud.service.TimeService;

@RestController
@RequestMapping("/time")
public class TimeController  extends BaseController<TimeEntity, TimeDTO> {

	@Autowired
	private TimeService timeService;
	
	@GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TimeDTO>> queryOrderByFilter(
			@RequestParam(value = "page", defaultValue = "0") Integer skip,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer top,
			@RequestParam(value = "timeNome", defaultValue = StringUtils.EMPTY) String timeNome,
			@RequestParam(value = "jogadorNome", defaultValue = StringUtils.EMPTY) String jogadorNome) {
		
		RequestTimeFilterDTO filter = new RequestTimeFilterDTO();
		filter.setSkip(skip);
		filter.setTop(top);
		filter.setJogadorNome(jogadorNome);
		filter.setTimeNome(timeNome);
		return ResponseEntity.status(HttpStatus.OK).body(timeService.findByFilter(filter));
	}
}

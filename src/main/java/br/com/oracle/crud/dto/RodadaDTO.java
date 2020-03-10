package br.com.oracle.crud.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class RodadaDTO {

	private Integer id;
	
	List<JogoDTO> jogos;
	
	LocalDateTime periodo;
}

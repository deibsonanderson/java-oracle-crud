package br.com.oracle.crud.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class RodadaDTO {

	private Integer id;
	
	List<JogoDTO> jogos;
	
	Date periodo;
}

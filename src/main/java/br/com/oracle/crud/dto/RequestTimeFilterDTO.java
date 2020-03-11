package br.com.oracle.crud.dto;

import lombok.Data;

@Data
public class RequestTimeFilterDTO {
	
	private String timeNome;
	
	private String jogadorNome;
	
	private Integer skip;
	
	private Integer top;

}

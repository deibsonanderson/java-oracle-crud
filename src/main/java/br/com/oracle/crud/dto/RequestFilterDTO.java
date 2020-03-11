package br.com.oracle.crud.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestFilterDTO {

	private String timeNome;

	private String jogadorNome;

	private String campoNome;

	private Integer skip;

	private LocalDate startDate;

	private LocalDate endDate;

	private Integer top;

}

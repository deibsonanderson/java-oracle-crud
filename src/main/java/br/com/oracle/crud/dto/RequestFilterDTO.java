package br.com.oracle.crud.dto;

import java.util.Date;

import lombok.Data;

@Data
public class RequestFilterDTO {

	private String timeNome;

	private String jogadorNome;

	private String campoNome;

	private Integer skip;

	private Date startDate;

	private Date endDate;

	private Integer top;

}

package br.com.oracle.crud.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class JogoDTO {

	private Integer id;
	
	@Valid
	@NotNull
	private TimeDTO time1;
	
	@Valid
	@NotNull
	private TimeDTO time2;
	
	@Valid
	@NotNull
	private JuizDTO juiz;
	
	@Valid
	@NotNull
	@PositiveOrZero
	private Integer placar1;
	
	@Valid
	@NotNull
	@PositiveOrZero
	private Integer placar2;
	
	@Valid
	@NotNull
	private CampoDTO campo;

}

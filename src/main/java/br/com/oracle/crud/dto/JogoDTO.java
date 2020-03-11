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
	private TimeDTO timeCasa;
	
	@Valid
	@NotNull
	private TimeDTO timeVisitante;
	
	@Valid
	@NotNull
	private JuizDTO juiz;
	
	@Valid
	@NotNull
	@PositiveOrZero
	private Integer placarCasa;
	
	@Valid
	@NotNull
	@PositiveOrZero
	private Integer placarVisitante;
	
	@Valid
	@NotNull
	private CampoDTO campo;

}

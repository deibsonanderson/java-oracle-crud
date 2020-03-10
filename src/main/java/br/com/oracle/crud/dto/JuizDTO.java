package br.com.oracle.crud.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JuizDTO {

	private Integer id;
	
	@Valid
	@NotNull
	@NotBlank
	private String nome;
	
	private String genero;
	
}

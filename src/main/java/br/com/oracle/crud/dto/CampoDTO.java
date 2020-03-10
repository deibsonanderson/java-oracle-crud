package br.com.oracle.crud.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CampoDTO {

	private Integer id;
	
	@Valid
	@NotNull
	@NotBlank
	private String nome;
}

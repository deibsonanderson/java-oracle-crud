package br.com.oracle.crud.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class TimeDTO {

	private Integer id;
	
	@Valid
	@NotNull
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	@PositiveOrZero
	private Integer pontos;
	
	@Valid
	@NotNull
	private TecnicoDTO tecnico;
	
	@Valid
	@NotNull
	@NotEmpty
	private List<JogadorDTO> jogadoes;
	
}
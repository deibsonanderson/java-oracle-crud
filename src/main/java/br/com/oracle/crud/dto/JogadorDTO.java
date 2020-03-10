package br.com.oracle.crud.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class JogadorDTO {

	private Integer id;
	
	@Valid
	@NotNull
	@NotBlank
	String nome;

	@Valid
	@NotNull
	@Positive
	Integer numero;
	
	Integer quantidadeCartaoAmarelo;
	
	Integer quantidadeCartaoVermelho;
	
	Double salario;
	
	@Valid
	@NotNull
	Boolean titular;

}

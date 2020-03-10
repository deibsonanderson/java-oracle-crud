package br.com.oracle.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "JOGADOR")
@Data
public class JogadorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGADOR_SEQ")
	@SequenceGenerator(name = "JOGADOR_SEQ", sequenceName = "JOGADOR_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
		
	@Column(name = "NOME")
	String nome;

	@Column(name = "NUMERO")
	Integer numero;
	
	@Column(name = "QTD_CART_AMARELO")
	Integer quantidadeCartaoAmarelo;
	
	@Column(name = "QTD_CART_VERMELHO")
	Integer quantidadeCartaoVermelho;
	
	@Column(name = "SALARIO")
	Double salario;
	
	@Column(name = "IS_TITULAR")
	Boolean titular;

}

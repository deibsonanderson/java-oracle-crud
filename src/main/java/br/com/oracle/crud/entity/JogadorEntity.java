package br.com.oracle.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "JOGADOR")
@Data
@EqualsAndHashCode(callSuper=false)
public class JogadorEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4750780827906668565L;

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

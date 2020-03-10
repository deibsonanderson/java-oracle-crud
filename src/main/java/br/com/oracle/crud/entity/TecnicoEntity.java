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
@Table(name = "TECNICO")
@Data
public class TecnicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TECNICO_SEQ")
	@SequenceGenerator(name = "TECNICO_SEQ", sequenceName = "TECNICO_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "GENERO")
	private String genero;
}
	
	
	
	
	
	
	
	

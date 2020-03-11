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
@Table(name = "CAMPO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CampoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7183997549401472255L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPO_SEQ")
	@SequenceGenerator(name = "CAMPO_SEQ", sequenceName = "CAMPO_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
}

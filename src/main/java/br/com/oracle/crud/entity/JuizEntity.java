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
@Table(name = "JUIZ")
@Data
@EqualsAndHashCode(callSuper=false)
public class JuizEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5341505239369929036L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUIZ_SEQ")
	@SequenceGenerator(name = "JUIZ_SEQ", sequenceName = "JUIZ_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "GENERO")
	private String genero;
	
}

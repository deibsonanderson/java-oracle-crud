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
@Table(name = "TECNICO")
@Data
@EqualsAndHashCode(callSuper=false)
public class TecnicoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1144386576981915422L;

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
	
	
	
	
	
	
	
	

package br.com.oracle.crud.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "JOGO")
@Data
@EqualsAndHashCode(callSuper=false)
public class JogoEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3670372154927983399L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGO_SEQ")
	@SequenceGenerator(name = "JOGO_SEQ", sequenceName = "JOGO_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TIME_CASA_ID", referencedColumnName = "ID", insertable = true, updatable = true)
	private TimeEntity timeCasa;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TIME_VISITANTE_ID", referencedColumnName = "ID", insertable = true, updatable = true)
	private TimeEntity timeVisitante;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "JUIZ_ID", referencedColumnName = "ID", insertable = true, updatable = true)
	private JuizEntity juiz;
	
	@Column(name = "PLACAR_CASA")
	private Integer placarCasa;
	
	@Column(name = "PLACAR_VISITANTE")
	private Integer placarVisitante;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CAMPO_ID", referencedColumnName = "ID", insertable = true, updatable = true)
	private CampoEntity campo;

}

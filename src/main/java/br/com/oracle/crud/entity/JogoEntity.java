package br.com.oracle.crud.entity;

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

@Entity
@Table(name = "JOGO")
@Data
public class JogoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGO_SEQ")
	@SequenceGenerator(name = "JOGO_SEQ", sequenceName = "JOGO_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "JOGO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private TimeEntity timeCasa;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "JOGO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private TimeEntity timeVisitante;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "JOGO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private JuizEntity juiz;
	
	@Column(name = "PLACAR_CASA")
	private Integer placarCasa;
	
	@Column(name = "PLACAR_VISITANTE")
	private Integer placarVisitante;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "JOGO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private CampoEntity campo;

}

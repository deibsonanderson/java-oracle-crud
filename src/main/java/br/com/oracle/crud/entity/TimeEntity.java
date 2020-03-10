package br.com.oracle.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TIME")
@Data
public class TimeEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIME_SEQ")
	@SequenceGenerator(name = "TIME_SEQ", sequenceName = "TIME_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PONTO")
	private Integer ponto;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TIME_ID", referencedColumnName = "ID", insertable = true, updatable = true)
    private TecnicoEntity tecnico;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TIME_ID", insertable = true, updatable = true)
	private List<JogadorEntity> jogadoes;
	
}
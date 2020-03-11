package br.com.oracle.crud.entity;

import java.io.Serializable;
import java.util.Set;

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
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TIME")
@Data
@EqualsAndHashCode(callSuper=false)
public class TimeEntity extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = 7140618663890819812L;

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
	@JoinColumn(name = "TECNICO_ID", referencedColumnName = "ID", insertable = true, updatable = true)
    private TecnicoEntity tecnico;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TIME_ID", insertable = true, updatable = true)
	private Set<JogadorEntity> jogadores;
	
}
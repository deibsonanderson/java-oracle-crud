package br.com.oracle.crud.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "RODADA")
@Data
@EqualsAndHashCode(callSuper=false)
public class RodadaEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -4545796212387846449L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RODADA_SEQ")
	@SequenceGenerator(name = "RODADA_SEQ", sequenceName = "RODADA_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "RODADA_ID", insertable = true, updatable = true)
	Set<JogoEntity> jogos;
	
	@Column(name = "PERIODO")
	@Temporal(TemporalType.DATE)
	Date periodo;
}

package br.com.oracle.crud.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.com.oracle.crud.dto.RequestFilterDTO;
import br.com.oracle.crud.entity.CampoEntity;
import br.com.oracle.crud.entity.JogadorEntity;
import br.com.oracle.crud.entity.JogoEntity;
import br.com.oracle.crud.entity.RodadaEntity;
import br.com.oracle.crud.entity.TimeEntity;

public class SpecificationFilter {

	private static final String JOGOS = "jogos";
	private static final String CAMPO = "campo";
	private static final String NOME = "nome";
	private static final String ID_PK = "id";
	private static final String TIME_CASA = "timeCasa";
	private static final String TIME_VISITANTE = "timeVisitante";
	private static final String JOGADORES = "jogadores";
	private static final String PERIODO = "periodo";
	
	private static final String SYMBOL = "%";

	private SpecificationFilter() {}

	public static Specification<RodadaEntity> findByCriteria(RequestFilterDTO filter) {
		return new Specification<RodadaEntity>() {

			private static final long serialVersionUID = -7865501308668909780L;

			@Override
			public Predicate toPredicate(Root<RodadaEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				SetJoin<RodadaEntity, JogoEntity> joinJogo = root.joinSet(JOGOS, JoinType.LEFT);
				Join<JogoEntity, TimeEntity> joinTimeCasa = joinJogo.join(TIME_CASA, JoinType.LEFT);
				Join<JogoEntity, TimeEntity> joinTimeVisitante = joinJogo.join(TIME_VISITANTE, JoinType.LEFT);
				
				if (filter.getStartDate() != null && filter.getEndDate() != null) {
					Predicate date = cb.between(root.get(PERIODO), filter.getStartDate(),
							filter.getEndDate());
					predicates.add(date);
				}else if(filter.getStartDate() != null && filter.getEndDate() == null){
					Predicate date = cb.greaterThanOrEqualTo(root.get(PERIODO), filter.getStartDate());
					predicates.add(date);
					
				}else if(filter.getStartDate() == null && filter.getEndDate() != null){
					Predicate date = cb.lessThanOrEqualTo(root.get(PERIODO), filter.getEndDate());
					predicates.add(date);
				}
				
				if (StringUtils.isNotEmpty(filter.getTimeNome())) {
					Predicate nomeTimeCasa = cb.equal(joinTimeCasa.get(NOME), filter.getTimeNome());
					Predicate nomeTimeVisitante = cb.equal(joinTimeVisitante.get(NOME), filter.getTimeNome());
					predicates.add(cb.or(nomeTimeCasa, nomeTimeVisitante));
				}
				
				if (StringUtils.isNotEmpty(filter.getJogadorNome())) {
					Join<TimeEntity, JogadorEntity> joinJogadorCasa = joinTimeCasa.join(JOGADORES, JoinType.LEFT);
					Predicate nomeJogoCasa = cb.like(joinJogadorCasa.get(NOME), mountLikeValue(filter.getJogadorNome()));

					Join<TimeEntity, JogadorEntity> joinJogadorVisitante = joinTimeVisitante.join(JOGADORES, JoinType.LEFT);
					Predicate nomeJogoVisitante = cb.like(joinJogadorVisitante.get(NOME), mountLikeValue(filter.getJogadorNome()));
					
					predicates.add(cb.or(nomeJogoCasa, nomeJogoVisitante));
				}
			
				if (StringUtils.isNotEmpty(filter.getCampoNome())) {
					Join<JogoEntity, CampoEntity> joinCampo = joinJogo.join(CAMPO, JoinType.LEFT);
					predicates.add(cb.like(joinCampo.get(NOME), mountLikeValue(filter.getCampoNome())));
				}

				query.orderBy(cb.asc(root.get(ID_PK)));
				query.distinct(true);

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};
	}
	
	public static String mountLikeValue(String value){
		StringBuilder like = new StringBuilder(SYMBOL);
		like.append(value);
		like.append(SYMBOL);
		return like.toString();
	}

}

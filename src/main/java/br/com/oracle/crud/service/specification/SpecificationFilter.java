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

	private SpecificationFilter() {}

	public static Specification<RodadaEntity> findByCriteria(RequestFilterDTO filter) {
		return new Specification<RodadaEntity>() {

			private static final long serialVersionUID = -7865501308668909780L;

			@Override
			public Predicate toPredicate(Root<RodadaEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				SetJoin<RodadaEntity, JogoEntity> joinJogo = root.joinSet(JOGOS, JoinType.LEFT);

				if (filter.getStartDate() != null && filter.getEndDate() != null) {
					Predicate date = cb.between(root.get("lastModifiedDate"), filter.getStartDate(),
							filter.getEndDate());
					predicates.add(date);
				}
				
				if (StringUtils.isNotEmpty(filter.getTimeNome())) {
					Join<JogoEntity, TimeEntity> joinTimeCasa = joinJogo.join(TIME_CASA, JoinType.LEFT);
					predicates.add(cb.equal(joinTimeCasa.get(NOME), filter.getTimeNome()));
				}

				if (StringUtils.isNotEmpty(filter.getTimeNome())) {
					Join<JogoEntity, TimeEntity> joinTimeVisitante = joinJogo.join(TIME_VISITANTE, JoinType.LEFT);
					predicates.add(cb.equal(joinTimeVisitante.get(NOME), filter.getTimeNome()));
				}
				
				if (StringUtils.isNotEmpty(filter.getCampoNome())) {
					Join<JogoEntity, CampoEntity> joinCampo = joinJogo.join(CAMPO, JoinType.LEFT);
					predicates.add(cb.like(joinCampo.get(NOME), "%"+filter.getCampoNome()+"%"));
				}

				query.orderBy(cb.asc(root.get(ID_PK)));
				query.distinct(true);

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};
	}

}

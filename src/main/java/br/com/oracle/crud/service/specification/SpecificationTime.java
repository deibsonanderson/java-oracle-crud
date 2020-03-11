package br.com.oracle.crud.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.com.oracle.crud.dto.RequestTimeFilterDTO;
import br.com.oracle.crud.entity.JogadorEntity;
import br.com.oracle.crud.entity.TimeEntity;

public class SpecificationTime {

	private static final String JOGADORES = "jogadores";
	private static final String NOME = "nome";
	private static final String NUMERO_JOGADOR = "numero";

	private SpecificationTime() {
	}

	public static Specification<TimeEntity> findByCriteria(RequestTimeFilterDTO filter) {
		return new Specification<TimeEntity>() {

			private static final long serialVersionUID = -7865501308668909780L;

			@Override
			public Predicate toPredicate(Root<TimeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				SetJoin<TimeEntity, JogadorEntity> joinJogadores = root.joinSet(JOGADORES, JoinType.LEFT);
				
				if (StringUtils.isNotEmpty(filter.getTimeNome())) {
					predicates.add(cb.equal(root.get(NOME), filter.getTimeNome()));
				}

				if (StringUtils.isNotEmpty(filter.getJogadorNome())) {
					predicates.add(cb.equal(joinJogadores.get(NOME), filter.getJogadorNome()));
				}

				query.orderBy(cb.asc(root.get(NUMERO_JOGADOR)));
				query.distinct(true);

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};
	}
	
}

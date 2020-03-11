package br.com.oracle.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.RequestFilterDTO;
import br.com.oracle.crud.dto.ResponseFilterDTO;
import br.com.oracle.crud.dto.RodadaDTO;
import br.com.oracle.crud.entity.RodadaEntity;
import br.com.oracle.crud.repository.RodadaRepository;
import br.com.oracle.crud.service.specification.SpecificationFilter;

@Service
public class RodadaService extends BaseService<RodadaEntity, RodadaDTO> {

	@Autowired
	private RodadaRepository repository;

	public ResponseFilterDTO<RodadaEntity> findByFilter(RequestFilterDTO filter) {
		return mountResponsefilter(repository
				.findAll(SpecificationFilter.findByCriteria(filter),
						PageRequest.of(filter.getSkip(), filter.getTop(), Direction.valueOf(ORDER_ASC), ORDER_BY_ID)));
	}
	
	@Override
	public Class<RodadaDTO> getClassDtoClass() {
		return RodadaDTO.class;
	}

	@Override
	public Class<RodadaEntity> getClassEntityClass() {
		return RodadaEntity.class;
	}

}

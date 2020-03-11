package br.com.oracle.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.RequestTimeFilterDTO;
import br.com.oracle.crud.dto.TimeDTO;
import br.com.oracle.crud.entity.TimeEntity;
import br.com.oracle.crud.repository.TimeRepository;
import br.com.oracle.crud.service.specification.SpecificationTime;

@Service
public class TimeService extends BaseService<TimeEntity, TimeDTO> {
	
	@Autowired
	private TimeRepository repository;

	public List<TimeDTO> findByFilter(RequestTimeFilterDTO filter) {
		return mountListEntity(repository
				.findAll(SpecificationTime.findByCriteria(filter),
						PageRequest.of(filter.getSkip(), filter.getTop(), Direction.valueOf(ORDER_ASC), ORDER_BY_ID))
				.getContent());
	}
	
	@Override
	public Class<TimeDTO> getClassDtoClass() {
		return TimeDTO.class;
	}

	@Override
	public Class<TimeEntity> getClassEntityClass() {
		return TimeEntity.class;
	}

}

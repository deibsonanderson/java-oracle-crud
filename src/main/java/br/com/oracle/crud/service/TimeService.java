package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.TimeDTO;
import br.com.oracle.crud.entity.TimeEntity;

@Service
public class TimeService extends BaseService<TimeEntity, TimeDTO> {
	
	@Override
	public Class<TimeDTO> getClassDtoClass() {
		return TimeDTO.class;
	}

	@Override
	public Class<TimeEntity> getClassEntityClass() {
		return TimeEntity.class;
	}

}

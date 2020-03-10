package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.RodadaDTO;
import br.com.oracle.crud.entity.RodadaEntity;

@Service
public class RodadaService extends BaseService<RodadaEntity, RodadaDTO> {

	@Override
	public Class<RodadaDTO> getClassDtoClass() {
		return RodadaDTO.class;
	}

	@Override
	public Class<RodadaEntity> getClassEntityClass() {
		return RodadaEntity.class;
	}

}

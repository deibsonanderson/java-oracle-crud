package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.CampoDTO;
import br.com.oracle.crud.entity.CampoEntity;

@Service
public class CampoService extends BaseService<CampoEntity, CampoDTO> {

	@Override
	public Class<CampoDTO> getClassDtoClass() {
		return CampoDTO.class;
	}

	@Override
	public Class<CampoEntity> getClassEntityClass() {
		return CampoEntity.class;
	}

}

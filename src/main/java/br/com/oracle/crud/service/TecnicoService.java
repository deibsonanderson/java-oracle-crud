package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.TecnicoDTO;
import br.com.oracle.crud.entity.TecnicoEntity;

@Service
public class TecnicoService extends BaseService<TecnicoEntity, TecnicoDTO> {

	@Override
	public Class<TecnicoDTO> getClassDtoClass() {
		return TecnicoDTO.class;
	}

	@Override
	public Class<TecnicoEntity> getClassEntityClass() {
		return TecnicoEntity.class;
	}

}

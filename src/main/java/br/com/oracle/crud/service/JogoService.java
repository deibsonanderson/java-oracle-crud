package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.JogoDTO;
import br.com.oracle.crud.entity.JogoEntity;

@Service
public class JogoService extends BaseService<JogoEntity, JogoDTO> {

	@Override
	public Class<JogoDTO> getClassDtoClass() {
		return JogoDTO.class;
	}

	@Override
	public Class<JogoEntity> getClassEntityClass() {
		return JogoEntity.class;
	}

}

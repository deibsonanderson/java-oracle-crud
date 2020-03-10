package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.JuizDTO;
import br.com.oracle.crud.entity.JuizEntity;

@Service
public class JuizService extends BaseService<JuizEntity, JuizDTO> {

	@Override
	public Class<JuizDTO> getClassDtoClass() {
		return JuizDTO.class;
	}

	@Override
	public Class<JuizEntity> getClassEntityClass() {
		return JuizEntity.class;
	}

}

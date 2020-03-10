package br.com.oracle.crud.service;

import org.springframework.stereotype.Service;

import br.com.oracle.crud.dto.JogadorDTO;
import br.com.oracle.crud.entity.JogadorEntity;

@Service
public class JogadorService extends BaseService<JogadorEntity, JogadorDTO> {

	@Override
	public Class<JogadorDTO> getClassDtoClass() {
		return JogadorDTO.class;
	}

	@Override
	public Class<JogadorEntity> getClassEntityClass() {
		return JogadorEntity.class;
	}

}

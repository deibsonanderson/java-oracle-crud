package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.RodadaDTO;
import br.com.oracle.crud.entity.RodadaEntity;

@RestController
@RequestMapping("/rodada")
public class RodadaController  extends BaseController<RodadaEntity, RodadaDTO> {

}

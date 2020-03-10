package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.CampoDTO;
import br.com.oracle.crud.entity.CampoEntity;

@RestController
@RequestMapping("/campo")
public class CampoController  extends BaseController<CampoEntity, CampoDTO> {

}

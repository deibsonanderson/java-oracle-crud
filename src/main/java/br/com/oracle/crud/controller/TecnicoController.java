package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.TecnicoDTO;
import br.com.oracle.crud.entity.TecnicoEntity;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController extends BaseController<TecnicoEntity, TecnicoDTO> {

}

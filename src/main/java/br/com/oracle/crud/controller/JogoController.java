package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.JogoDTO;
import br.com.oracle.crud.entity.JogoEntity;

@RestController
@RequestMapping("/jogo")
public class JogoController  extends BaseController<JogoEntity, JogoDTO> {

}

package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.JogadorDTO;
import br.com.oracle.crud.entity.JogadorEntity;

@RestController
@RequestMapping("/jogador")
public class JogadorController  extends BaseController<JogadorEntity, JogadorDTO> {

}

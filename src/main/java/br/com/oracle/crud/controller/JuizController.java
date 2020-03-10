package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.JuizDTO;
import br.com.oracle.crud.entity.JuizEntity;

@RestController
@RequestMapping("/juiz")
public class JuizController  extends BaseController<JuizEntity, JuizDTO> {

}

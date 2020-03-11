package br.com.oracle.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oracle.crud.dto.TimeDTO;
import br.com.oracle.crud.entity.TimeEntity;

@RestController
@RequestMapping("/time")
public class TimeController  extends BaseController<TimeEntity, TimeDTO> {

}

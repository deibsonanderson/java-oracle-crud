package br.com.oracle.crud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.oracle.crud.service.BaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseController<E, D> {

	@Autowired
	protected BaseService<E, D> service;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<List<D>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<D> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<D> create(@RequestBody D d) {
		return ResponseEntity.ok(service.create(d));
	}

	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<D> update(@RequestBody D d) {
		return ResponseEntity.ok(service.update(d));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<Void> remove(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@SuppressWarnings("deprecation")
	protected Date getFormatedDate(String strDate, boolean isFinished) {
		Date date = null;
		try {
			if (StringUtils.isNotEmpty(strDate)) {
				date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
				if (isFinished) {
					date.setHours(23);
					date.setMinutes(59);
					date.setSeconds(59);
				}
			}
		} catch (Exception ex) {
			log.error("error during converted date message:{}", ex.getMessage(), ex);
		}
		return date;
	}
}

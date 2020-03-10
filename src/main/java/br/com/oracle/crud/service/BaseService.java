package br.com.oracle.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

public abstract class BaseService<E, D> {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	protected JpaRepository<E, Integer> jpa;

	public D create(D d) {
		return modelMapper.map(jpa.save(modelMapper.map(d, getClassEntityClass())), getClassDtoClass());
	}
	
	public D update(D d) {
		return modelMapper.map(jpa.save(modelMapper.map(d, getClassEntityClass())), getClassDtoClass());
	}
	
	public void deleteById(Integer id) {
		jpa.deleteById(id);
	}
	
	public D findById(Integer id) {
		return modelMapper.map(jpa.findById(id), getClassDtoClass());
	}

	
	public List<D> findAll() {
		List<D> dtos = new ArrayList<>();
		List<E> entitys = jpa.findAll();
		if (!CollectionUtils.isEmpty(entitys)) {
			for (E entity : entitys) {
				dtos.add(modelMapper.map(entity, getClassDtoClass()));
			}
		}
		return dtos;
	}

	public abstract Class<D> getClassDtoClass();

	public abstract Class<E> getClassEntityClass();

}
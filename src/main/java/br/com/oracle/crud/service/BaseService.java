package br.com.oracle.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

public abstract class BaseService<E, D> {

	protected static final String ORDER_ASC = "ASC";

	protected static final String ORDER_BY_ID = "id";
	
	@Autowired
	protected ModelMapper modelMapper;

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
		return mountListEntity(jpa.findAll());
	}
	
	public List<D> mountListEntity(List<E> entitys){
		List<D> dtos = new ArrayList<>();
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

package br.com.oracle.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import br.com.oracle.crud.dto.ResponseFilterDTO;

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
	
	protected List<D> mountListEntity(List<E> entitys){
		List<D> dtos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(entitys)) {
			for (E entity : entitys) {
				dtos.add(modelMapper.map(entity, getClassDtoClass()));
			}
		}
		return dtos;
	}

	protected abstract Class<D> getClassDtoClass();

	protected abstract Class<E> getClassEntityClass();
	
	protected ResponseFilterDTO<E> mountResponsefilter(Page<E> page){
		ResponseFilterDTO<E> filter = new ResponseFilterDTO<>();
		filter.setNumber(page.getNumber());
		filter.setNumberOfElements(page.getNumberOfElements());
		filter.setSize(page.getSize());
		filter.setTotalPages(page.getTotalPages());
		filter.setTotalElements(page.getTotalElements());
		filter.setFirst(page.isFirst());
		filter.setLast(page.isLast());
		filter.setContent(page.getContent());
		return filter;
	}
	
}

package br.com.oracle.crud.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseFilterDTO<E> {

	private Integer number;
	private Integer numberOfElements;
	private Integer size;
	private Integer totalPages;
	private Long totalElements;
	private Boolean first;
	private Boolean last;
	private List<E> content;

}

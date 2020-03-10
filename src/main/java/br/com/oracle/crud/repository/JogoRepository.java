package br.com.oracle.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oracle.crud.entity.JogoEntity;

@Repository
public interface JogoRepository extends JpaRepository<JogoEntity, Integer> {

}

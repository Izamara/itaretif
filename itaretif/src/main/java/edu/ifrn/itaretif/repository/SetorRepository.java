package edu.ifrn.itaretif.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ifrn.itaretif.models.Setor;

public interface SetorRepository extends CrudRepository<Setor, Long>{
	
	Setor findById(long id);
	
	Iterable<Setor> findAllById(long id);
}


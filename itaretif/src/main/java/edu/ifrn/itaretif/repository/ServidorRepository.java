package edu.ifrn.itaretif.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ifrn.itaretif.models.Servidor;


	public interface ServidorRepository extends CrudRepository<Servidor, Long>{
	
		Servidor findById(long id);
		
		Iterable<Servidor> findAllById(long id);
	
}


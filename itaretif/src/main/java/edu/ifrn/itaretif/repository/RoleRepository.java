package edu.ifrn.itaretif.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ifrn.itaretif.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	//Role findByNomeRole(String nome);
	
	//Iterable<Role> findAllByOrderByNomeAsc();

}

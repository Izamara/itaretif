package edu.ifrn.itaretif.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ifrn.itaretif.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByLogin(String login); 
	


}

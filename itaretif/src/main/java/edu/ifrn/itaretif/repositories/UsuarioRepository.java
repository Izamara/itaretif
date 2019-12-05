package edu.ifrn.itaretif.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ifrn.itaretif.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

//	Usuario finByMatricula(String matricula);
	
//	Iterable<Usuario> findByNomeContaining(String nome);
	
}

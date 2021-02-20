package edu.ifrn.itaretif.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ifrn.itaretif.models.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, String> {

	Comentario findByCodigo(Long codigo);
}

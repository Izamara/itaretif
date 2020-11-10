package edu.ifrn.itaretif.service;

import java.util.List;

import edu.ifrn.itaretif.models.Projeto;

public interface ProjetoService {

	List<Projeto> findAll();
	Projeto findById(long id);
	Projeto save(Projeto projeto);
	
}

package edu.ifrn.itaretif.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrn.itaretif.models.Projeto;
import edu.ifrn.itaretif.repository.ProjetoRepository;
import edu.ifrn.itaretif.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Override
	public List<Projeto> findAll() {
		return projetoRepository.findAll();
	}

	@Override
	public Projeto findById(long id) {
		return projetoRepository.findById(id).get();
	}

	@Override
	public Projeto save(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	
	@Override
	public void delete(Projeto projeto) {
		projetoRepository.delete(projeto);
	}
	
	
	@Override
	public Projeto edit(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

}


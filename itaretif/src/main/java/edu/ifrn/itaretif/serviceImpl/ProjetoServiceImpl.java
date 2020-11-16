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
	ProjetoRepository ProjetoRepository;
	
	@Override
	public List<Projeto> findAll() {
		return ProjetoRepository.findAll();
	}

	@Override
	public Projeto findById(long id) {
		return ProjetoRepository.findById(id).get();
	}

	@Override
	public Projeto save(Projeto post) {
		return ProjetoRepository.save(post);
	}

}


package edu.ifrn.itaretif.utils;

import edu.ifrn.itaretif.repository.ProjetoRepository;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ifrn.itaretif.models.Projeto;

@Component
public class DummyData {


	 @Autowired
	 ProjetoRepository ProjetoRepository;

	    //@PostConstruct
	    public void savePosts(){

	        List<Projeto> postList = new ArrayList<>();
	        Projeto post1 = new Projeto();
	        post1.setAutor("Ana Sara");
	        post1.setTitulo("Batatinha");
	        post1.setDescrição("Batatinha quando nasce, espalha a rama pelo chão. Menininha quando dorme, põe a mão no coração.");

	        Projeto post2 = new Projeto();
	        post2.setAutor("Nanika");
	        post2.setTitulo("Batatinha");
	        post2.setDescrição("Batatinha quando nasce, espalha a rama pelo chão. Menininha quando dorme, põe a mão no coração.");

	        postList.add(post1);
	        postList.add(post2);

	        for(Projeto post: postList){
	            Projeto postSaved = ProjetoRepository.save(post);
	            System.out.println(postSaved.getId());
	        }
	    }
	}
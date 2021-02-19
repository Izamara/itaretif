package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Comentario;
import edu.ifrn.itaretif.models.Setor;
import edu.ifrn.itaretif.repositories.ComentarioRepository;
import edu.ifrn.itaretif.repository.SetorRepository;

@Controller
public class ControllerSite {
	
	@Autowired
	private SetorRepository sr;

	
	@RequestMapping("/")
	public String index() {
		return "inicio";
	}
	
	@RequestMapping(value="/campus", method= RequestMethod.GET)
	public ModelAndView listarSetores(){
    	ModelAndView mv = new ModelAndView("o campus");
    	Iterable<Setor> setores = sr.findAll();
    	mv.addObject("setores", setores);
    	return mv;
    	
	}

	
	@RequestMapping("/regras")
	public String regras() {
		return "regras";
	}
	
	@RequestMapping("/lajes")
	public String lajes() {
		return "lajes";
	}
	
	@RequestMapping("/mapeamento")
	public String mapeamento() {
		return "mapeamento";
	}
	
	@RequestMapping("/cadastro")
	public String cadastroPagina(){
		return "paginaDeCadastro";
	}

//	@RequestMapping("/sobre")
//	public String sobre() {
//		return "sobre";
//	}
	
	@RequestMapping("/planta1")
	public String palnta1() {
		return "planta1";
	}
	
	@RequestMapping("/planta2")
	public String palnta2() {
		return "planta2";
	}
	
	@RequestMapping("/planta3")
	public String palnta3() {
		return "planta3";
	}
	
	@RequestMapping("/planta4")
	public String palnta4() {
		return "planta4";
	}
	
	@RequestMapping("/planta5")
	public String palnta5() {
		return "planta5";
	}
	
	@RequestMapping("/planta6")
	public String palnta6() {
		return "planta6";
	}
	
	@RequestMapping("/planta7")
	public String palnta7() {
		return "planta7";
	}
	
}

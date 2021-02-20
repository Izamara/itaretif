package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Comentario;
import edu.ifrn.itaretif.models.Setor;
import edu.ifrn.itaretif.repository.ComentarioRepository;
import edu.ifrn.itaretif.repository.SetorRepository;

@Controller
public class PortalController {
	
	@Autowired
	private SetorRepository sr;

	
	@RequestMapping("/")
	public String index() {
		return "/portal/inicio";
	}
	
	@RequestMapping(value="/campus", method= RequestMethod.GET)
	public ModelAndView listarSetores(){
    	ModelAndView mv = new ModelAndView("/portal/o campus");
    	Iterable<Setor> setores = sr.findAll();
    	mv.addObject("setores", setores);
    	return mv;
    	
	}

	
	@RequestMapping("/regras")
	public String regras() {
		return "/portal/regras";
	}
	
	@RequestMapping("/lajes")
	public String lajes() {
		return "/portal/lajes";
	}
	
	@RequestMapping("/mapeamento")
	public String mapeamento() {
		return "/portal/mapeamento";
	}
	
	@RequestMapping("/cadastro")
	public String cadastroPagina(){
		return "/cadastro/paginaDeCadastro";
	}

//	@RequestMapping("/sobre")
//	public String sobre() {
//		return "sobre";
//	}
	
	@RequestMapping("/planta1")
	public String palnta1() {
		return "/portal/planta1";
	}
	
	@RequestMapping("/planta2")
	public String palnta2() {
		return "/portal/planta2";
	}
	
	@RequestMapping("/planta3")
	public String palnta3() {
		return "/portal/planta3";
	}
	
	@RequestMapping("/planta4")
	public String palnta4() {
		return "/portal/planta4";
	}
	
	@RequestMapping("/planta5")
	public String palnta5() {
		return "/portal/planta5";
	}
	
	@RequestMapping("/planta6")
	public String palnta6() {
		return "/portal/planta6";
	}
	
	@RequestMapping("/planta7")
	public String palnta7() {
		return "/portal/planta7";
	}
	
}

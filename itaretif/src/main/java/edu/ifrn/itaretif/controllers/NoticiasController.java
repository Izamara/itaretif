package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Noticias;
import edu.ifrn.itaretif.repositories.NoticiasRepository;

@Controller
public class NoticiasController {
	
	@Autowired
	private NoticiasRepository er;

//	@RequestMapping(value="/cadastrarNoticia", method=RequestMethod.GET)
	@GetMapping("/cadastrarNoticia")
	public String form() {
		return "formNoticias";
	}


	@PostMapping("/cadastrarNoticia")
	public String form(Noticias noticia) {
		
		er.save(noticia);
		return "redirect:/cadastrarNoticia";
	}
	
	@RequestMapping("/noticias")
	public ModelAndView listaNoticias() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Noticias> noticias = er.findAll();
		mv.addObject("noticia", noticias);
		return mv;
	
	}
}
  
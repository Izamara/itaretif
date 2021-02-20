package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Comentario;
import edu.ifrn.itaretif.repository.ComentarioRepository;

@Controller
public class ComentarioController {

	@Autowired
	private ComentarioRepository cr;


	@PostMapping("/sobre")
	public String form(Comentario comentario) {
		
		cr.save(comentario);
		return "redirect:/sobre";
	}
	
	@GetMapping("/sobre")
	public ModelAndView listaNoticias() {
		ModelAndView mv = new ModelAndView("/portal/Sobre");
		Iterable<Comentario> comentario = cr.findAll();
		mv.addObject("comentarios", comentario);
		return mv;
	
	}

}

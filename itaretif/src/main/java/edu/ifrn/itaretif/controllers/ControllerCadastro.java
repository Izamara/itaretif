package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.UsuarioRepository;



@Controller
public class ControllerCadastro {
	
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastroLogin(){
		return "cadastro";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String salvarCadastro(Usuario usuario){
		
		ur.save(usuario);
		
		return "redirect:/cadastrar";
	}

}

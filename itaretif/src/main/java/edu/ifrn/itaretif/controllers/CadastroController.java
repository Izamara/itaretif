package edu.ifrn.itaretif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroController {
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
		public String formCadastro(){
		
		return "/cadastro/paginaDeCadastro";
	}

	
}

package edu.ifrn.itaretif.controllers;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifrn.itaretif.models.Role;
import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.RoleRepository;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private RoleRepository rr;

	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
		public ModelAndView formCadastro(){
		ModelAndView mve = new ModelAndView("paginaDeCadastro");
		
		return mve;
	}

	
}

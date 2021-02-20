package edu.ifrn.itaretif.controllers;


import java.util.ArrayList;

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
public class AlunoController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private RoleRepository rr;
	
	
	@RequestMapping(value="/cadastroAluno", method=RequestMethod.GET)
	public String cadastroUsuario(){
		return "cadastro/cadastroAluno";
	}
	
	@RequestMapping(value="/cadastroAluno", method=RequestMethod.POST)
	public String salvarAluno(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroAluno";
		}
		
		ArrayList<Role> roles = new ArrayList<Role>();
		Role role= rr.findByNomeRole("ROLE_ALUNO"); 
		roles.add(role);

		usuario.setRoles(roles);
		
		usuario.setSenha (new BCryptPasswordEncoder().encode (usuario.getSenha()));
		
		ur.save(usuario);
		attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
		return "redirect:/cadastroAluno";
	}	

}

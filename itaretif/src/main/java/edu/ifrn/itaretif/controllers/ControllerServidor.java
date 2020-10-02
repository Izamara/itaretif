package edu.ifrn.itaretif.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifrn.itaretif.models.Role;
import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.RoleRepository;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Controller
public class ControllerServidor {
	
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private RoleRepository rr;
	
	@RequestMapping(value="/serv/inicio", method=RequestMethod.GET)
		public String servidor(){
		return "inicioServidor";
	}
	
	@RequestMapping(value="/cadastroServ", method=RequestMethod.GET)
		public String cadastroServidor(){
		return "cadastroServ";
	}
	
	@RequestMapping(value="/cadastroServ", method=RequestMethod.POST)
	public String salvarServ(Usuario usuario){
		
		ArrayList<Role> roles = new ArrayList<Role>();
		Role role= rr.findByNomeRole("ROLE_SERVIDOR"); 
		roles.add(role);

		usuario.setRoles(roles);
		
		usuario.setSenha (new BCryptPasswordEncoder().encode (usuario.getSenha()));
	
		ur.save(usuario);
		
	return "redirect:/cadastroServ";
	}

}

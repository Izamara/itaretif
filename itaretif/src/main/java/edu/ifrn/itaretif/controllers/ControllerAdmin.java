package edu.ifrn.itaretif.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifrn.itaretif.models.Role;
import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.RoleRepository;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Controller
public class ControllerAdmin {
	
		@Autowired
		private UsuarioRepository ur;
		
		@Autowired
		private RoleRepository rr;
		
		@RequestMapping(value="/admin/inicio", method=RequestMethod.GET)
			public String inicio(){
			return "inicioAdmin";
		}
		
		@RequestMapping(value="/admin/inicio", method=RequestMethod.POST)
		public String salvarAdmin(Usuario usuario){
			
			ArrayList<Role> roles = new ArrayList<Role>();
			Role role= rr.findByNomeRole("ROLE_ADMIN"); 
			roles.add(role);

			usuario.setRoles(roles);
			
			usuario.setSenha (new BCryptPasswordEncoder().encode (usuario.getSenha()));
			
			ur.save(usuario);
			
		return "redirect:/admin/inicio";
	}
		
		
}

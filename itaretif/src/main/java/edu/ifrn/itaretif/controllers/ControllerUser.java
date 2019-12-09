package edu.ifrn.itaretif.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ifrn.itaretif.models.Role;
import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.RoleRepository;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Controller
public class ControllerUser {
	
		@Autowired
		private UsuarioRepository ur;
		@Autowired
		private RoleRepository rr;
	
		@GetMapping("/cadastroAdmin")
		public String formCadastro() {
			return "inicioAdmin";
		}
	
		@PostMapping("/cadastroAdmin")
		public String salvar(Usuario usuario) {
		
		ArrayList<Role> roles = new ArrayList<Role>();
		Role role = rr.findByNomeRole("ROLE_ADMIN"); 
		roles.add(role);

		usuario.setRoles(roles);

		/* Criptografando senha */
	    usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

		ur.save(usuario);

		return "redirect:/inicioAdmin";
	}

}

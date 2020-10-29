package edu.ifrn.itaretif.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.events.Event;

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
		public String inicioAdmin(){
			return "inicioAdmin";
		}
		
		@RequestMapping(value="/admin/inicio", method=RequestMethod.POST)
		public String salvarAdmin(Usuario usuario, BindingResult result, RedirectAttributes attributes){
			
			if(result.hasErrors()){
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/cadastroAluno";
			}
			
			ArrayList<Role> roles = new ArrayList<Role>();
			Role role= rr.findByNomeRole("ROLE_ADMIN"); 
			roles.add(role);

			usuario.setRoles(roles);
			
			usuario.setSenha (new BCryptPasswordEncoder().encode (usuario.getSenha()));
			
			ur.save(usuario);
			attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
		return "redirect:/admin/inicio";
	}
		
		@RequestMapping(value="/admin/listar", method=RequestMethod.GET)
			public ModelAndView ListaDeUsuarios(){
			ModelAndView mv = new ModelAndView("lista");
			Iterable<Usuario> usuarios = ur.findAll();
			mv.addObject("usuarios", usuarios);
			return mv;
	}
		
		
		@RequestMapping(value="/editarUsuario/{matricula}", method=RequestMethod.GET)
			public ModelAndView alterarUsuario(@PathVariable("matricula") String matricula){
				ModelAndView mv = new ModelAndView("formEdit");
				Usuario usuario = ur.findByMatricula(matricula);
				mv.addObject("usuario", usuario);
				return mv;
		}
		
		
		@RequestMapping(value="/editar", method=RequestMethod.POST)
			public ModelAndView alterarUsuario(Usuario usuario, String matricula){
				ModelAndView mv = new ModelAndView();
				
				usuario.setSenha (new BCryptPasswordEncoder().encode (usuario.getSenha()));
				
				Usuario existent = ur.findByMatricula(matricula);
				BeanUtils.copyProperties(usuario , existent, "id", "roles");
				
				ur.save(existent);
				
				mv.setViewName("redirect:/admin/listar");
				return mv;
	}
		
		
		@RequestMapping("/deletar")
		public String deletarUsuario(String matricula){
			Usuario usuario = ur.findByMatricula(matricula);
			ur.delete(usuario);
			return "redirect:/editar";
		}
		
		
}

package edu.ifrn.itaretif.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Component
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException { 
		Usuario usuario = ur.findByMatricula(matricula);
		
		System.out.println(usuario);
		
		if (usuario == null) {
			 throw new UsernameNotFoundException("Este usuário não foi encontrado!");
		}
		return usuario;

	}

}

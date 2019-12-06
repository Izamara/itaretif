package edu.ifrn.itaretif.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import edu.ifrn.itaretif.models.Usuario;
import edu.ifrn.itaretif.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Usuario usuario = ur.findByMatricula(login);
		if (usuario == null) {

			throw new UsernameNotFoundException("Este usuário não está cadastrado! Cadastre-se caso queira acessar a página.");

		}
		return usuario;

	}

}

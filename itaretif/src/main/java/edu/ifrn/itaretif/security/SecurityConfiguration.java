package edu.ifrn.itaretif.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration {
	
	@Autowired
	private ImplementsUserDetailsService detailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	    
		builder.userDetailsService(detailsService)	.passwordEncoder(new BCryptPasswordEncoder());
	    	
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		builder
//			.inMemoryAuthentication()
//			.withUser("joao").password(encoder.encode("123")).roles("ADMIN", "USUARIO")
//			.and()
//			.withUser("jose").password(encoder.encode("123")).roles("USUARIO", "AVALIADOR");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}

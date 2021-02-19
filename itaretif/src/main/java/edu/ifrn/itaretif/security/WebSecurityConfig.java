package edu.ifrn.itaretif.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests()
				.antMatchers("/*").permitAll()
				.antMatchers("/projeto/{id}").permitAll()
				/*.antMatchers("/sobre/comentar").hasRole("ALUNO")*/
				.antMatchers("/serv/**").hasRole("SERVIDOR")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/deletarProjeto/{id}").hasAnyRole("SERVIDOR", "ADMIN")
				.antMatchers("/editarProjeto/{id}").hasRole("SERVIDOR")
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/estilo/**", "/img/**");
	}

}

package edu.ifrn.itaretif.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/*").permitAll()
		.antMatchers("/serv/**").hasRole("SERVIDOR")
		.antMatchers("/admin/**").hasRole("ADMIN") 
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutSuccessUrl("/login?logout").permitAll();

	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService)
//		
//		.passwordEncoder(new BCryptPasswordEncoder());
//	}
//	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/estilo/**", "/img/**");
	}

}

package edu.ifrn.itaretif.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//http.
		//authorizeRequests()
			//.antMatchers("/*").permitAll() 
			//.antMatchers("/inicioServidor/**").hasRole("SERVIDOR")
			//.antMatchers("/admin/**").hasRole("ADMIN")
			//.anyRequest()
			//.authenticated()
		//.and()
		//.formLogin()
			//.loginPage("/login")
			//.permitAll()
		//.and()
		//.logout()
			//.logoutSuccessUrl("/login?logout")
			//.permitAll();

	}

}

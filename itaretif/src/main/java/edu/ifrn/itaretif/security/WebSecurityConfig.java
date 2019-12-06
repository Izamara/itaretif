package edu.ifrn.itaretif.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/*").permitAll();
//
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/*").permitAll()
//				.antMatchers(HttpMethod.GET, "/areaDoAdmin/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.POST, "/areaDoAdmin/**").hasRole("ADMIN").anyRequest().authenticated().and()
//				.formLogin().loginPage("/login").permitAll().and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//
//	}

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//    	   auth.inMemoryAuthentication()
//          .withUser("Usuario").password("123").roles("ADMIN");
//
//}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/**");

	}

}

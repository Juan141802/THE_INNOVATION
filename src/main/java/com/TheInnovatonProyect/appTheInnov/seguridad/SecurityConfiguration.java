package com.TheInnovatonProyect.appTheInnov.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.TheInnovatonProyect.appTheInnov.facade.IUsuariosSesion;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private IUsuariosSesion iusuariosesion;
	
	//Se indica como se codificará la contraseña
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Sirve para obtener o mostrar unos datos de un usuario
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(iusuariosesion);;
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	//Validará los datos que se obtienen son válidos
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registro**",
				"/js**",
				"/css**",
				"/img**",
				"/video/**",
				"/bootstrap/**",
				"/fontawesome/**",
				"/datatables/**",
				"/JQuery/**").permitAll().antMatchers().hasRole("Cliente")
		.antMatchers("/ins/**").hasAnyAuthority("Instructor","Administrador")
		.antMatchers("/admin/**").hasAuthority("Administrador")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll().and().exceptionHandling().accessDeniedPage("/error");
		
	}

}

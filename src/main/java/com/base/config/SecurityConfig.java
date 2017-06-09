package com.base.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/").and().rememberMe()
//				.tokenRepository(new InMemoryTokenRepositoryImpl()).tokenValiditySeconds(2419200).key("baseKey").and()
//				.httpBasic().realmName("base").and().authorizeRequests().antMatchers("/").authenticated()
//				.antMatchers("/test/**").authenticated().antMatchers(HttpMethod.POST, "/spittles").authenticated()
//				.anyRequest().permitAll();
		http.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}

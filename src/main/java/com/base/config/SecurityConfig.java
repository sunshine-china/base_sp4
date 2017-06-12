package com.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER").and().withUser("admin")
				.password("123456").roles("ADMIN").and().withUser("test").password("123456").roles("TEST");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 暂时取消CSRF保护
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);
		http.authorizeRequests().antMatchers("/resources/**").permitAll().and().formLogin()
				./* loginPage("/login"). */and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").and().csrf()
				.disable().logout().deleteCookies("JSESSIONID").and().authorizeRequests().antMatchers("/login")
				.permitAll().anyRequest().authenticated().and().headers().xssProtection().xssProtectionEnabled(true)
				.block(false).and().frameOptions().sameOrigin();

		// 最大登陆次数为1,自动注销前一次登陆
		http.sessionManagement().maximumSessions(1);

	}

	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();
	}

}

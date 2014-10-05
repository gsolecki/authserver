package org.springframework.security.oauth.examples.sparklr.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @formatter:off


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Configuration
	public static class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
				.withUser("marissa").password("koala").roles("USER")
				.and()
				.withUser("paul").password("emu").roles("USER");
		}

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/webjars/**");
	    }

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
				.antMatchers("/login.jsp").permitAll()
				.anyRequest().hasRole("USER")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/login.jsp?authorization_error=true")
				.and()
			.logout()
	            .logoutSuccessUrl("/login.jsp")
				.logoutUrl("/logout.do")
				.and()
			.formLogin()
	            .loginPage("/login.jsp")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.failureUrl("/login.jsp?authentication_error=true")
				.loginProcessingUrl("/login.do");
		}
	}
}
// @formatter:on

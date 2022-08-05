package com.capgemini.manageuserservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.capgemini.manageuserservice.service.impl.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		// checking the password the userdetails getting from above line and then
		// returning result
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	// Configure method to authenticate the auth request
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// for authentication from database we use (authenticationProvider)
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// IMP for Previous Implementation
		http.authorizeRequests().antMatchers("/owner/**").hasRole("OWNER").antMatchers("/user/**").hasRole("user")
		.antMatchers("/ManageLogin/**").hasAnyRole("OWNER", "MANAGER", "RECEPTIONIST").and().formLogin().disable()
		.httpBasic().and().csrf().disable();
		http.cors().disable();
//		http.authorizeRequests().antMatchers("/owner/**").hasRole("OWNER").antMatchers("/user/**").hasRole("user")
//				.antMatchers("/ManageLogin/**").hasAnyRole("OWNER", "MANAGER", "RECEPTIONIST").and().formLogin()
//				.and().csrf().disable();
//		http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();     
		// TO add user without login 

	}

}
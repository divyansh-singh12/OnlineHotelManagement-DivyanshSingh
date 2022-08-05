package com.capgemini.manageuserservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.capgemini.manageuserservice.config.CustomUserDetails;
import com.capgemini.manageuserservice.entity.User;
import com.capgemini.manageuserservice.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private static String userRole;

	@Override
	// Taking the given user from the database and provide it for further
	// authentication
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetching user from database
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User cant be found");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		setUserRole(user.getRole());

		return customUserDetails;
	}

	public static String getUserRole() {
		return userRole;
	}

	public static void setUserRole(String userRole) {
		UserDetailsServiceImpl.userRole = userRole;
	}

}
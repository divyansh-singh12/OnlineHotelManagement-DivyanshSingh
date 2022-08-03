package com.capgemini.springcloudgatewayserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.springcloudgatewayserver.config.CustomUserDetails;
import com.capgemini.springcloudgatewayserver.model.UserModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetching user from manageuserservice

		ResponseEntity<UserModel> user = restTemplate
				.getForEntity("http://localhost:8089/ManageUser/checkuser/{username}", UserModel.class, username);
		System.out.println(user.getBody().getPassword());
		UserModel userModel = user.getBody();
		if (userModel == null) {
			throw new UsernameNotFoundException("User cant be found");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(userModel);

		return customUserDetails;
	}

}
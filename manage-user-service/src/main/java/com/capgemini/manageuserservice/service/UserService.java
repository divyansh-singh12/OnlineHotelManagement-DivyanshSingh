package com.capgemini.manageuserservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.manageuserservice.model.UserModel;

@Service
public interface UserService {
	public UserModel addUserService(UserModel user);

	public UserModel updateUserService(UserModel user);

	public String deleteUserService(String username);

}
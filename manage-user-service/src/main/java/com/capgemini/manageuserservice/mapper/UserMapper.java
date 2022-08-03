package com.capgemini.manageuserservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.manageuserservice.entity.User;
import com.capgemini.manageuserservice.model.UserModel;

@Component
public class UserMapper {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User mapDtoToEntity(UserModel user) {

		User userEntity = new User();
		userEntity.setUsername(user.getUsername());
		userEntity.setName(user.getName());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		// userEntity.setPassword(user.getPassword());
		userEntity.setRole(user.getRole());
		return userEntity;
	}

	public UserModel mapEntityToDto(User user) {

		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(user, userModel);
		return userModel;

	}

}
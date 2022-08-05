package com.capgemini.manageuserservice.service.impl;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.manageuserservice.entity.User;
import com.capgemini.manageuserservice.mapper.UserMapper;
import com.capgemini.manageuserservice.model.UserModel;
import com.capgemini.manageuserservice.repository.UserRepository;
import com.capgemini.manageuserservice.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserModel addUserService(UserModel user) {
		validateEntity(user);
		User userEntity = userRepository.save(userMapper.mapDtoToEntity(user));
		return userMapper.mapEntityToDto(userEntity);
	}

	public UserModel updateUserService(UserModel user) {
		User userEntity = userRepository.findByUsername(user.getUsername());
		userEntity.setUsername(user.getUsername());
		userEntity.setName(user.getName());
		// userEntity.setPassword(user.getPassword());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setRole(user.getRole());
		userEntity = userRepository.save(userEntity);
		return userMapper.mapEntityToDto(userEntity);
	}

	public String deleteUserService(String username) {
		try {
			userRepository.deleteById(username);
			return "Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't delete";
	}

	private void validateEntity(UserModel user) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<UserModel>> constraintViolations = validator.validate(user);

		for (ConstraintViolation<UserModel> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

}
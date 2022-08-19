package com.capgemini.manageuserservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.manageuserservice.model.JwtModel;

@Service
public interface JwtService {
	public String deleteJwt(int id);

	public String addJwt(JwtModel jwtModel);
	
	public String getJwt();

}

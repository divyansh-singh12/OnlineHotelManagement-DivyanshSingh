package com.capgemini.manageuserservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageuserservice.entity.Jwt;
import com.capgemini.manageuserservice.mapper.JwtMapper;
import com.capgemini.manageuserservice.model.JwtModel;
import com.capgemini.manageuserservice.repository.JwtRepository;
import com.capgemini.manageuserservice.service.JwtService;

@Component
public class JwtServiceImpl implements JwtService {
	@Autowired
	private JwtMapper jwtMapper;
	@Autowired
	private JwtRepository jwtRepository;

	@Override
	public String deleteJwt(int id) {
		try {
			jwtRepository.deleteById(id);
			return "Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't delete";
	}

	@Override
	public String addJwt(JwtModel jwtModel) {

		Jwt jwtEntity = jwtRepository.save(jwtMapper.mapDtoToEntity(jwtModel));
		String ss = jwtEntity.getJwt();
		return ss;
	}

	@Override
	public String getJwt() {

		Jwt jwtEntity = jwtRepository.findById(1);
		String ss = jwtEntity.getJwt();
		return ss;
	}

}

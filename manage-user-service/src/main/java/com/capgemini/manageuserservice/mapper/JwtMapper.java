package com.capgemini.manageuserservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.capgemini.manageuserservice.entity.Jwt;
import com.capgemini.manageuserservice.model.JwtModel;

@Component
public class JwtMapper {
	public Jwt mapDtoToEntity(JwtModel jwtmodel) {
		Jwt jwtEntity= new Jwt();
		jwtEntity.setId(jwtmodel.getId());
		jwtEntity.setJwt(jwtmodel.getJwt());
		return jwtEntity;
	}
	
	public JwtModel mapEntityToDto(Jwt jwt) {

		JwtModel jwtModel = new JwtModel();
		BeanUtils.copyProperties(jwt, jwtModel);
		return jwtModel;

	}

}

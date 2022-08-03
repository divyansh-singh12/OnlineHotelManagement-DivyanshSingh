package com.capgemini.manageuserservice.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderModel {
	private BCryptPasswordEncoder passwordEncoderr;

	public BCryptPasswordEncoder getPasswordEncoderr() {
		return passwordEncoderr;
	}

	public void setPasswordEncoderr(BCryptPasswordEncoder passwordEncoderr) {
		this.passwordEncoderr = passwordEncoderr;
	}

}

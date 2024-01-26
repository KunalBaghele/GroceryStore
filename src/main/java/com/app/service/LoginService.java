package com.app.service;

import com.app.models.Login;


public interface LoginService {
	
	Login validate(String email, String pwd);
}
	

package com.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Login;
import com.app.repository.LoginRepository;
import com.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository loginRepository;

	@Override
	public Login validate(String email, String pwd) {
		// TODO Auto-generated method stub
		Optional<Login> admin = loginRepository.findByEmail(email);
		System.out.println("from impl fetchin from repo "+admin);
		
		if (admin.isPresent() && admin.get().getPassword().equals(pwd)&& admin.get().getEmail().equals(email) ) {
			System.out.println("login Success");
			return admin.get();
		} else {
			System.out.println("Invalid Login");
			return null;
		}

	}
}

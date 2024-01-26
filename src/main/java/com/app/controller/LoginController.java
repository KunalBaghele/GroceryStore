package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.Login;
import com.app.repository.LoginRepository;
import com.app.serviceImpl.LoginServiceImpl;

@Controller
@RequestMapping("api/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    LoginRepository loginRepository;

    @GetMapping
    public ResponseEntity<Login> getAdminInfoByEmail(@RequestParam(name = "email") String email) {
        Optional<Login> admin = loginRepository.findByEmail(email);

        if (admin.isPresent()) {
            return new ResponseEntity<>(admin.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<Login> validateUser(@RequestBody Login loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Login admin = loginServiceImpl.validate(email, password);

        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

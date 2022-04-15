package com.cts.homeneeds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.homeneeds.models.UserAuthBean;
import com.cts.homeneeds.services.UserService;

@RestController
public class AuthController {
@Autowired
UserService userServ;

@PostMapping("/authenticate")
public String getToken(@RequestBody UserAuthBean user) {
	return userServ.createtoken(user);	
}

@PostMapping("/validate")
public boolean validateToken(@RequestBody String token) {
	System.out.println("validating");
	return userServ.validateToken(token);
}

@GetMapping(value="/addUser")
public UserAuthBean addUser(@RequestBody UserAuthBean newUser) {
	return userServ.addUser(newUser);
}



}

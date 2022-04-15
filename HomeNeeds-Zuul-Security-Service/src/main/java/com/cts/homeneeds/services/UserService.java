package com.cts.homeneeds.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.homeneeds.models.UserAuthBean;
import com.cts.homeneeds.repos.UserBeanRepo;
import com.cts.homeneeds.utils.JwtUtil;
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserBeanRepo userRepo;
	
	@Autowired
	private JwtUtil jwtUtilServ;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserAuthBean user=userRepo.findByUsername(username);
		
		return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
			

}
	
	public boolean validateToken(String token) {

		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7);
			String username = jwtUtilServ.extractUserName(token);
			UserDetails userDetails =loadUserByUsername(username);
			boolean flag = jwtUtilServ.validateToken(token, userDetails);
			if (flag == true) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public String createtoken(UserAuthBean user) {
		if (user != null && user.getPassword() != null && user.getUsername() != null) {
			
			UserAuthBean u = userRepo.findByUsernameAndPassword(user.getUsername().trim(), user.getPassword().trim());
			System.out.println(u);
			System.out.println("user above^^^");
			if (u != null) {
				return jwtUtilServ.generateToken(loadUserByUsername(u.getUsername()));
			}
		}
		return null;
	}
	
	
	
	
	
	public UserAuthBean addUser(UserAuthBean newUser) {
		return userRepo.save(newUser);
	}
	
}

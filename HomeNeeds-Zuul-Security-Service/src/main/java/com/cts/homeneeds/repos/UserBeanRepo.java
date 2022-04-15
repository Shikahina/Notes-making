package com.cts.homeneeds.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.homeneeds.models.UserAuthBean;

@Repository
public interface UserBeanRepo extends JpaRepository<UserAuthBean, Long>{
	
public UserAuthBean findByUsername(String username);
public UserAuthBean findByUsernameAndPassword(String username, String password);
}

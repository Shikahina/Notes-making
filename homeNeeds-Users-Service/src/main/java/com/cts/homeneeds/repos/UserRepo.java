package com.cts.homeneeds.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.homeneeds.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}

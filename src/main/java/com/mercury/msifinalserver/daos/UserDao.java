package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.User;


public interface UserDao extends JpaRepository<User, Integer> {
	// no need user profile dao, only use when check user profile
	User findByUsername(String username);

}

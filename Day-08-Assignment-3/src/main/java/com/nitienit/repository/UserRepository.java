package com.nitienit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);
	User findByEmail(String email);
	User findByUserNameOrEmail(String userName,String email);

}

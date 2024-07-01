package com.nitienit.service;

import java.util.List;

import com.nitienit.entity.User;

public interface UserService {

	void createUser(User user);
	List<User> fetchAlluser();
	User findById(Long id);
	void updateUser(Long id,User user);
	void deleteUser(Long id);
	User findByUserName(String userName);
	User findByEmail(String email);
	User findByUserNameOrEmail(String username,String email);
}

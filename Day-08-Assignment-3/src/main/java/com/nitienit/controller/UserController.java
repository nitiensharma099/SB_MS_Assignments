package com.nitienit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nitienit.entity.User;
import com.nitienit.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		logger.info("[UserController]:: (createUser) call");
		userService.createUser(user);
		logger.info("[UserController]:: (createUser) successfully");
	}
	@GetMapping
	public List<User> getAllUser() {
		logger.info("[UserController]:: (getAllUser) call");
		List<User> dbuser=userService.fetchAlluser();
		logger.info("[UserController]:: (getAllUser) successfully");
		return dbuser;
	}
	@GetMapping("{id}")
	public User getUserById(@PathVariable(name="id") Long id) {
		logger.info("[UserController]:: (getUserById) call  ");
		User dbUser=	userService.findById(id);
		logger.info("[UserController]:: (getUserById) successfully");
		return dbUser;
	}
	@PutMapping("{id}")
	public void updateUser(@PathVariable(name="id") Long id, @RequestBody User user) {
		logger.info("[UserController]:: (updateUser) call with id : {} ",id);
		userService.updateUser(id,user);
		logger.info("[UserController]:: (updateUser) successfully");
	}
	@DeleteMapping("{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUserById(@PathVariable(name="id") Long id) {
		logger.info("[UserController]:: (deleteUserById) call with id : {} ",id);
		userService.deleteUser(id);
		logger.info("[UserController]:: (deleteUserById) successfully");
	}
	
	@GetMapping("/userName/{userName}")
	public User getUserByUserName(@PathVariable(name="userName") String userName) {
		logger.info("[UserController]:: (getUserByUserName) call  ");
		User dbUser=	userService.findByUserName(userName);
		logger.info("[UserController]:: (getUserByUserName) successfully");
		return dbUser;
	}
	
	@GetMapping("/email/{email}")
	public User getUserByEmail(@PathVariable(name="email") String email) {
		logger.info("[UserController]:: (getUserByEmail) call  ");
		User dbUser=	userService.findByEmail(email);
		logger.info("[UserController]:: (getUserByEmail) successfully");
		return dbUser;
	}
	
	
	@GetMapping("/emailoruserName/{userName}/{email}")
	public User getUserByUserNameOrEmail(@PathVariable(name="userName") String userName,@PathVariable(name="email") String email) {
		logger.info("[UserController]:: (getUserByUserName) call userName: {} - email: {}",userName, email);
		User dbUser=	userService.findByUserNameOrEmail(userName,email);
		logger.info("[UserController]:: (getUserByUserName) successfully");
		return dbUser;
	}
}

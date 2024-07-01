package com.nitienit.service.impl;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.User;
import com.nitienit.repository.UserRepository;
import com.nitienit.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		logger.info("[userServiceImpl] :: (createUser) {}");
		userRepository.save(user);
		logger.info("[userServiceImpl] :: (createuser) --user saved in DB successfully");
	}

	@Override
	public List<User> fetchAlluser() {
		logger.info("[userServiceImpl] :: (fetchAlluser)");
		List<User> userList=	userRepository.findAll().stream().sorted(Comparator.comparing(User::getUserName)).toList();
		logger.info("[userServiceImpl] :: (fetchAlluser) --All user fetch successfully");
		return userList;
	}

	@Override
	public User findById(Long id) {

		logger.info("[userServiceImpl] :: (findById) id {}",id);
		User dbuser=	userRepository.findById( id).orElseThrow(()-> new RuntimeException("No Record found with id:"+id));
		logger.info("[userServiceImpl] :: (findById) --find the record  of id {} successfully",id);
		return dbuser;
	}

	@Override
	public void updateUser(Long id, User user) {
		logger.info("[userServiceImpl] :: (updateuser) id {}",id);
		User dbuser=	userRepository.findById( id).orElseThrow(()-> new RuntimeException());
		dbuser.setUserName(user.getPassword());
		dbuser.setEmail(user.getEmail());
		dbuser.setPassword(user.getPassword());
		userRepository.save(dbuser);
		logger.info("[userServiceImpl] :: (updateuser) record has been updatge with  id {}",id);
	}

	@Override
	public void deleteUser(Long id) {
		logger.info("[userServiceImpl] :: (deleteuser) id {}",id);
		if(userRepository.existsById(id)) {
			logger.info("[userServiceImpl] :: (deleteuser) id  exist{}",id);
			userRepository.deleteById(id);
		}else {
			throw new  RuntimeException("No Record found with id:"+id);
		}
		logger.info("[userServiceImpl] :: (deleteuser) id {} has been  deleted  successfully",id);
	}

	@Override
	public User findByUserName(String userName) {
		logger.info("[userServiceImpl] :: (findByUserName) userName {}",userName);
		return userRepository.findByUserName(userName);
	}

	@Override
	public User findByEmail(String email) {
		logger.info("[userServiceImpl] :: (findByEmail) userName {}",email);
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUsernameOrEmail(String username, String email) {
		logger.info("[userServiceImpl] :: (findByUsernameOrEmail) userName {}",email);
		return userRepository.findByUserNameOrEmail(username, email);
	}

	

}

package com.productapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.entities.User;

import com.productapp.model.repositories.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	

	@Override
	public User addUser(User user) {
		userRepo.save(user);
		return user;
		
	}



	@Override
	public User findUserByName(String name) {
		return userRepo.findUserByName(name);
	}



	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findUserByEmail(email);
	}

	//@Override
	//public void rateStore(int ratings) {
	//	ratingRepo.rateStore(ratings);
	//}
	
	

}

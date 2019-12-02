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
	public void addUser(User user) {
		userRepo.save(user);
	
		
	}

	//@Override
	//public void rateStore(int ratings) {
	//	ratingRepo.rateStore(ratings);
	//}
	
	

}

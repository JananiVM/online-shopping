package com.productapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.repositories.OrderRepo;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepo repo;

	@Override
	public void findById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

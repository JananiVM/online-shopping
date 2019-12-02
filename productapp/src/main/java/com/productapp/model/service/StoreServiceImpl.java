package com.productapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.model.entities.Product;
import com.productapp.model.entities.Store;
import com.productapp.model.repositories.StoreRepo;
@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepo storeRepo;

	@Override
	public Store addStore(Store store) {
		storeRepo.save(store);
	
		return store;
	}

	@Override
	public List<Store> findByStoreName(String productName) {
		
		return storeRepo.findByStoreName(productName);
	}

}

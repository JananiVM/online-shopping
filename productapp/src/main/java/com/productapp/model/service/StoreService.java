package com.productapp.model.service;

import java.util.List;

import com.productapp.model.entities.Product;
import com.productapp.model.entities.Store;


public interface StoreService {
	
	public Store addStore(Store store);
	

	public List<Store> findByStoreName(String productName);

}

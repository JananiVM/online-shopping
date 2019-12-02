package com.productapp.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Store;
@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {

	
	
	public List<Store> findByStoreName(String storeName);
	
	
}

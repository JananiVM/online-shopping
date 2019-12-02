package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.Store;
import com.productapp.model.exceptions.StoreNotFoundException;
import com.productapp.model.repositories.StoreRepo;


@RestController
public class StoreController {
	
	@Autowired
	private StoreRepo storeRepo;
	
	@GetMapping(path="stores", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Store>> getAllStores(){
		return new ResponseEntity<List<Store>>(storeRepo.findAll(),HttpStatus.OK);
		
	}
	
	@PostMapping(path="stores",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Store> postStores(@RequestBody Store store){
		return new ResponseEntity<Store>(storeRepo.save(store),HttpStatus.OK);
		
	}
	@PutMapping(path="stores/{storeId}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Store> postStores
	                (@PathVariable(name="storeId") Long storeId,@RequestBody Store storeReq){
		return storeRepo.findById(storeId).map(store->
		{
			store.setRatings(storeReq.getRatings());
			store.setStoreName(storeReq.getStoreName());
			
			return new ResponseEntity<Store>(storeRepo.save(store),HttpStatus.OK);
		}).orElseThrow(()->new StoreNotFoundException("Store not found"));
		
		
	}
	

}

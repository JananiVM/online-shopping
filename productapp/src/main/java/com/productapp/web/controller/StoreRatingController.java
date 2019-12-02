package com.productapp.web.controller;

import java.util.List;

import javax.swing.text.rtf.RTFEditorKit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.Store;
import com.productapp.model.entities.StoreRatings;
import com.productapp.model.exceptions.StoreNotFoundException;
import com.productapp.model.repositories.RatingRepo;
import com.productapp.model.repositories.StoreRepo;

@RestController
@RequestMapping(path="api")
public class StoreRatingController {
	
	@Autowired
	private RatingRepo ratingRepo;
	
	@Autowired
	private StoreRepo storeRepo;
	
	@GetMapping(path="stores/{storeId}/ratings", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StoreRatings>> getAllStores(@PathVariable(name="id") Long id){
		
		List<StoreRatings> ratings=(List<StoreRatings>) ratingRepo.findById(id)
				.orElseThrow(()->new StoreNotFoundException("Store not found"));
		return new ResponseEntity<List<StoreRatings>>(ratings,HttpStatus.OK);
		
	}
	
	@PostMapping(path="stores/{storeId}/ratings",consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreRatings> postStores(@PathVariable(name="storeId") Long storeId ,
			@RequestBody StoreRatings ratings){
		
		Store store=storeRepo.findById(storeId).orElseThrow(
				()-> new StoreNotFoundException("Store not found"));
		store.addRating(ratings);
		storeRepo.save(store);
		ratingRepo.save(ratings);
		return new ResponseEntity<StoreRatings>(ratings,HttpStatus.OK);
		
	}
	@PutMapping(path="stores/{storeId}/ratings/{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreRatings> postStores
	                (@PathVariable(name="storeId") Long storeId,
	                		@PathVariable(name="id") Long id ,@RequestBody StoreRatings ratingsReq){
		if(!storeRepo.existsById(storeId)){
			throw new StoreNotFoundException("store not found");
		}
		 StoreRatings ratings=ratingRepo.findById(id).orElseThrow(
				 ()->new StoreNotFoundException("store not found"));
		 ratings.setRating(ratingsReq.getRating());
		 ratingRepo.save(ratings);
			
			return new ResponseEntity<StoreRatings>(ratings,HttpStatus.OK);
		
		
	}

}

package com.productapp.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.StoreRatings;

@Repository
public interface RatingRepo extends JpaRepository<StoreRatings, Long>{
	
	public Optional<StoreRatings> findById(Long id);
	//Optional<StoreRatings> findByStoreIdAndId(Long storeId,Long id);

}

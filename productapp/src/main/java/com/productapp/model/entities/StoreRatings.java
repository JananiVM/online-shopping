package com.productapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="store_ratings_table1")
public class StoreRatings {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 private double rating;
	
	 @JsonIgnore
	@ManyToOne
	@JoinColumn(name="storeId_fk")
	private Store store;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public StoreRatings(double rating) {
		super();
		this.rating = rating;
	}
	
	
	

	
	
	
	
	

}

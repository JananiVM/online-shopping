package com.productapp.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="store_ratings_table")
public class StoreRatings {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int ratings;
	@OneToOne
	@JoinColumn(name="store_id")
	private Store store;

	/**
	 * @return the ratings
	 */
	public synchronized int getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public synchronized void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public StoreRatings(int ratings) {
		super();
		this.ratings = ratings;
	}
	
	
	
	

}

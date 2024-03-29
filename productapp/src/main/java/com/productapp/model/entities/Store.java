package com.productapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="store_table1")
public class Store {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long storeId;
	
	private String storeName;
	private String address;
	private String city;
	
	
	@OneToMany(mappedBy="store",fetch=FetchType.LAZY)
	@JsonIgnore
	private List< StoreRatings> ratings;
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="storeList")
	@JsonIgnore
	private List<Product> productList = new ArrayList<Product>();
	
	public void addRating(StoreRatings storeRatings){
		ratings.add(storeRatings);
		storeRatings.setStore(this);
	}
	
	
	public List<StoreRatings> getRatings() {
		return ratings;
	}


	public void setRatings(List<StoreRatings> ratings) {
		this.ratings = ratings;
	}


	public void addProduct(Product product){
		productList.add(product);
	}
	
	
	
	
	public Long getStoreId() {
		return storeId;
	}




	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}







	/**
	 * @return the storeName
	 */
	public synchronized String getStoreName() {
		return storeName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public synchronized void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * @return the address
	 */
	public synchronized String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public synchronized void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public synchronized String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public synchronized void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the id
	 */
	public synchronized Long getId() {
		return storeId;
	}
	/**
	 * @param id the id to set
	 */
	public synchronized void setId(Long storeId) {
		this.storeId = storeId;
	}
	public Store(String storeName, String address, String city) {
		super();
		this.storeName = storeName;
		this.address = address;
		this.city = city;
	}
	/**
	 * @return the productList
	 */
	public synchronized List<Product> getProductList() {
		return productList;
	}
	/**
	 * @param productList the productList to set
	 */
	public synchronized void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Store() {
	
	}
	
	
	
	
	

}

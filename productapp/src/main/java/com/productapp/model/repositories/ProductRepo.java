package com.productapp.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	public Optional<Product> findProductByProductName(String name);
	public List<Product> findProductByProductNameContaining(String keyword);
	@Query("select p.details from Product p ")
	public String getProductDetails(String name);
	
	 public Product findByProductName(String productName);
}

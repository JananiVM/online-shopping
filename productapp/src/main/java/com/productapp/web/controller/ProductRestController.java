package com.productapp.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.Product;
import com.productapp.model.entities.Store;
import com.productapp.model.service.ProductService;
import com.productapp.model.service.StoreService;

@RestController
@RequestMapping(path="api")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(path="product",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> GetProductByNameLike(@RequestParam(name="keyword")String keyword){
		List<Product> products = productService.findProductByNameLike(keyword);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	/*@GetMapping(path="product/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> GetProductDetails(@PathVariable(name="name")String name){
		String productDetails = productService.getProductDetails(name);
		return new ResponseEntity<String>(productDetails, HttpStatus.OK);
	}*/
	
	@GetMapping(path="product/{productName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Store>> getAllStoreByProductName(@PathVariable(name="productName")String productName){
		return new ResponseEntity<List<Store>>(storeService.findByStoreName(productName),HttpStatus.OK);
		
	}
	
	
	
	
	
	

}

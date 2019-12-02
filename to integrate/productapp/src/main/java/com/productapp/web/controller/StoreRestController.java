package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.entities.Product;
import com.productapp.model.entities.Store;
import com.productapp.model.service.ProductService;
import com.productapp.web.form.DetailsResponse;

@RestController
@RequestMapping(path="api")
class StoreRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="stores/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Store>>GetStores(@PathVariable(name="id")Long id){
		Product product = productService.findProductById(id);
		System.out.println(product);
		List<Store> storeList =product.getStoreList();
		
		for (Store store : storeList) {
			System.out.println(store);
			
		}
	//	response.setDetails(productDetails);
		return new ResponseEntity<List<Store>>(storeList,HttpStatus.OK);
	}

}

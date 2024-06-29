package com.nitienit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.nitienit.entity.Product;
import com.nitienit.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
 
private static final Logger log = LoggerFactory.getLogger(ProductController.class);

 @Autowired
 private ProductService productService;
 
 	@PostMapping
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}
 	@GetMapping("{id}")
 	public Product getProduct(@PathVariable(name="id") Long id) {
	return	productService.getProduct(id);
	}
 	@PutMapping("{id}")
 	public void updateProduct(@PathVariable(name="id") Long id, @RequestBody Product product) {
		productService.updateProduct(id,product);
	}
 	
 	@DeleteExchange("{id}")
 	public void deleteProduct(@PathVariable(name="id") Long id ) {
		productService.deleteProduct(id);
	}

}

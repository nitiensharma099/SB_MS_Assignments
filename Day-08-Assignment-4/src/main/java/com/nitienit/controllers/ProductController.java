package com.nitienit.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		log.info("[ProductController] :: createProduct() starts");
		productService.createProduct(product);
		log.info("[ProductController] :: createProduct() ends");
	}
	@GetMapping("{id}")
	public Product getProduct(@PathVariable(name="id") Long id) {
		log.info("[ProductController] :: getProduct() starts/ends id{}",id);
		return	productService.getProduct(id);
	}
	@PutMapping("{id}")
	public void updateProduct(@PathVariable(name="id") Long id, @RequestBody Product product) {
		log.info("[ProductController] :: updateProduct() starts/ends id{}",id);
		productService.updateProduct(id,product);
	}

	@DeleteExchange("{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable(name="id") Long id ) {
		log.info("[ProductController] :: deleteProduct() starts/ends id{}",id);
		productService.deleteProduct(id);
	}
	
	@GetMapping("/categoryName/{name}")
	public List<Product> getProductByCategoryName(@PathVariable(name="name") String name) {
		log.info("[ProductController] :: getProductByCategoryName() starts/ends name{}",name);
		return	productService.findByCategoryName(name);
	}
	@GetMapping("/join/categoryName/{name}")
	public List<Product> getProductJoinByCategoryName(@PathVariable(name="name") String name) {
		log.info("[ProductController] :: getProductJoinByCategoryName() starts/ends name{}",name);
		return	productService.fetchProductsByCategoryName(name);
	}
	
	@GetMapping("/barcode/{barCode}")
	public Product getProductByBarCode(@PathVariable(name="barCode") String barCode) {
		log.info("[ProductController] :: getProductByBarCode() starts/ends name{}",barCode);
		return	productService.findByBarCode(barCode);
	}
	
	@GetMapping("/native/barcode/{barCode}")
	public Product getProductNativeByBarCode(@PathVariable(name="barCode") String barCode) {
		log.info("[ProductController] :: getProductNativeByBarCode() starts/ends name{}",barCode);
		return	productService.fetchProductUsingNative(barCode);
	}
	@GetMapping("/jpl/barcode/{barCode}")
	public Product getProductJPLByBarCode(@PathVariable(name="barCode") String barCode) {
		log.info("[ProductController] :: getProductJPLByBarCode() starts/ends name{}",barCode);
		return	productService.fetchProductUsingJPQL(barCode);
	}

}

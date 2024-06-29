package com.nitienit.services.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Product;
import com.nitienit.repositories.ProductRepository;
import com.nitienit.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void createProduct(Product product) {
		//product.getIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
	}

	@Override
	public Product getProduct(Long id) {
		
		return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Record not found"));
	}

	@Override
	public void updateProduct(Long id, Product product) {
	Product dbProduct=	productRepository.findById(id).orElseThrow(()-> new RuntimeException("Record not found"));
		
	dbProduct.setName(product.getName());
	dbProduct.setBarCode(product.getBarCode());
	dbProduct.setCategory(product.getCategory());
	dbProduct.setDescription(product.getDescription());
	dbProduct.setPrice(product.getPrice());
	dbProduct.setQuantity(product.getQuantity());
	dbProduct.setStock(product.isStock());
	
	productRepository.save(dbProduct);
	
	
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

}

package com.nitienit.services.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Product;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.repositories.ProductRepository;
import com.nitienit.repositories.ReviewRepository;
import com.nitienit.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public void createProduct(Product product) {
		logger.info("[ProductServiceImpl] :: createProduct starts ");
		//product.getIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
		logger.info("[ProductServiceImpl] :: createProduct ends ");
	}

	@Override
	public Product getProduct(Long id) {
		logger.info("[ProductServiceImpl] :: getProduct starts/ends ");
		return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prdouct id not found in db"));
	}

	@Override
	public void updateProduct(Long id, Product product) {
	logger.info("[ProductServiceImpl] :: updateProduct starts id {} ",id);
	Product dbProduct=	productRepository.findById(id).orElseThrow(()-> new RuntimeException("Prdouct id not found in db"));
	
	reviewRepository.findById(dbProduct.getReview().getId()).orElseThrow(()-> new RuntimeException("Review id not found in db"));
		
	dbProduct.setName(product.getName());
	dbProduct.setBarCode(product.getBarCode());
	dbProduct.setReview(product.getReview());
	dbProduct.setDescription(product.getDescription());
	dbProduct.setPrice(product.getPrice());
	dbProduct.setQuantity(product.getQuantity());
	dbProduct.setIsStock(product.getIsStock());
	productRepository.save(dbProduct);
	logger.info("[ProductServiceImpl] :: updateProduct ends ");
	
	
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

}

package com.nitienit.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Product;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.repositories.CategoryRepository;
import com.nitienit.repositories.ProductRepository;
import com.nitienit.response.ProductBussinessResponse;
import com.nitienit.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createProduct(Product product) {
		logger.info("[ProductServiceImpl] :: createProduct starts ");
		// product.getIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
		logger.info("[ProductServiceImpl] :: createProduct ends ");
	}

	@Override
	public Product getProduct(Long id) {
		logger.info("[ProductServiceImpl] :: getProduct starts/ends ");
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prdouct id not found in db"));
	}

	@Override
	public void updateProduct(Long id, Product product) {
		logger.info("[ProductServiceImpl] :: updateProduct starts id {} ", id);
		Product dbProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Prdouct id not found in db"));

		categoryRepository.findById(dbProduct.getCategory().getId())
				.orElseThrow(() -> new RuntimeException("Category id not found in db"));

		dbProduct.setName(product.getName());
		dbProduct.setBarCode(product.getBarCode());
		dbProduct.setCategory(product.getCategory());
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

	@Override
	public List<Product> getAllProduct() {
		logger.info("[ProductServiceImpl] :: getAllProduct starts ");
		return productRepository.findAll();
	}

	@Override
	public ProductBussinessResponse getAllProductWithPagination(PageRequest pageRequest) {
		logger.info("[ProductServiceImpl] :: getAllProductWithPagination starts ");
		Page<Product> page = productRepository.findAll(pageRequest);
		ProductBussinessResponse product = new ProductBussinessResponse();
		product.setTotalNumberOfPages(page.getTotalPages());
		product.setTotalNumberOfRecords(page.getNumberOfElements());
		product.setProducts(page.getContent());
		return product;
	}

}

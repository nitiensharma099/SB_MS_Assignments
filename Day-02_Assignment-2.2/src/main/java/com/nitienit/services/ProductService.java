package com.nitienit.services;

import com.nitienit.entity.Product;

public interface ProductService {

	void createProduct(Product product);
	 Product getProduct(Long id);
	 void updateProduct(Long id,Product product);
	 void deleteProduct(Long id);
}

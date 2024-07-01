package com.nitienit.services;

import java.util.List;

import com.nitienit.entity.Product;

public interface ProductService {

	 void createProduct(Product product);
	 Product getProduct(Long id);
	 void updateProduct(Long id,Product product);
	 void deleteProduct(Long id);
	 List<Product> fetchProductsByCategoryName(String categoryName);
	 Product findByBarCode(String barCode);
	 List<Product> findByCategoryName(String categoryName);
	 Product fetchProductUsingJPQL(String barCode);
	 Product fetchProductUsingNative(String barCode);
}

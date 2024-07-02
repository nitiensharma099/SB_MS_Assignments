package com.nitienit.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.nitienit.entity.Product;
import com.nitienit.response.ProductBussinessResponse;

public interface ProductService {

	void createProduct(Product product);

	Product getProduct(Long id);

	List<Product> getAllProduct();

	void updateProduct(Long id, Product product);

	void deleteProduct(Long id);

	ProductBussinessResponse getAllProductWithPagination(PageRequest pageRequest);
}

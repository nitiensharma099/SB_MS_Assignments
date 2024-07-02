package com.nitienit.response;

import java.util.List;

import com.nitienit.entity.Product;

import lombok.Data;

@Data
public class ProductBussinessResponse {

	int totalNumberOfPages;
	long totalNumberOfRecords;
	List<Product> products;
}

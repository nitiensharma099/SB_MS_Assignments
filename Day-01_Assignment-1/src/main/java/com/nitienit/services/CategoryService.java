package com.nitienit.services;

import java.util.List;

import com.nitienit.entity.Category;

public interface CategoryService {

	void createCategory(Category category);
	
	List<Category> fetchAllCategory();
	
	Category findById(Long id);
	
	void updateCategory(Long id,Category category);
	
	void deleteCategory(Long id);
}

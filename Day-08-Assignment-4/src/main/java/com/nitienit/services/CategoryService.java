package com.nitienit.services;

import com.nitienit.entity.Category;

public interface CategoryService {

	void createCategories(Category category);
	Category getAllCategories(Long id);
}

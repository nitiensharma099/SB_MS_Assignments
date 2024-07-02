package com.nitienit.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Category;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.repositories.CategoryRepository;
import com.nitienit.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createCategories(Category category) {

		logger.info("[CategoryServiceImpl] :: (createCategories) ");
		categoryRepository.save(category);

	}

	@Override
	public Category getAllCategories(Long id) {
		logger.info("[CategoryServiceImpl] :: (getAllCategories) ");
		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record found"));

	}

}

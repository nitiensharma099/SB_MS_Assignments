package com.nitienit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitienit.entity.Category;
import com.nitienit.services.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/category")
@Slf4j
public class CategoryController {

	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public void createCategories(@RequestBody Category category) {
		logger.info("[CategoryController] :: (createCategories)");
		categoryService.createCategories(category);
	}
	
	@GetMapping("{id}")
	public Category getAllCategories(@PathVariable(name="id") Long id) {
		logger.info("[CategoryController] :: (getAllCategories) {}",id);
	return	categoryService.getAllCategories(id);
	}
	
	
}

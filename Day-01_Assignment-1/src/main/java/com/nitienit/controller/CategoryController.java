package com.nitienit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nitienit.entity.Category;
import com.nitienit.services.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {


	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createCategory(@RequestBody Category category) {
		logger.info("[CategoryController]:: (createCategory) call");
		categoryService.createCategory(category);
		logger.info("[CategoryController]:: (createCategory) successfully");
	}
	@GetMapping
	public List<Category> getAllCategory() {
		logger.info("[CategoryController]:: (getAllCategory) call");
		List<Category> dbcategory=categoryService.fetchAllCategory();
		logger.info("[CategoryController]:: (getAllCategory) successfully");
		return dbcategory;
	}
	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable(name="id") Long id) {
		logger.info("[CategoryController]:: (getCategoryById) call  ");
		Category dbCategory=	categoryService.findById(id);
		logger.info("[CategoryController]:: (getCategoryById) successfully");
		return dbCategory;
	}
	@PutMapping("{id}")
	public void updateCategory(@PathVariable(name="id") Long id, @RequestBody Category category) {
		logger.info("[CategoryController]:: (updateCategory) call with id : {} ",id);
		categoryService.updateCategory(id,category);
		logger.info("[CategoryController]:: (updateCategory) successfully");
	}
	@DeleteMapping("{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteCategoryById(@PathVariable(name="id") Long id) {
		logger.info("[CategoryController]:: (deleteCategoryById) call with id : {} ",id);
		categoryService.deleteCategory(id);
		logger.info("[CategoryController]:: (deleteCategoryById) successfully");
	}
}

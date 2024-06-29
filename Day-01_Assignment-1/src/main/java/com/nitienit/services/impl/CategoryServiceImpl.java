package com.nitienit.services.impl;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Category;
import com.nitienit.repositories.CategoryRepository;
import com.nitienit.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {


	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void createCategory(Category category) {
		logger.info("[CategoryServiceImpl] :: (createCategory) {}",category.getName());
		categoryRepository.save(category);
		logger.info("[CategoryServiceImpl] :: (createCategory) --Category saved in DB successfully");
	}

	@Override
	public List<Category> fetchAllCategory() {
		logger.info("[CategoryServiceImpl] :: (fetchAllCategory)");
		List<Category> categoryList=	categoryRepository.findAll().stream().sorted(Comparator.comparing(Category::getName)).toList();
		logger.info("[CategoryServiceImpl] :: (fetchAllCategory) --All Category fetch successfully");
		return categoryList;
	}

	@Override
	public Category findById(Long id) {

		logger.info("[CategoryServiceImpl] :: (findById) id {}",id);
		Category category=	categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("No Record found with id:"+id));
		logger.info("[CategoryServiceImpl] :: (findById) --find the record  of id {} successfully",id);
		return category;
	}

	@Override
	public void updateCategory(Long id, Category category) {
		logger.info("[CategoryServiceImpl] :: (updateCategory) id {}",id);
		Category dbCategory=	findById( id);
		dbCategory.setName(category.getName());
		categoryRepository.save(dbCategory);
		logger.info("[CategoryServiceImpl] :: (updateCategory) record has been updatge with  id {}",id);
	}

	@Override
	public void deleteCategory(Long id) {
		logger.info("[CategoryServiceImpl] :: (deleteCategory) id {}",id);
		if(categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
		}else {
			throw new  RuntimeException("No Record found with id:"+id);
		}
		logger.info("[CategoryServiceImpl] :: (deleteCategory) id {} has been  deleted  successfully",id);
	}

}

package com.nitienit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
}

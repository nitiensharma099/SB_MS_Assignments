package com.nitienit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

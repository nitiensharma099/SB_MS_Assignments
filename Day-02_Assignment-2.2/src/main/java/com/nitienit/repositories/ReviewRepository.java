package com.nitienit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitienit.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

package com.nitienit.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.entity.Review;
import com.nitienit.exception.ResourceNotFoundException;
import com.nitienit.services.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	
	@Autowired
	private com.nitienit.repositories.ReviewRepository reviewRepository;
	
	@Override
	public void createReview(Review review) {
		
		logger.info("[ReviewServiceImpl] :: (createReview) ");
		reviewRepository.save(review);
		
	}

	@Override
	public Review getAllReview(Long id) {
		logger.info("[ReviewServiceImpl] :: (getAllReview) ");
		return	reviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Record found"));

	}

}

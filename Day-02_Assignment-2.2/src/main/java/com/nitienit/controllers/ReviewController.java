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

import com.nitienit.entity.Review;
import com.nitienit.services.ReviewService;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public void createReview(@RequestBody Review review) {
		logger.info("[ReviewController] :: (createreview)");
		reviewService.createReview(review);
	}
	
	@GetMapping("{id}")
	public Review getAllreview(@PathVariable(name="id") Long id) {
		logger.info("[ReviewController] :: (getAllreview) {}",id);
	return	reviewService.getAllReview(id);
	}
	
	
}

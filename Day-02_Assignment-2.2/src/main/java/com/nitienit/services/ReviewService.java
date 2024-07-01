package com.nitienit.services;

import com.nitienit.entity.Review;

public interface ReviewService {

	void createReview(Review Review);
	Review getAllReview(Long id);
}

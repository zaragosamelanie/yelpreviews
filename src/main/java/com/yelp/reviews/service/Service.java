package com.yelp.reviews.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yelp.reviews.model.ProcessedReview;
import com.yelp.reviews.model.Review;

@Component
public class Service {

	public List<ProcessedReview> processedReview(Review[] reviews) {
		List<ProcessedReview> processed = new ArrayList<>();
		
		for (Review review : reviews) {
			processed.add(new ProcessedReview(review.getUser().getName(), review.getText(), review.getRating(), review.getTime_created()));
		}
		
		return processed;
	}
}

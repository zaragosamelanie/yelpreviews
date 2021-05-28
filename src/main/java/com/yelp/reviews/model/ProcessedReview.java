package com.yelp.reviews.model;

public class ProcessedReview {
	
	private String name;
	private String review;
	private String rating;
	private String timeCreated;
	
	public ProcessedReview(String name, String review, String rating, String timeCreated) {
		this.name = name;
		this.review = review;
		this.rating = rating;
		this.timeCreated = timeCreated;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Override
	public String toString() {
		return "ProcessedReview [name=" + name + ", review=" + review + ", rating=" + rating + ", timeCreated="
				+ timeCreated + "]";
	}

}

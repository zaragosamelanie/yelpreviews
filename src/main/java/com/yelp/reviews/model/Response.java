package com.yelp.reviews.model;

import java.util.Arrays;

public class Response {
	
	private Review[] reviews;
	private int total;
	private String[] possible_languages;
	
	public Review[] getReviews() {
		return reviews;
	}
	public void setReviews(Review[] reviews) {
		this.reviews = reviews;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String[] getPossible_languages() {
		return possible_languages;
	}
	public void setPossible_languages(String[] possible_languages) {
		this.possible_languages = possible_languages;
	}
	@Override
	public String toString() {
		return "Response [reviews=" + Arrays.toString(reviews) + ", total=" + total + ", possible_languages="
				+ Arrays.toString(possible_languages) + "]";
	}

}

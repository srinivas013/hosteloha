package com.RestAPI.hosteloha.DAO;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class UserReviewDAO {

	private int id;
	private int sellerId;
	private int buyer_id;
	private int review_rating;
	private String review_description;
	private int review_upvotes;
	private Date inserted_at;
	private Date updated_at;
	private float overallRating;
	
	public UserReviewDAO() {
		super();
	}

	

	public UserReviewDAO(int id, int sellerId, int buyer_id, int review_rating, String review_description,
			int review_upvotes, Date inserted_at, Date updated_at, float overallRating) {
		super();
		this.id = id;
		this.sellerId = sellerId;
		this.buyer_id = buyer_id;
		this.review_rating = review_rating;
		this.review_description = review_description;
		this.review_upvotes = review_upvotes;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
		this.overallRating = overallRating;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getsellerId() {
		return sellerId;
	}

	public void setsellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getReview_rating() {
		return review_rating;
	}

	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}

	public String getReview_description() {
		return review_description;
	}

	public void setReview_description(String review_description) {
		this.review_description = review_description;
	}

	public int getReview_upvotes() {
		return review_upvotes;
	}

	public void setReview_upvotes(int review_upvotes) {
		this.review_upvotes = review_upvotes;
	}

	public Date getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Date inserted_at) {
		this.inserted_at = inserted_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public float getOverallRating() {
		return overallRating;
	}


	public void setOverallRating(float overallRating) {
		this.overallRating = overallRating;
	}
		

}

package com.RestAPI.hosteloha.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_reviews")
public class UserReview {

	@Id
	private int id;
	@Column(name="seller_id")
	private int sellerId;
	private int buyer_id;
	private int review_rating;
	private String review_description;
	private int review_upvotes;
	@Column(insertable=false)
	private Date inserted_at;
	@Column(insertable=false)
	private Date updated_at;
	
	public UserReview() {
		super();
	}

	public UserReview(int id, int sellerId, int buyer_id, int review_rating, String review_description,
			int review_upvotes, Date inserted_at, Date updated_at) {
		super();
		this.id = id;
		this.sellerId = sellerId;
		this.buyer_id = buyer_id;
		this.review_rating = review_rating;
		this.review_description = review_description;
		this.review_upvotes = review_upvotes;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
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
	
	
	
	
}

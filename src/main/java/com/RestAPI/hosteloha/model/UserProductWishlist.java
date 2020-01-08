package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_product_wishlist")
public class UserProductWishlist {
	
	@Id
	private int id;
	@Column(name="users_id")
	private int userID;
	private int product_id;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public UserProductWishlist() {
		super();
	}

	public UserProductWishlist(int id, int userID, int product_id, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.userID = userID;
		this.product_id = product_id;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsers_id() {
		return userID;
	}

	public void setUsers_id(int userID) {
		this.userID = userID;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Timestamp getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Timestamp inserted_at) {
		this.inserted_at = inserted_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	
	
}

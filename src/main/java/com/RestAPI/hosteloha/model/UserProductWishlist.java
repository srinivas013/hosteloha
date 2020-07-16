package com.RestAPI.hosteloha.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="user_product_wishlist")
public class UserProductWishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	@Column(name="users_id")
	private int userID;
	private int product_id;
	@Column(insertable = false, updatable = false)
	@ApiModelProperty(required = false, hidden = true)
	private Date inserted_at;
	@Column(insertable = false, updatable = false)
	@ApiModelProperty(required = false, hidden = true)
	private Date updated_at;
	
	public UserProductWishlist() {
		super();
	}

	public UserProductWishlist(int id, int userID, int product_id) {
		super();
		this.id = id;
		this.userID = userID;
		this.product_id = product_id;
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

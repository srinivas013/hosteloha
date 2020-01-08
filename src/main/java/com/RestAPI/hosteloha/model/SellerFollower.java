package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller_follewers")
public class SellerFollower {

	@Id
	private int id;
	@Column(name="seller_id")
	private int sellerID;
	private int follower_id;
	private int is_notify;
	@Column(insertable=false)
	private Timestamp inserted_at;
	@Column(insertable=false)
	private Timestamp updated_at; 
	
	public SellerFollower() {
		super();
	}

	public SellerFollower(int id, int sellerID, int follower_id, int is_notify, Timestamp inserted_at) {
		super();
		this.id = id;
		this.sellerID = sellerID;
		this.follower_id = follower_id;
		this.is_notify = is_notify;
		this.inserted_at = inserted_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getsellerID() {
		return sellerID;
	}

	public void setsellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getFollower_id() {
		return follower_id;
	}

	public void setFollower_id(int follower_id) {
		this.follower_id = follower_id;
	}

	public int getIs_notify() {
		return is_notify;
	}

	public void setIs_notify(int is_notify) {
		this.is_notify = is_notify;
	}

	public Timestamp getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Timestamp inserted_at) {
		this.inserted_at = inserted_at;
	}
	
	
	
}

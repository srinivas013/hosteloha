package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="seller_followers")
public class SellerFollower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@Column(name="seller_id")
	private int sellerID;
	@Column(name ="followerId")
	private int followerId;
	private int is_notify;
	@Column(insertable=false , updatable = false)
	@ApiModelProperty(required=false, hidden = true)
	private Timestamp inserted_at;
	@Column(insertable=false, updatable = false)
	@ApiModelProperty(required=false, hidden = true)
	private Timestamp updated_at; 
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "seller_id", referencedColumnName = "id", insertable = false, updatable = false)
//	private User user;
	
	public SellerFollower() {
		super();
	}

	public SellerFollower(int id, int sellerID, int followerId, int is_notify) {
		super();
		this.id = id;
		this.sellerID = sellerID;
		this.followerId = followerId;
		this.is_notify = is_notify;
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
		return followerId;
	}

	public void setFollower_id(int followerId) {
		this.followerId = followerId;
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

	public Timestamp getUpdated_at() {
		return updated_at;
	}
	
}

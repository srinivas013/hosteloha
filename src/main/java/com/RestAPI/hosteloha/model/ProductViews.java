package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_views")
public class ProductViews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int product_id;
	@Column(insertable = false)
	private Timestamp last_viewed;
	@Column(insertable = false)
	private int views_hour;
	@Column(insertable = false)
	private int views_count;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public ProductViews() {
		super();
	}

	public ProductViews(int id, int product_id, Timestamp last_viewed, int views_hour, int views_count,
			Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.last_viewed = last_viewed;
		this.views_hour = views_hour;
		this.views_count = views_count;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Timestamp getLast_viewed() {
		return last_viewed;
	}

	public void setLast_viewed(Timestamp last_viewed) {
		this.last_viewed = last_viewed;
	}

	public int getViews_hour() {
		return views_hour;
	}

	public void setViews_hour(int views_hour) {
		this.views_hour = views_hour;
	}

	public int getViews_count() {
		return views_count;
	}

	public void setViews_count(int views_count) {
		this.views_count = views_count;
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

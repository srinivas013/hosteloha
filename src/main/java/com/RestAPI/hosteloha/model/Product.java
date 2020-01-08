package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int id;
	private String subtitle;
	private String description;
	private int category_id;
	private int users_id;
	private int condition_id;
	private int delivery_format_id;
	private int payment_option_id;
	private int selling_format_id;
	@Column(insertable=false)
	private Timestamp inserted_at;
	@Column(insertable=false)
	private Timestamp updated_at;
	
	public Product() {
		super();
	}

	public Product(int id, String subtitle, String description, int category_id, int users_id, int condition_id,
			int delivery_format_id, int payment_option_id, int selling_format_id, Timestamp inserted_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.subtitle = subtitle;
		this.description = description;
		this.category_id = category_id;
		this.users_id = users_id;
		this.condition_id = condition_id;
		this.delivery_format_id = delivery_format_id;
		this.payment_option_id = payment_option_id;
		this.selling_format_id = selling_format_id;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getCondition_id() {
		return condition_id;
	}

	public void setCondition_id(int condition_id) {
		this.condition_id = condition_id;
	}

	public int getDelivery_format_id() {
		return delivery_format_id;
	}

	public void setDelivery_format_id(int delivery_format_id) {
		this.delivery_format_id = delivery_format_id;
	}

	public int getPayment_option_id() {
		return payment_option_id;
	}

	public void setPayment_option_id(int payment_option_id) {
		this.payment_option_id = payment_option_id;
	}

	public int getSelling_format_id() {
		return selling_format_id;
	}

	public void setSelling_format_id(int selling_format_id) {
		this.selling_format_id = selling_format_id;
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

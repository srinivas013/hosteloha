package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_option")
public class PaymentOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int coupons_id;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public PaymentOption() {
		super();
	}

	public PaymentOption(int id, String name, String description, int coupons_id, Timestamp inserted_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coupons_id = coupons_id;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCoupons_id() {
		return coupons_id;
	}

	public void setCoupons_id(int coupons_id) {
		this.coupons_id = coupons_id;
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

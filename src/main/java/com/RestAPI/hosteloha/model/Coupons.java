package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String description;
	private int value;
	private int is_active;
	private int is_multiple;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public Coupons() {
		super();
	}

	public Coupons(int id, String code, String description, int value, int is_active, int is_multiple,
			Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.value = value;
		this.is_active = is_active;
		this.is_multiple = is_multiple;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

	public int getIs_multiple() {
		return is_multiple;
	}

	public void setIs_multiple(int is_multiple) {
		this.is_multiple = is_multiple;
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

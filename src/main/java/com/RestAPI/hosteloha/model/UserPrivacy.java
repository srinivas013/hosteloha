package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPrivacy {
	
	@Id
	private int id;
	private String type;
	private String description;
	@Column(insertable=false)
	private Timestamp inserted_at;
	@Column(insertable=false)
	private Timestamp updated_at;
	
	
	public UserPrivacy() {
		super();
	}


	public UserPrivacy(int id, String type, String description, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

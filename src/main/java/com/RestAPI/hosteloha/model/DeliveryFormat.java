package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_format")
public class DeliveryFormat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	public DeliveryFormat() {
		super();
	}
	public DeliveryFormat(int id, String name, String description, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.name = name;
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

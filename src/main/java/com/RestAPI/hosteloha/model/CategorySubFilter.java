package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "category_subfilter")
@IdClass(CategorySubFilterKey.class)
public class CategorySubFilter {

	@Id
	@Column(name = "sub_category1")
	private String subcategory1;
	@Id
	@Column(name = "sub_category2")
	private String subcategory2;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public CategorySubFilter() {
		super();
	}

	public CategorySubFilter(String subcategory1, String subcategory2, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.subcategory1 = subcategory1;
		this.subcategory2 = subcategory2;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public String getSubcategory1() {
		return subcategory1;
	}

	public void setSubcategory1(String subcategory1) {
		this.subcategory1 = subcategory1;
	}

	public String getSubcategory2() {
		return subcategory2;
	}

	public void setSubcategory2(String subcategory2) {
		this.subcategory2 = subcategory2;
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

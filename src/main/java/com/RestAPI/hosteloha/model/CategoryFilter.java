package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "category_filter")
@IdClass(CategoryFilterPkey.class)
public class CategoryFilter {
	

	@Id
	@Column(name = "category_name")
	private String categoryName;
	
	@Id
	@Column(name = "sub_category1")
	private String subCategory;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp Updated_at;
	
	public CategoryFilter() {
		super();
	}

	public CategoryFilter(String categoryName, String subCategory, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.categoryName = categoryName;
		this.subCategory = subCategory;
		this.inserted_at = inserted_at;
		Updated_at = updated_at;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Timestamp getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Timestamp inserted_at) {
		this.inserted_at = inserted_at;
	}

	public Timestamp getUpdated_at() {
		return Updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		Updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "CategoryFilter [categoryName=" + categoryName + ", subCategory=" + subCategory + ", inserted_at="
				+ inserted_at + ", Updated_at=" + Updated_at + "]";
	}

	
}


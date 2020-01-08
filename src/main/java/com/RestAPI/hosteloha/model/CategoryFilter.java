package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CategoryFilterPkey.class)
@Table(name = "category_filter")
public class CategoryFilter {
	
	@Column(name = "category_name")
	@Id
	private String CategoryName;
	@Column(name = "subcategory1")
	@Id
	private String SubCategory;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp Updated_at;
	
	public CategoryFilter() {
		super();
	}

	public CategoryFilter(String categoryName, String subCategory, Timestamp inserted_at, Timestamp updated_at) {
		super();
		CategoryName = categoryName;
		SubCategory = subCategory;
		this.inserted_at = inserted_at;
		Updated_at = updated_at;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getSubCategory() {
		return SubCategory;
	}

	public void setSubCategory(String subCategory) {
		SubCategory = subCategory;
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
	
}


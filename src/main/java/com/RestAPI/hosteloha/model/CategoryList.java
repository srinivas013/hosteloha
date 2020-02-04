package com.RestAPI.hosteloha.model;

public class CategoryList {

	private String category;
	private String subcategory1;
	private String subcategory2;
	
	public CategoryList() {
		super();
	}

	public CategoryList(String category, String subcategory1, String subcategory2) {
		super();
		this.category = category;
		this.subcategory1 = subcategory1;
		this.subcategory2 = subcategory2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "CategoryList [category=" + category + ", subcategory1=" + subcategory1 + ", subcategory2="
				+ subcategory2 + "]";
	}

	
	
}

package com.RestAPI.hosteloha.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "allcategorylist")
@IdClass(AllCategoryListKey.class)
public class AllCategoryList {

	@Id
	@Column(name = "category_name")
	private String categoryname;
	@Id
	@Column(name = "sub_category1")
	private String subcategory1;
	@Id
	@Column(name = "sub_category2")
	private String subcategory2;
	
	public AllCategoryList() {
		super();
	}

	public AllCategoryList(String categoryname, String subcategory1, String subcategory2) {
		super();
		this.categoryname = categoryname;
		this.subcategory1 = subcategory1;
		this.subcategory2 = subcategory2;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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
		return "AllCategoryList [categoryname=" + categoryname + ", subcategory1=" + subcategory1 + ", subcategory2="
				+ subcategory2 + "]";
	}
	
	
}

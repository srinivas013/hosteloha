package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@SequenceGenerator(name="seq", sequenceName="categoryidseq", allocationSize = 9000)
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@Column(name="category_name")
	private String category_name;
	@Column(name="sub_category1")
	private String sub_category1;
	@Column(name="sub_category2")
	private String sub_category2;
	@JsonIgnore
	@Column(name="description")
	private String description;
	@JsonIgnore
	@Column(insertable = false)
	private Timestamp inserted_at;
	@JsonIgnore
	@Column(insertable = false)
	private Timestamp updated_at;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "category")
	@JsonIgnore
	private Product product;
	
	public Category() {
		super();
	}

	public Category(int id, String category_name, String sub_category1, String sub_category2, String description,
			Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.category_name = category_name;
		this.sub_category1 = sub_category1;
		this.sub_category2 = sub_category2;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getSub_category1() {
		return sub_category1;
	}

	public void setSub_category1(String sub_category1) {
		this.sub_category1 = sub_category1;
	}

	public String getSub_category2() {
		return sub_category2;
	}

	public void setSub_category2(String sub_category2) {
		this.sub_category2 = sub_category2;
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

	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category_name=" + category_name + ", sub_category1=" + sub_category1
				+ ", sub_category2=" + sub_category2 + ", description=" + description + ", inserted_at=" + inserted_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
	

}

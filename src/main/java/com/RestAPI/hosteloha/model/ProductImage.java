package com.RestAPI.hosteloha.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "product_image")
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	@JsonIgnore
	private int productid;
	private String imageURL;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid" , referencedColumnName = "id", insertable = false, updatable = false)
//	@Fetch(FetchMode.JOIN)
//	@JsonIgnoreProperties("productimages")
	@JsonIgnore
	private Product product;
	
	public ProductImage() {
		super();
	}

	public ProductImage(int id, int productid, String imageURL) {
		super();
		this.id = id;
		this.productid = productid;
		this.imageURL = imageURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}

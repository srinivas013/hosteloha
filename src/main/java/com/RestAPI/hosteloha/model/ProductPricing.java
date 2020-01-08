package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_pricing")
public class ProductPricing {

	@Id
	private int id;
	@Column(name = "product_id")
	private int productID;
	private float cost_price;
	private float selling_price;
	private String currency;
	private int quantity;
	private int manufactured_on;
	@Column(insertable = false)
	private Timestamp inserted_at;
	@Column(insertable = false)
	private Timestamp updated_at;
	
	public ProductPricing() {
		super();
	}

	public ProductPricing(int id, int productID, float cost_price, float selling_price, String currency, int quantity,
			int manufactured_on, Timestamp inserted_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.productID = productID;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.currency = currency;
		this.quantity = quantity;
		this.manufactured_on = manufactured_on;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getproductID() {
		return productID;
	}

	public void setproductID(int productID) {
		this.productID = productID;
	}

	public float getCost_price() {
		return cost_price;
	}

	public void setCost_price(float cost_price) {
		this.cost_price = cost_price;
	}

	public float getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(float selling_price) {
		this.selling_price = selling_price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getManufactured_on() {
		return manufactured_on;
	}

	public void setManufactured_on(int manufactured_on) {
		this.manufactured_on = manufactured_on;
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

package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
//@SequenceGenerator(name="seq", initialValue=100000, allocationSize=900000)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product_title;
	private String subtitle;
	private String description;
	private float selling_price;
	private float cost_price;
	private String currency;
	private int quantity;
	private int category_id;
	private int users_id;
	private int condition_id;
	private int delivery_format_id;
	private int payment_option_id;
	private int selling_format_id;
	@Column(insertable=false, updatable=false)
	private Timestamp inserted_at;
	@Column(insertable=false, updatable= false)
	private Timestamp updated_at;
	
	public Product() {
		super();
	}

	public Product(int id, String product_title, String subtitle, String description, float selling_price,
			float cost_price, String currency, int quantity, int category_id, int users_id, int condition_id,
			int delivery_format_id, int payment_option_id, int selling_format_id, Timestamp inserted_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.product_title = product_title;
		this.subtitle = subtitle;
		this.description = description;
		this.selling_price = selling_price;
		this.cost_price = cost_price;
		this.currency = currency;
		this.quantity = quantity;
		this.category_id = category_id;
		this.users_id = users_id;
		this.condition_id = condition_id;
		this.delivery_format_id = delivery_format_id;
		this.payment_option_id = payment_option_id;
		this.selling_format_id = selling_format_id;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(float selling_price) {
		this.selling_price = selling_price;
	}

	public float getCost_price() {
		return cost_price;
	}

	public void setCost_price(float cost_price) {
		this.cost_price = cost_price;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getCondition_id() {
		return condition_id;
	}

	public void setCondition_id(int condition_id) {
		this.condition_id = condition_id;
	}

	public int getDelivery_format_id() {
		return delivery_format_id;
	}

	public void setDelivery_format_id(int delivery_format_id) {
		this.delivery_format_id = delivery_format_id;
	}

	public int getPayment_option_id() {
		return payment_option_id;
	}

	public void setPayment_option_id(int payment_option_id) {
		this.payment_option_id = payment_option_id;
	}

	public int getSelling_format_id() {
		return selling_format_id;
	}

	public void setSelling_format_id(int selling_format_id) {
		this.selling_format_id = selling_format_id;
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

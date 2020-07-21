package com.RestAPI.hosteloha.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allpopularproducts")
public class ProductOutputDAO {

	@Id
	private int id;
	private String product_title;
	private String subtitle;
	private String description;
	private float selling_price;
	private float cost_price;
	private String currency;
	private int quantity;
	private String category;
	private String subcategory1;
	private String subcategory2;
	private int users_id;
	private int condition_id;
	private int delivery_format_id;
	private int payment_option_id;
	private int selling_format_id;
	@Column(insertable = false)
	private int views_hour;
	@Column(insertable = false)
	private int views_count;
	private Timestamp last_viewed;

	
//	private int category_id; 
	
	public ProductOutputDAO() {
		super();
	}



public ProductOutputDAO(int id, String product_title, String subtitle, String description, float selling_price,
		float cost_price, String currency, int quantity, String category, String subcategory1, String subcategory2,
		int users_id, int condition_id, int delivery_format_id, int payment_option_id, int selling_format_id,
		int views_hour, int views_count, Timestamp last_viewed) {
	super();
	this.id = id;
	this.product_title = product_title;
	this.subtitle = subtitle;
	this.description = description;
	this.selling_price = selling_price;
	this.cost_price = cost_price;
	this.currency = currency;
	this.quantity = quantity;
	this.category = category;
	this.subcategory1 = subcategory1;
	this.subcategory2 = subcategory2;
	this.users_id = users_id;
	this.condition_id = condition_id;
	this.delivery_format_id = delivery_format_id;
	this.payment_option_id = payment_option_id;
	this.selling_format_id = selling_format_id;
	this.views_hour = views_hour;
	this.views_count = views_count;
	this.last_viewed = last_viewed;
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


public int getViews_hour() {
	return views_hour;
}


public void setViews_hour(int views_hour) {
	this.views_hour = views_hour;
}


public int getViews_count() {
	return views_count;
}


public void setViews_count(int views_count) {
	this.views_count = views_count;
}


public Timestamp getLast_viewed() {
	return last_viewed;
}


public void setLast_viewed(Timestamp last_viewed) {
	this.last_viewed = last_viewed;
}
	
}

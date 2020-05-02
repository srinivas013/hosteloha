package com.RestAPI.hosteloha.DAO;

import org.springframework.stereotype.Component;

@Component
public class ProductInputDAO {
	
	private String product_title;
	private String subtitle;
	private String description;
	private String category;
	private String subcategory1;
	private String subcategory2;
	private String currency;
	private float selling_price;
	private float cost_price;
	private int users_id;
	private int condition_id;
	private int delivery_format_id;
	private int payment_option_id;
	private int selling_format_id;

	
	public ProductInputDAO() {
		super();
	}


	public ProductInputDAO(String product_title, String subtitle, String description, String category,
			String subcategory1, String subcategory2, String currency, float selling_price, float cost_price,
			int users_id, int condition_id, int delivery_format_id, int payment_option_id, int selling_format_id) {
		super();
		this.product_title = product_title;
		this.subtitle = subtitle;
		this.description = description;
		this.category = category;
		this.subcategory1 = subcategory1;
		this.subcategory2 = subcategory2;
		this.currency = currency;
		this.selling_price = selling_price;
		this.cost_price = cost_price;
		this.users_id = users_id;
		this.condition_id = condition_id;
		this.delivery_format_id = delivery_format_id;
		this.payment_option_id = payment_option_id;
		this.selling_format_id = selling_format_id;
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


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
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

}

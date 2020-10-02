package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
//@SequenceGenerator(name="seq", initialValue=100000, allocationSize=900000)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "productTitle")
	private String productTitle;
	private String subtitle;
	private String description;
	private float selling_price;
	private float cost_price;
	private String currency;
	private int quantity;
	private String product_state;
	@JsonIgnore
	private int category_id;
	@Column(name = "usersId")
	private int users_id;
	private int condition_id;
	private int delivery_format_id;
	private int payment_option_id;
	private int selling_format_id;
	@ApiModelProperty(hidden = true)
	@Column(insertable=false, updatable=false)
	private Timestamp inserted_at;
	@ApiModelProperty(hidden = true)
	@Column(insertable=false, updatable= false)
	private Timestamp updated_at;
	
	@OneToMany(fetch = FetchType.EAGER,  mappedBy = "product")
	@Fetch(FetchMode.JOIN)
	@BatchSize(size=25)
	private List<ProductImage> productimages;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "product1")
	@Fetch(FetchMode.JOIN)
	@BatchSize(size=25)
	private ProductViews productviews;
//	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	@Fetch(FetchMode.JOIN)
//	@BatchSize(size=25)
//	private ProductViews productviews;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="category_id", referencedColumnName = "id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	@BatchSize(size=25)
	private Category category;
	

	
	public Product() {
		super();
	}



	public Product(int id, String productTitle, String subtitle, String description, float selling_price,
			float cost_price, String currency, int quantity, String product_state, int category_id, int users_id,
			int condition_id, int delivery_format_id, int payment_option_id, int selling_format_id,
			Timestamp inserted_at, Timestamp updated_at, List<ProductImage> productimages, ProductViews productviews,
			Category category) {
		super();
		this.id = id;
		this.productTitle = productTitle;
		this.subtitle = subtitle;
		this.description = description;
		this.selling_price = selling_price;
		this.cost_price = cost_price;
		this.currency = currency;
		this.quantity = quantity;
		this.product_state = product_state;
		this.category_id = category_id;
		this.users_id = users_id;
		this.condition_id = condition_id;
		this.delivery_format_id = delivery_format_id;
		this.payment_option_id = payment_option_id;
		this.selling_format_id = selling_format_id;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
		this.productimages = productimages;
		this.productviews = productviews;
		this.category = category;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_title() {
		return productTitle;
	}

	public void setProduct_title(String productTitle) {
		this.productTitle = productTitle;
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
	


	public String getProduct_state() {
		return product_state;
	}


	public void setProduct_state(String product_state) {
		this.product_state = product_state;
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

	
	public List<ProductImage> getProductimages() {
		return productimages;
	}

	public void setProductimages(List<ProductImage> productimages) {
		this.productimages = productimages;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductViews getProductviews() {
		return productviews;
	}

	public void setProductviews(ProductViews productviews) {
		this.productviews = productviews;
	}
	

}

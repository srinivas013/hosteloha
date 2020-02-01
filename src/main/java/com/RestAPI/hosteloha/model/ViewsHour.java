package com.RestAPI.hosteloha.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viewshour")
public class ViewsHour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int productid;
	@Column(insertable = false)
	private Timestamp viewed_at;
	
	public ViewsHour() {
		super();
	}

	public ViewsHour(int id, int productid, Timestamp viewed_at) {
		super();
		this.id = id;
		this.productid = productid;
		this.viewed_at = viewed_at;
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

	public Timestamp getViewed_at() {
		return viewed_at;
	}

	public void setViewed_at(Timestamp viewed_at) {
		this.viewed_at = viewed_at;
	}
	
	
}

package com.RestAPI.hosteloha.DAO;

import java.util.List;

import com.RestAPI.hosteloha.model.Product;

public class UserWishListOutputDAO {

	private int userid;
	private List<Product> products;
	
	public UserWishListOutputDAO() {
		super();
	}

	public UserWishListOutputDAO(int userid, List<Product> products) {
		super();
		this.userid = userid;
		this.products = products;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "UserWishListOutputDAO [userid=" + userid + ", products=" + products + "]";
	}
	
	
}

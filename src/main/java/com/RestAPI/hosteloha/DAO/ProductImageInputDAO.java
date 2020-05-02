package com.RestAPI.hosteloha.DAO;

import java.util.List;

public class ProductImageInputDAO {

	private int productid;
	private List<String> imageURL;
	
	public ProductImageInputDAO() {
		super();
	}

	public ProductImageInputDAO(int productid, List<String> imageURL) {
		super();
		this.productid = productid;
		this.imageURL = imageURL;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public List<String> getImageURL() {
		return imageURL;
	}

	public void setImageURL(List<String> imageURL) {
		this.imageURL = imageURL;
	}
	
}

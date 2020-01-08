package com.RestAPI.hosteloha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.model.Condition;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.model.ProductPricing;
import com.RestAPI.hosteloha.model.UserProductWishlist;
import com.RestAPI.hosteloha.repository.CategoryFilterRepository;
import com.RestAPI.hosteloha.repository.CategorySubFilterRepository;
import com.RestAPI.hosteloha.repository.ConditionRepository;
import com.RestAPI.hosteloha.repository.ProductPricingRepository;
import com.RestAPI.hosteloha.repository.ProductRepository;
import com.RestAPI.hosteloha.repository.UserProductWishlistRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ConditionRepository conditionRepo;
	@Autowired
	private ProductPricingRepository pricingRepo;
	@Autowired
	private CategoryFilterRepository categoryFilterRepo;
	@Autowired
	private CategorySubFilterRepository subcategoryFilterRepo;


	public List<Product> getAllProducts() {
		
		List<Product> allproducts = productRepo.findAll();
		return allproducts;
	}

	public Product addProduct(Product product) {
		
		Product savedproduct = productRepo.save(product);
		
		return savedproduct;
		
	}

	public List<Condition> getAllProductCondition() {
		
		List<Condition> conditionList = conditionRepo.findAll();
		return conditionList;
	}

	public Condition addCondition(Condition condition) {
		
		 Condition savedcondition = conditionRepo.save(condition);
		 return savedcondition;
	}

	public ProductPricing addProductPricing(ProductPricing price) {

		ProductPricing savedprice = pricingRepo.save(price);
		return savedprice;
	}

	public List<ProductPricing> getProductPrice(int productid) {
		
		List<ProductPricing> productprice = pricingRepo.findByProductID(productid);
		return productprice;
	}

	public List<String> getAllCategories() {
		
		List<String> allcategory = categoryFilterRepo.findByCategoryName();
		return allcategory;
	}

	public List<String> getsubCategoryByCategory(String categoryname) {
		
		List<String> subcategorylistbyCategory = categoryFilterRepo.getsubCategoryByCategory(categoryname);
		return subcategorylistbyCategory;
	}

	public List<String> getsubCategoryBySubCategory(String subcategory1) {
		
		List<String> subcategorylistbySubCategory = subcategoryFilterRepo.getsubCategoryBySubCategory(subcategory1);
		return subcategorylistbySubCategory;
	}
	
}

package com.RestAPI.hosteloha.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestAPI.hosteloha.DAO.ProductInputDAO;
import com.RestAPI.hosteloha.model.CategoryFilter;
import com.RestAPI.hosteloha.model.CategoryList;
import com.RestAPI.hosteloha.model.CategorySubFilter;
import com.RestAPI.hosteloha.model.Condition;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.model.ProductPricing;
import com.RestAPI.hosteloha.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductInputDAO product;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	@PostMapping("/add_product")
	public ResponseEntity<Object> addOneProduct(@RequestBody ProductInputDAO product) {
		
	
		Product addedProduct = productService.addProduct(product);
		
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedProduct.getId()).toUri();
		return new ResponseEntity<Object>(addedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/product_condition")
	public List<Condition> getAllProductCondition() {
		
		List<Condition> allProductCondition = productService.getAllProductCondition();
		return allProductCondition;
	}
	
	@PostMapping("/add_condition")
	public ResponseEntity<Object> addCondition(@RequestBody Condition condition) {
		
		Condition addedCondition = productService.addCondition(condition);
		return new ResponseEntity<Object>(addedCondition, HttpStatus.CREATED);
	}
	
	@PostMapping("/add_productPricing")
	public ResponseEntity<ProductPricing> addProductPricing(@RequestBody ProductPricing price ) {
		
		ProductPricing addedProductPrice = productService.addProductPricing(price);
		return new ResponseEntity<ProductPricing>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{productid}/getPrice")
	public List<ProductPricing> getProductPrice(@PathVariable int productid) {
		
		List<ProductPricing> productPrice = productService.getProductPrice(productid);
		return productPrice;
	}
	
	@GetMapping("/AllCategories")
	public List<String> getAllCategories() {
		
		List<String> allCategories = productService.getAllCategories();
		return allCategories;
	}
	
	@GetMapping("/{categoryname}/subcategory1")
	public List<String> getsubCategoryByCategory(@PathVariable String categoryname) {
		
		List<String> subcategorylistbyCategory = productService.getsubCategoryByCategory(categoryname);
		return subcategorylistbyCategory;
	}
	
	@GetMapping("/{subcategory1}/subcategory2")
	public List<String> getsubCategoryBySubCategory(@PathVariable String subcategory1) {
		
		return productService.getsubCategoryBySubCategory(subcategory1);
	}
	
	@PostMapping("/addSubCategory1") 
	public ResponseEntity<Object> addSubcategory1(@RequestBody CategoryFilter categoryFilter) {
		
		CategoryFilter addedSubCategory1 = productService.addSubCategory1(categoryFilter);
		return new ResponseEntity<Object>(addedSubCategory1, HttpStatus.CREATED);
	}
	
	@PostMapping("/addSubCategory2") 
	public ResponseEntity<Object> addSubcategory2(@RequestBody CategorySubFilter categorySubFilter) {
		
		CategorySubFilter addedSubCategory2 = productService.addSubCategory2(categorySubFilter);
		return new ResponseEntity<Object>(addedSubCategory2, HttpStatus.CREATED);
	}
	
	@PostMapping("/addCategoryList")
	public ResponseEntity<Object> addCategoryList(@RequestBody CategoryList categorylist) {
		
		String result = productService.addCategoryList(categorylist);
		
		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/product_views/{product_id}")
	public ResponseEntity<Object> updateProductViews(@PathVariable int product_id) {
		
		int updateProductViews = productService.updateProductViews(product_id);
		return new ResponseEntity<Object>(updateProductViews, HttpStatus.OK);
	}
	
		
}	
	
	

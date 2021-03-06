package com.RestAPI.hosteloha.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestAPI.hosteloha.DAO.AllCategoryList;
import com.RestAPI.hosteloha.DAO.ProductImageInputDAO;
import com.RestAPI.hosteloha.DAO.ProductInputDAO;
import com.RestAPI.hosteloha.DAO.ProductOutputDAO;
import com.RestAPI.hosteloha.model.Cart;
import com.RestAPI.hosteloha.model.CategoryFilter;
import com.RestAPI.hosteloha.model.CategoryList;
import com.RestAPI.hosteloha.model.CategorySubFilter;
import com.RestAPI.hosteloha.model.Condition;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.model.ProductImage;
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
	
	@GetMapping("/products/{productid}")
	public Optional<Product> getProductById(@PathVariable int productid) {
		System.out.println(productid);
		Optional<Product> product = productService.getProductById(productid);
		return product;
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
	@Cacheable(value = "defaultCache" , key = "#productid")
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
	
	@Cacheable(value = "defaultCache" , key = "#categoryname")
	@GetMapping("/{categoryname}/subcategory1")
	public List<String> getsubCategoryByCategory(@PathVariable String categoryname) {
		
		List<String> subcategorylistbyCategory = productService.getsubCategoryByCategory(categoryname);
		return subcategorylistbyCategory;
	}
	
	@Cacheable(value = "defaultCache" , key = "#subcategory1")
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
	
//	@PutMapping("/product_views/{product_id}")
//	public ResponseEntity<Object> updateProductViews(@PathVariable int product_id) {
//		
//		int updateProductViews = productService.updateProductViews(product_id);
//		return new ResponseEntity<Object>(updateProductViews, HttpStatus.OK);
//	}
	
	@PutMapping("/product_views/{product_id}/{userid}")
	public ResponseEntity<Object> updateProductViews(@PathVariable int product_id, @PathVariable int userid) {
		
		int updateProductViews = productService.updateProductViews(product_id,userid);
		return new ResponseEntity<Object>(updateProductViews, HttpStatus.OK);
	}
	
	@GetMapping("/categorymaplist")
	public ResponseEntity<?> getCategoryMapList() {
		Map<String, Set<String>> allCategoryList = productService.finalCategoryListtoFE();
		return ResponseEntity.ok(allCategoryList);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		return updatedProduct;
	}
	
	@PostMapping("/addProductImage")
	public String addProductImages(@RequestBody ProductImageInputDAO productimage) {
		String result = productService.addProductImages(productimage);
		return result;
		
	}

	@PutMapping("/{productid}/{state}/updateProductState")
	public String updateProductState(@PathVariable int productid, @PathVariable String state) {
		int result = productService.updateProductState(productid,state);
		System.out.println("result=========="+result);
		if(result==1)
		return "Success";
		else 
			return "Something went wrong";
		
	}
	
	@GetMapping("/getAllProductsByPages/{pagenumber}/{pagesize}/{sortingtype}/{sortby}")
	public Page<Product> getAllProductsByPages(@PathVariable int pagenumber, @PathVariable int pagesize, 
			@PathVariable String sortingtype,
			@PathVariable String sortby) {
		Page<Product> allProductsByPages = productService.getAllProductsByPages(pagenumber,pagesize,sortingtype,sortby);
		return allProductsByPages;
	}
	
	@GetMapping("/getAllProductsByCategoryPages/{categoryname}/{pagenumber}/{pagesize}/{sortingtype}/{sortby}")
	public Page<Product> getAllProductsByCategoryPages(@PathVariable String categoryname, @PathVariable int pagenumber, 
			@PathVariable int pagesize, 
			@PathVariable String sortingtype,
			@PathVariable String sortby) {
		System.out.println(categoryname);
		System.out.println(categoryname+"    "+sortingtype+"   "+sortby);
		Page<Product> allProductsByPages = productService.getAllProductsByCategoryPages(categoryname,pagenumber,pagesize,sortingtype,sortby);
		return allProductsByPages;
	}

	@GetMapping("/{userid}/products")
	public List<Product> getProductsOfUser(@PathVariable int userid) {
		List<Product> productsOfUser = productService.getProductsOfUser(userid);
		return productsOfUser;
	}
	
	@PostMapping("/product/addToCart")
	public Cart addToCart(@RequestBody Cart cart) {
		Cart savedcart = productService.addToCart(cart);
		return savedcart;
	}
	
	@GetMapping("/{userid}/cartproducts")
	public List<Cart> getUserCartProducts(@PathVariable int userid) {
		List<Cart> userCartProducts = productService.getUserCartProducts(userid);
		return userCartProducts;
	}
}
	
	

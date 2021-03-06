package com.RestAPI.hosteloha.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.DAO.AllCategoryList;
import com.RestAPI.hosteloha.DAO.ProductImageInputDAO;
import com.RestAPI.hosteloha.DAO.ProductInputDAO;
import com.RestAPI.hosteloha.DAO.ProductOutputDAO;
import com.RestAPI.hosteloha.model.Cart;
import com.RestAPI.hosteloha.model.Category;
import com.RestAPI.hosteloha.model.CategoryFilter;
import com.RestAPI.hosteloha.model.CategoryList;
import com.RestAPI.hosteloha.model.CategorySubFilter;
import com.RestAPI.hosteloha.model.Condition;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.model.ProductImage;
import com.RestAPI.hosteloha.model.ProductPricing;
import com.RestAPI.hosteloha.model.ProductViews;
import com.RestAPI.hosteloha.model.UserProductWishlist;
import com.RestAPI.hosteloha.model.ViewsHour;
import com.RestAPI.hosteloha.repository.AllCategoryListRepository;
import com.RestAPI.hosteloha.repository.CartRepository;
import com.RestAPI.hosteloha.repository.CategoryFilterRepository;
import com.RestAPI.hosteloha.repository.CategoryRepository;
import com.RestAPI.hosteloha.repository.CategorySubFilterRepository;
import com.RestAPI.hosteloha.repository.ConditionRepository;
import com.RestAPI.hosteloha.repository.ProductImageRepository;
import com.RestAPI.hosteloha.repository.ProductOutputRepository;
import com.RestAPI.hosteloha.repository.ProductPricingRepository;
import com.RestAPI.hosteloha.repository.ProductRepository;
import com.RestAPI.hosteloha.repository.ProductViewsRepository;
import com.RestAPI.hosteloha.repository.UserProductWishlistRepository;
import com.RestAPI.hosteloha.repository.ViewsHourRepository;


@Service
@Transactional
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
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductViewsRepository productViewRepo;
	@Autowired
	private ViewsHourRepository viewsHourRepo;
	@Autowired
	private AllCategoryListRepository allcategorylistrepo;
	@Autowired
	private ProductImageRepository productimagerepo;
	@Autowired
	private ProductOutputRepository productoutputrepo;
	@Autowired
	private CartRepository cartrepo;


	public List<Product> getAllProducts() {
		
		List<Product> allproducts = productRepo.findAll();
		return allproducts;
	}

//	public void getProductsbyId(ArrayList<Integer> idlist) {
//		
//	}
	public Product addProduct(ProductInputDAO productInput) {
		int categoryId=0;
		String category = productInput.getCategory();
		String subcategory1= productInput.getSubcategory1();
		String subcategory2= productInput.getSubcategory2();
		
		 List<Integer> categoryIdList = categoryRepo.getCategoryId(category,subcategory1,subcategory2);
		 if(categoryIdList.size()!= 0) {
		 categoryId = (int) categoryIdList.get(0);
		 }
		 
		if(categoryIdList.size() == 0) {
			System.out.println("Inside adding new category combo");
			Category categoryobj = new Category();
			categoryobj.setCategory_name(category);
			categoryobj.setSub_category1(subcategory1);
			categoryobj.setSub_category2(subcategory2);
			categoryobj.setDescription("New category combo");
			System.out.println(categoryobj);
			Category savedCategory = categoryRepo.save(categoryobj);
			categoryId=savedCategory.getId();
		}
		
		Product product = new Product();
		product.setProduct_title(productInput.getProduct_title());
		product.setSubtitle(productInput.getSubtitle());
		product.setDescription(productInput.getDescription());
		product.setCategory_id(categoryId);
		product.setUsers_id(productInput.getUsers_id());
		product.setCurrency(productInput.getCurrency());
		product.setCost_price(productInput.getCost_price());
		product.setSelling_price(productInput.getSelling_price());
		product.setCondition_id(productInput.getCondition_id());
		product.setDelivery_format_id(productInput.getDelivery_format_id());
		product.setPayment_option_id(productInput.getPayment_option_id());
		product.setSelling_format_id(productInput.getSelling_format_id());
		Product savedproduct = productRepo.save(product);
		
		int productId= savedproduct.getId();
		ProductViews productView = new ProductViews();
		productView.setProduct_id(productId);
		ProductViews savedview = productViewRepo.save(productView);
		
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

	public CategoryFilter addSubCategory1(CategoryFilter categoryFilter) {

		CategoryFilter savedsubcategory1 = categoryFilterRepo.save(categoryFilter);
		return savedsubcategory1;
	}

	public CategorySubFilter addSubCategory2(CategorySubFilter categorySubFilter) {

		  CategorySubFilter savedsubcategory2 = subcategoryFilterRepo.save(categorySubFilter);
		return savedsubcategory2;
		
	}
	
	public String addCategoryList(CategoryList categorylist) {
		
		String category = categorylist.getCategory();
		String subcategory1 = categorylist.getSubcategory1();
		String subcategory2 = categorylist.getSubcategory2();
		
		int checkSubCategory1 = categoryFilterRepo.checkSubCategory1(category,subcategory1);
		
		if(checkSubCategory1==0) {
		CategoryFilter categoryFilter = new CategoryFilter();
		categoryFilter.setCategoryName(category);
		categoryFilter.setSubCategory(subcategory1);
		categoryFilterRepo.save(categoryFilter);
		}
		
		int checkSubCategory2 = subcategoryFilterRepo.checkSubCategory2(subcategory1,subcategory2);
		
		if(checkSubCategory2==0) {
		CategorySubFilter categorySubFilter = new CategorySubFilter();
		categorySubFilter.setSubcategory1(subcategory1);
		categorySubFilter.setSubcategory2(subcategory2);
		subcategoryFilterRepo.save(categorySubFilter);
		}
		return "Success";
		
	}

	public int updateProductViews(int product_id, int userid) {
	
		viewsHourRepo.deleteViewsMoreThanThreeHours();
		int getviewsHourForUser= viewsHourRepo.getviewsHourForUser(product_id, userid);
		if(getviewsHourForUser==0) {
		
		ViewsHour viewshour = new ViewsHour();
		viewshour.setProductid(product_id);
		viewshour.setUserid(userid);
		viewsHourRepo.save(viewshour);
		
		int getviewsHour = viewsHourRepo.getviewsHour(product_id);
		
		int updateAllViewCount = productViewRepo.updateAllViewCount(product_id, getviewsHour);
		return updateAllViewCount;
		}
		else return 0;
	}

//	public List<AllCategoryList> getAllCategoryList() {
//		
//		List<AllCategoryList> allCategoryList = allcategorylistrepo.getAllCategoryList();
//		return allCategoryList;
//	}

	public Map<String, Set<String>> finalCategoryListtoFE() {
		
		List<AllCategoryList> allCategoryList = allcategorylistrepo.getAllCategoryList();
		
		Map<String, Set<String>> finallist = new HashMap<String, Set<String>>();
		
		Set<String> categorynamelist = new HashSet<String>();
		
		
		for( AllCategoryList list : allCategoryList) {
			categorynamelist.add(list.getCategoryname());
		}
		System.out.println(categorynamelist);
		
		Set<String> subcategorylist1 = new HashSet<String>();
		
		for( AllCategoryList list : allCategoryList) {
			subcategorylist1.add(list.getSubcategory1());
		}
		
//		Set<String> subcategorylist2 = new HashSet<String>();
//		
//		for( AllCategoryList list : allCategoryList) {
//			categorynamelist.add(list.getSubcategory2());
//		}
//		
		finallist.put("root",categorynamelist);
		
		for(String clist : categorynamelist) {
			
			Set<String> templist = new HashSet<String>();
			
			for(AllCategoryList list1 : allCategoryList) {
				if(list1.getCategoryname().equals(clist)) {
					templist.add(list1.getSubcategory1());
				}
				
			}
			
			finallist.put(clist, templist);
		}
			
		for(String sclist : subcategorylist1) {
			
			
			Set<String> templist = new HashSet<String>();
			
			for(AllCategoryList list1 : allCategoryList) {
				if(list1.getSubcategory1().equals(sclist)) {
					templist.add(list1.getSubcategory2());
			
				}
				
			}
			
			finallist.put(sclist, templist);
		}
		
		
		System.out.println(finallist);
		return finallist;
	}

	public Product updateProduct(Product product) {
		
		Product savedproduct = productRepo.save(product);
		return savedproduct;
	}

	public String addProductImages(ProductImageInputDAO productimagelist) {
		
		
		for(String image : productimagelist.getImageURL())
		{
			ProductImage productimage = new ProductImage();
			productimage.setProductid(productimagelist.getProductid());
			productimage.setImageURL(image);
			ProductImage savedimages = productimagerepo.save(productimage);
		}
		
		return "sucess";
	}

	public int updateProductState(int productid, String state) {
		
		System.out.println(productid+"---------------"+state);
		int result = productRepo.updateProductState(productid,state);
		return result;
		
	}

	public Page<Product> getAllProductsByPages(int pagenumber, int pagesize, String sortingtype, String sortby) {
		Direction sorttype=null;
		if(sortingtype.equalsIgnoreCase("ASC")) {
			 sorttype = Direction.ASC;
		} else {
			 sorttype = Direction.DESC;
		}

		System.out.println(sortby);
		Page<Product> findAll = productRepo.findAll(PageRequest.of(pagenumber, pagesize, sorttype, sortby));
		return findAll;
	}
	
	public Page<Product> getAllProductsByCategoryPages(String category,int pagenumber, int pagesize, String sortingtype, String sortby) {
		Direction sorttype=null;
		if(sortingtype.equalsIgnoreCase("ASC")) {
			 sorttype = Direction.ASC;
		} else {
			 sorttype = Direction.DESC;
		}

		System.out.println(category);
//		List<Integer> idlist = categoryRepo.getCategoryIdByCategoryName(category);
//		System.out.println(idlist);
		
		if(sortby.equalsIgnoreCase("views_count")) {
		
			Page<Product> findpopularbycategory = productRepo.findByProductProductViewsViews_count(category,PageRequest.of(pagenumber, pagesize));
			return findpopularbycategory;
		}
		else {
		
		Page<Product> findAllByCategory = productRepo.findProductsByCategoryName(category,PageRequest.of(pagenumber, pagesize, sorttype, sortby));
		System.out.println(findAllByCategory);
		return findAllByCategory;
		}
		
	}

	public Optional<Product> getProductById(int productid) {
		 Optional<Product> product = productRepo.findById(productid);	
		return product;
	}

	public List<Product> getProductsOfUser(int userid) {
		List<Product> userproducts = productRepo.findByUsersId(userid);
		return userproducts;
	}

	public Cart addToCart(Cart cart) {
		
		Cart savedcart = cartrepo.save(cart);
		return savedcart;
	}

	public List<Cart> getUserCartProducts(int userid) {
		List<Cart> usercartproducts = cartrepo.findByUserId(userid);
		return usercartproducts;
		
	}

	
}

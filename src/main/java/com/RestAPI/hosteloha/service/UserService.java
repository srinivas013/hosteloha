package com.RestAPI.hosteloha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.DAO.UserWishListOutputDAO;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.model.Roles;
import com.RestAPI.hosteloha.model.SellerFollower;
import com.RestAPI.hosteloha.model.User;
import com.RestAPI.hosteloha.model.UserPrivacy;
import com.RestAPI.hosteloha.model.UserProductWishlist;
import com.RestAPI.hosteloha.model.UserReview;
import com.RestAPI.hosteloha.repository.ProductRepository;
import com.RestAPI.hosteloha.repository.RolesRepository;
import com.RestAPI.hosteloha.repository.SellerFollowerRepository;
import com.RestAPI.hosteloha.repository.UserPrivacyRepository;
import com.RestAPI.hosteloha.repository.UserProductWishlistRepository;
import com.RestAPI.hosteloha.repository.UserRepository;
import com.RestAPI.hosteloha.repository.UserReviewRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserPrivacyRepository userprivacyRepo;
	@Autowired
	private UserReviewRepository userreviewRepo;
	@Autowired
	private SellerFollowerRepository sellerFollowerRepo;
	@Autowired
	private UserProductWishlistRepository whislistRepo;
	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private ProductRepository productRepo;
	
	
	public List<User> getAllUsers() {
	
	List<User> users = userRepo.findAll();
	
	return users;
	
	}
	
	public User addNewUser(User user) {
		
		User saveduser = userRepo.save(user);
		return saveduser;
	}

	public List<UserPrivacy> getAllUserPrivacy() {
		System.out.println("service");
		List<UserPrivacy> list = userprivacyRepo.findAll();
		System.out.println(list);
		return list;
		
	}

	public UserPrivacy addUserPrivacytype(UserPrivacy userprivacy) {
		
		UserPrivacy savedone = userprivacyRepo.save(userprivacy);
		
		return savedone;
		
	}

	public List<UserReview> getallreviews() {
		
		List<UserReview> allreviews = userreviewRepo.findAll();
		
		return allreviews;
	}

	public List<UserReview> getallreviewsByID(int id) {
	
		List<UserReview> findBySellerId = userreviewRepo.findBySellerId(id);
		
//		int reviewcount=findBySellerId.size();
//		List<UserReviewDAO> reviewList = new ArrayList<UserReviewDAO>();
//		for (UserReview review : findBySellerId) {
//			
//			UserReviewDAO reviewDAO = new UserReviewDAO();
//			reviewDAO.setId(review.getId());
//			reviewDAO.setsellerId(review.getsellerId());
//			reviewDAO.setBuyer_id(review.getBuyer_id());
//			reviewDAO.setReview_rating(review.getReview_rating());
//			reviewDAO.setReview_description(review.getReview_description());
//			reviewDAO.setInserted_at(review.getInserted_at());
//			reviewDAO.setUpdated_at(review.getUpdated_at());
//		}
//		
		return findBySellerId;
		
	}

	public UserReview addUserReview(UserReview review) {
	
		UserReview savedReview = userreviewRepo.save(review);
		
		return savedReview;
		
	}

	public int updateUpvotes(UserReview review) {
		
		int id = review.getId();
		int updatedUpvotes = userreviewRepo.updateUpvotes(id);
		return updatedUpvotes;	
	}

	public List<SellerFollower> getSellerFollowers(int sellerID) {
		
		List<SellerFollower> sellerFollowersList = sellerFollowerRepo.findBySellerID(sellerID);
		
		return sellerFollowersList;
	}

	public SellerFollower addSellerFollwer(SellerFollower follower) {

		SellerFollower savedFollower = sellerFollowerRepo.save(follower);
		
		return savedFollower;
	
	}

	
	
	public UserWishListOutputDAO getUserWishlist(int id) {
		
		List<UserProductWishlist> wishlist = whislistRepo.findByUserID(id);
		
		List<Integer> productids = new ArrayList<Integer>();
		for(UserProductWishlist i : wishlist) {
			
			productids.add(i.getProduct_id());
		}
		
		List<Product> productsbyId = productRepo.getProductsbyId(productids);
//		System.out.println(productids);
//		System.out.println(productsbyId);
		
		UserWishListOutputDAO outputWishList = new UserWishListOutputDAO(id,productsbyId);
		
		return outputWishList;
	}

	public UserProductWishlist addToWishlist(UserProductWishlist wishitem) {
		
		UserProductWishlist saveditem = whislistRepo.save(wishitem);
		return saveditem;
	}

	public List<Roles> getRoles() {
		
		List<Roles> allRoles = rolesRepo.findAll();
		return allRoles;
		
	}

	public Roles addNewRole(Roles role) {
		
		Roles savedRole = rolesRepo.save(role);
		return savedRole;
	}
}

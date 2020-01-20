package com.RestAPI.hosteloha.controller;

import java.net.URI;
import java.sql.Date;
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

import com.RestAPI.hosteloha.model.SellerFollower;
import com.RestAPI.hosteloha.model.User;
import com.RestAPI.hosteloha.model.UserPrivacy;
import com.RestAPI.hosteloha.model.UserProductWishlist;
import com.RestAPI.hosteloha.model.UserReview;
import com.RestAPI.hosteloha.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		
		return users;
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		
//		User user= new User( 100001,  2,  2, 6374637, "password11", "vinay",
//				 "kumar",  "Nit warangal",  "nitw.in",  "30101996",  "hyd",  "andhra",
//				 534250,  "India", "palakol",  "hyd",  "48454",  1,
//				 1, 1,  "987456",  "23122019");
		
		User saveduser = userService.addNewUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/userprivacy")
	public List<UserPrivacy> getAllUserPrivacy() {
		
		List<UserPrivacy> allUserPrivacy = userService.getAllUserPrivacy();
		
		return allUserPrivacy;
		
	}
	
	@PostMapping("/addUserPrivacytype")
	public ResponseEntity<Object> addUserPrivacytype(@RequestBody UserPrivacy userPrivacy) {
		
	
		UserPrivacy addedtype = userService.addUserPrivacytype(userPrivacy);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedtype.getId()).toUri();
		
		return ResponseEntity.created(location).build();
				
	}
	
	@GetMapping("/userreviews")
	public List<UserReview> getallreviews() {
		
		List<UserReview> getallreviews = userService.getallreviews();
		
		return getallreviews;
		
	}
	
	@GetMapping("/getsellerreview/{id}")
	public List<UserReview> getSellerReview(@PathVariable int id) {
		
		List<UserReview> getallreviewsByID = userService.getallreviewsByID(id);
		
		return getallreviewsByID;
	}
	
	@PostMapping("/addReview")
	public ResponseEntity<Object> addUserReview(@RequestBody UserReview review) {
		
		UserReview savedreview = userService.addUserReview(review);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedreview.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/sellerFollowers/{sellerID}")
	public List<SellerFollower> getSellerFollowers(@PathVariable int sellerID) {
		
		List<SellerFollower> sellerFollowers = userService.getSellerFollowers(sellerID);
		
		return sellerFollowers;
		
		}
	@PostMapping("/addFollower")
	public SellerFollower addSellerFollwer(@RequestBody SellerFollower follower) {
		
		SellerFollower addedFollower = userService.addSellerFollwer(follower);
		
		return addedFollower;
	}
	
	@PostMapping("/userreviews/updateupvotes") 
	public int updateUpvotes(@RequestBody UserReview review) {
		
		int updatedUpvotes = userService.updateUpvotes(review);
		
		return updatedUpvotes;
	}
	
	@GetMapping("/{userid}/wishlist")
	public List<UserProductWishlist> getUserWishList(@PathVariable int userid) {
		
		List<UserProductWishlist> userWishlist = userService.getUserWishlist(userid);
		return userWishlist;
	}
	
	@PostMapping("/wishlist")
	public ResponseEntity<UserProductWishlist> addToWishlist(@RequestBody UserProductWishlist wishitem) {
		
		UserProductWishlist addedToWishlist = userService.addToWishlist(wishitem);
		return new ResponseEntity<UserProductWishlist>(HttpStatus.CREATED);
	}
	
	

}
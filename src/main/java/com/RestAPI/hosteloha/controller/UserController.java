package com.RestAPI.hosteloha.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestAPI.hosteloha.DAO.AuthenticationRequest;
import com.RestAPI.hosteloha.DAO.AuthenticationResponse;
import com.RestAPI.hosteloha.DAO.UserWishListOutputDAO;
import com.RestAPI.hosteloha.model.Roles;
import com.RestAPI.hosteloha.model.SellerFollower;
import com.RestAPI.hosteloha.model.User;
import com.RestAPI.hosteloha.model.UserPrivacy;
import com.RestAPI.hosteloha.model.UserProductWishlist;
import com.RestAPI.hosteloha.model.UserReview;
import com.RestAPI.hosteloha.service.MyUserDetailsService;
import com.RestAPI.hosteloha.service.UserService;
import com.RestAPI.hosteloha.util.JwtUtil;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
					);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		
		return users;
		
	}
	@Cacheable(value="defaultCache", key="#id")
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		
		Optional<User> userById = userService.getUserById(id);
		
		return userById;
		
	}
	
	
	
	@PostMapping("/add_user")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		
//		User user= new User( 100001,  2,  2, 6374637, "password11", "vinay",
//				 "kumar",  "Nit warangal",  "nitw.in",  "30101996",  "hyd",  "andhra",
//				 534250,  "India", "palakol",  "hyd",  "48454",  1,
//				 1, 1,  "987456",  "23122019");
		
		User saveduser = userService.addNewUser(user);
		
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		
		return new ResponseEntity<Object>(saveduser, HttpStatus.CREATED);
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
	
	@GetMapping("/roles")
	public List<Roles> getRoles() {
		List<Roles> roles = userService.getRoles();
		return roles;
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Object> addRole(@RequestBody Roles role) {
		
		Roles addedRole = userService.addNewRole(role);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedRole.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/userreviews")
	public List<UserReview> getallreviews() {
		
		List<UserReview> getallreviews = userService.getallreviews();
		
		return getallreviews;
		
	}
	@Cacheable(value="defaultCache", key="#id")
	@GetMapping("/userreviews/{id}")
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
	
	@PostMapping("/userreviews/updateupvotes") 
	public int updateUpvotes(@RequestBody UserReview review) {
		
		int updatedUpvotes = userService.updateUpvotes(review);
		
		return updatedUpvotes;
	}
	
	@Cacheable(value="defaultCache", key="#sellerID")
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
	
	@Cacheable(value="defaultCache", key="#userid")
	@GetMapping("/{userid}/wishlist")
	public UserWishListOutputDAO getUserWishList(@PathVariable int userid) {
	
		UserWishListOutputDAO userWishlist = userService.getUserWishlist(userid);
		return userWishlist;
	}
	
	@PostMapping("/wishlist")
	public ResponseEntity<UserProductWishlist> addToWishlist(@RequestBody UserProductWishlist wishitem) {
		
		UserProductWishlist addedToWishlist = userService.addToWishlist(wishitem);
		return new ResponseEntity<UserProductWishlist>(HttpStatus.CREATED);
	}
	
}

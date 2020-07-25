package com.RestAPI.hosteloha.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.UserProductWishlist;

@Repository
public interface UserProductWishlistRepository extends JpaRepository<UserProductWishlist, Integer> {

	List<UserProductWishlist> findByUserID(int id) throws EntityNotFoundException;

	@Modifying
	@Query(value="delete from user_product_wishlist where users_id= :userid and product_id= :productid", nativeQuery = true)
	int removeFromWishlist(@Param("userid") int userid,@Param("productid") int productid);

}

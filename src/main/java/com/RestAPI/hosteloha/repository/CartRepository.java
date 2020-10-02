package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query(value = "select * from cart where user_id = :userid", nativeQuery = true)
	List<Cart> findByUserId(@Param("userid") int userid);

	
}

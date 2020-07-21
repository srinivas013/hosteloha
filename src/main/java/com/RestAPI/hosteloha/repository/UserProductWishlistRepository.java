package com.RestAPI.hosteloha.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.UserProductWishlist;

@Repository
public interface UserProductWishlistRepository extends JpaRepository<UserProductWishlist, Integer> {

	List<UserProductWishlist> findByUserID(int id) throws EntityNotFoundException;

}

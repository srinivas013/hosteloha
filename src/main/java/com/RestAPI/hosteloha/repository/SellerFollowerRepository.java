package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPI.hosteloha.model.SellerFollower;

public interface SellerFollowerRepository extends JpaRepository<SellerFollower, Integer> {

	List<SellerFollower> findBySellerID(int sellerID);

}

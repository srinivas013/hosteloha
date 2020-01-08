package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.ProductPricing;

@Repository
public interface ProductPricingRepository extends JpaRepository<ProductPricing, Integer> {

	List<ProductPricing> findByProductID(int productid);

	
}

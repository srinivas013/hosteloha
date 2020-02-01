package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.ProductViews;

@Repository
public interface ProductViewsRepository extends JpaRepository<ProductViews, Integer>{

	@Modifying
	@Query(value = "update product_views set views_hour= :viewshour, views_count = (views_count+1) where product_id= :productid ",
			nativeQuery = true)
	public int updateAllViewCount(@Param("productid")int product_id, @Param("viewshour") int viewshour);
}

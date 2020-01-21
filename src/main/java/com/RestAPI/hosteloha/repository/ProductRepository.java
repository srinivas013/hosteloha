package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.service.ProductService;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from product where id IN :list" , nativeQuery = true)
	List<Product> getProductsbyId(@Param("list")List<Integer> productids);

}

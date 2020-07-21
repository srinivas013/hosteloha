package com.RestAPI.hosteloha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RestAPI.hosteloha.DAO.ProductOutputDAO;
import com.RestAPI.hosteloha.model.Product;

public interface ProductOutputRepository extends JpaRepository<ProductOutputDAO, Integer>{

	@Query(value="select * from allpopularproducts where category_name = :category", nativeQuery = true)
	Page<Product> findProductsByCategoryName(@Param("category")String category, Pageable pageable);

}

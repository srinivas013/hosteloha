package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "select id from category where category_name= :category and sub_category1 = :subcategory1 and sub_category2 =:subcategory2", nativeQuery = true)
	List<Integer> getCategoryId(@Param("category") String category,@Param("subcategory1") String subcategory1,@Param("subcategory2") String subcategory2);


	@Query(value = "select id from category where category_name= :category", nativeQuery = true)
	List<Integer> getCategoryIdByCategoryName(@Param("category") String category);
}

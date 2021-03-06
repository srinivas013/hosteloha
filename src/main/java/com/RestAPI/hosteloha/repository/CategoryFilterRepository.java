package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.DAO.AllCategoryList;
import com.RestAPI.hosteloha.model.CategoryFilter;
import com.RestAPI.hosteloha.model.CategoryFilterPkey;

@Repository
public interface CategoryFilterRepository extends JpaRepository<CategoryFilter, CategoryFilterPkey>{

	@Query(value= "select distinct category_name from category_filter", nativeQuery = true)
	List<String> findByCategoryName();

	@Query(value= "select distinct sub_category1 from category_filter where category_name = :categoryname" , nativeQuery = true)
	List<String> getsubCategoryByCategory(@Param("categoryname") String categoryname);

	@Query(value= "select count(*) from category_filter where category_name = :categoryname and sub_category1 = :subcategory1 " , nativeQuery = true)
	int checkSubCategory1(@Param("categoryname")String category,@Param("subcategory1") String subcategory1);
	
}

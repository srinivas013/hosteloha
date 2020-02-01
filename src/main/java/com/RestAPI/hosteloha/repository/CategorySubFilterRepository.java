package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RestAPI.hosteloha.model.CategorySubFilter;
import com.RestAPI.hosteloha.model.CategorySubFilterKey;

public interface CategorySubFilterRepository extends JpaRepository<CategorySubFilter, CategorySubFilterKey> {

	@Query(value = "select distinct sub_category2 from category_subfilter where sub_category1 = :subcategory1" , nativeQuery = true)
	List<String> getsubCategoryBySubCategory(@Param("subcategory1") String subcategory1);

	@Query(value= "select count(*) from category_subfilter where sub_category1 = :subcategory1 and sub_category2 = :subcategory2 " , nativeQuery = true)
	int checkSubCategory2(@Param("subcategory1")String subcategory1,@Param("subcategory2") String subcategory2);

}

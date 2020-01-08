package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RestAPI.hosteloha.model.CategorySubFilter;
import com.RestAPI.hosteloha.model.CategorySubFilterKey;

public interface CategorySubFilterRepository extends JpaRepository<CategorySubFilter, CategorySubFilterKey> {

	@Query(value = "select sub_category2 from category_subfilter where subcategory1 = :subcategory1" , nativeQuery = true)
	List<String> getsubCategoryBySubCategory(@Param("subcategory1") String subcategory1);

}

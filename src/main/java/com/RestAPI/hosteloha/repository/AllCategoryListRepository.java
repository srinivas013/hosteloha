package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.DAO.AllCategoryList;
import com.RestAPI.hosteloha.DAO.AllCategoryListKey;

@Repository
public interface AllCategoryListRepository extends JpaRepository<AllCategoryList, AllCategoryListKey> {

	@Query(value = "select * from allcategorylist" , nativeQuery = true)
	List<AllCategoryList> getAllCategoryList();
}

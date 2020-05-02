package com.RestAPI.hosteloha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.UserReview;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Integer>{

	List<UserReview> findBySellerId(int id);

	@Modifying
	@Query(value= "update UserReview a set a.review_upvotes = a.review_upvotes+1 where a.id = :id")
	@Transactional
	int updateUpvotes(@Param("id") int id);
	
}

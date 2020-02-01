package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.ViewsHour;

@Repository
public interface ViewsHourRepository extends JpaRepository<ViewsHour, Integer> {

	@Query(value ="select count(*) from viewshour where viewed_at between sysdate() - interval '1' Hour and sysdate() "
			+ "and productid = :productid", nativeQuery = true)
	public int getviewsHour(@Param("productid") int ProductId);
}

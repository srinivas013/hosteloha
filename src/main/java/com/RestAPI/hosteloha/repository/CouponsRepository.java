package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Coupons;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Integer> {

}

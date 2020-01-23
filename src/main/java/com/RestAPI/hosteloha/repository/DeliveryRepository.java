package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.DeliveryFormat;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryFormat, Integer>{

	
}

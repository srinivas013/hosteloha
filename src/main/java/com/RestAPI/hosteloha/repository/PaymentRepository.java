package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.PaymentOption;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentOption, Integer>{

}

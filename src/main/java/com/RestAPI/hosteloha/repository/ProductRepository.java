package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

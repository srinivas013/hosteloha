package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer> {

	
}

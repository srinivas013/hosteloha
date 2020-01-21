package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

	
}

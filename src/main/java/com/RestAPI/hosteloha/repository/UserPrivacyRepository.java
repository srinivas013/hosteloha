package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.UserPrivacy;

@Repository
public interface UserPrivacyRepository extends JpaRepository<UserPrivacy, Integer>{

	
}

package com.RestAPI.hosteloha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByFirstname(String username);

	public User findByEmail(String username);

}

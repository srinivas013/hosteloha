package com.RestAPI.hosteloha.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RestAPI.hosteloha.model.Roles;
import com.RestAPI.hosteloha.repository.RolesRepository;
import com.RestAPI.hosteloha.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RolesRepository rolesRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.RestAPI.hosteloha.model.User user = userRepo.findByFirstname(username);
		Optional<Roles> role = rolesRepo.findById(user.getRoles_id());
		
        return User.withUsername(user.getFirst_name())
        		.password(user.getPassword())
        		.roles(role.get().getName()).build();
	}

}

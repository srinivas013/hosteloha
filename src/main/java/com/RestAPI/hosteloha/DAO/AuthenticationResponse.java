package com.RestAPI.hosteloha.DAO;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private final String jwt;
	private int id;
	private int Expirationdays;
	
	public AuthenticationResponse(String jwt, int id, int expirationdays) {
		super();
		this.jwt = jwt;
		this.id = id;
		Expirationdays = expirationdays;
	}

	public int getId() {
		return id;
	}

	public int getExpirationdays() {
		return Expirationdays;
	}

	public String getJwt() {
		return jwt;
	}
	
}


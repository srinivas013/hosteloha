package com.RestAPI.hosteloha.DAO;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthenticationResponse implements Serializable {

	private final String jwt;
	private int id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expirationDate;
	
	public AuthenticationResponse(String jwt, int id, Date expirationDate) {
		this.jwt = jwt;
		this.id = id;
		this.expirationDate = expirationDate;
	}
	public String getJwt() {
		return jwt;
	}
	public int getId() {
		return id;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}

	
}


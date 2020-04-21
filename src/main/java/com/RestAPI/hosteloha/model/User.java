package com.RestAPI.hosteloha.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	private int id;
	private int roles_id;
	private int user_privacy_id;
	private long phone;
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="first_name")
	private String firstname;
	private String last_name;
	private String university_name;
	private String university_website;
	private String dob;
	private String city;
	private String state;
	private int zip;
	private String country;
	private String res_address_1;
	private String res_address_2;
	private String phone_ext;
	private String ip_address;
	private int is_active;
	private int is_university_verified;
	private int is_mail_verified;
	private String verification_code;
	private String registration_date;
	@Column(insertable=false,updatable = false)
	private Date inserted_at;
	@Column(insertable=false, updatable = false)
	private Date updated_at;
	
	
	public User() {
		super();
	}


	public User(int id, int roles_id, int user_privacy_id, long phone, String email, String password, String firstname,
			String last_name, String university_name, String university_website, String dob, String city, String state,
			int zip, String country, String res_address_1, String res_address_2, String phone_ext, String ip_address,
			int is_active, int is_university_verified, int is_mail_verified, String verification_code,
			String registration_date, Date inserted_at, Date updated_at) {
		super();
		this.id = id;
		this.roles_id = roles_id;
		this.user_privacy_id = user_privacy_id;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.last_name = last_name;
		this.university_name = university_name;
		this.university_website = university_website;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.res_address_1 = res_address_1;
		this.res_address_2 = res_address_2;
		this.phone_ext = phone_ext;
		this.ip_address = ip_address;
		this.is_active = is_active;
		this.is_university_verified = is_university_verified;
		this.is_mail_verified = is_mail_verified;
		this.verification_code = verification_code;
		this.registration_date = registration_date;
		this.inserted_at = inserted_at;
		this.updated_at = updated_at;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRoles_id() {
		return roles_id;
	}


	public void setRoles_id(int roles_id) {
		this.roles_id = roles_id;
	}


	public int getUser_privacy_id() {
		return user_privacy_id;
	}


	public void setUser_privacy_id(int user_privacy_id) {
		this.user_privacy_id = user_privacy_id;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUniversity_name() {
		return university_name;
	}


	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}


	public String getUniversity_website() {
		return university_website;
	}


	public void setUniversity_website(String university_website) {
		this.university_website = university_website;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRes_address_1() {
		return res_address_1;
	}


	public void setRes_address_1(String res_address_1) {
		this.res_address_1 = res_address_1;
	}


	public String getRes_address_2() {
		return res_address_2;
	}


	public void setRes_address_2(String res_address_2) {
		this.res_address_2 = res_address_2;
	}


	public String getPhone_ext() {
		return phone_ext;
	}


	public void setPhone_ext(String phone_ext) {
		this.phone_ext = phone_ext;
	}


	public String getIp_address() {
		return ip_address;
	}


	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}


	public int getIs_active() {
		return is_active;
	}


	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}


	public int getIs_university_verified() {
		return is_university_verified;
	}


	public void setIs_university_verified(int is_university_verified) {
		this.is_university_verified = is_university_verified;
	}


	public int getIs_mail_verified() {
		return is_mail_verified;
	}


	public void setIs_mail_verified(int is_mail_verified) {
		this.is_mail_verified = is_mail_verified;
	}


	public String getVerification_code() {
		return verification_code;
	}


	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}


	public String getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}


	public Date getInserted_at() {
		return inserted_at;
	}


	public void setInserted_at(Date inserted_at) {
		this.inserted_at = inserted_at;
	}


	public Date getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	

}

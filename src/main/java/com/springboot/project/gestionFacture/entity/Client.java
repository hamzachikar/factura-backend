package com.springboot.project.gestionFacture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="cin")
	private String cin;
	@Column(name="address")
	private String address;
	@Column(name="postal_code")
	private int postalCode;
	@Column(name="city")
	private String city;
	@Column(name="social_raison")
	private String socialRaison;
	@Column(name="phone_num")
	private String phoneNum;
	@Column(name="email")
	private String email;
	@ManyToOne
	private User adminUser;
	public Client() {
	}

	public Client(String name, String cin, String address, int postalCode, String city, String socialRaison,
			String phoneNum, String email, User adminUser) {
		this.name = name;
		this.cin = cin;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.socialRaison = socialRaison;
		this.phoneNum = phoneNum;
		this.email = email;
		this.adminUser = adminUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSocialRaison() {
		return socialRaison;
	}

	public void setSocialRaison(String socialRaison) {
		this.socialRaison = socialRaison;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(User adminUser) {
		this.adminUser = adminUser;
	}
	
	
	
}

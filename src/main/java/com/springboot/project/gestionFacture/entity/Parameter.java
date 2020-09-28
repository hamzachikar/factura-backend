package com.springboot.project.gestionFacture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parameter")
public class Parameter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="company_name")
	private String companyName;
	@Column(name="company_phone")
	private String companyPhone;
	@Column(name="company_address")
	private String companyAddr;
	@Column(name="company_email")
	private String companyEmail;
	@Column(name="company_logo",length = 26777215)
	private byte[] companyLogo;
	@Column(name="company_sign",length = 26777215)
	private byte[] companySign;
	@Column(name="company_cash",length = 26777215)
	private byte[] companyCash;
	@OneToOne(cascade = CascadeType.DETACH)
	private User adminUser;
	public Parameter() {
	}
	
	public Parameter(String companyName, String companyPhone, String companyAddr, String companyEmail,
			byte[] companyLogo, byte[] companySign, byte[] companyCash, User adminUser) {
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.companyAddr = companyAddr;
		this.companyEmail = companyEmail;
		this.companyLogo = companyLogo;
		this.companySign = companySign;
		this.companyCash = companyCash;
		this.adminUser = adminUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public byte[] getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}
	public byte[] getCompanySign() {
		return companySign;
	}
	public void setCompanySign(byte[] companySign) {
		this.companySign = companySign;
	}
	public byte[] getCompanyCash() {
		return companyCash;
	}
	public void setCompanyCash(byte[] companyCash) {
		this.companyCash = companyCash;
	}

	public User getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(User adminUser) {
		this.adminUser = adminUser;
	}
	
}

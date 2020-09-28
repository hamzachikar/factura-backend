package com.springboot.project.gestionFacture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name_product")
	private String nameP;
	@Column(name="price")
	private double prixAchat;
	@Column(name="prixVente")
	private double prixVente;
	@Column(name="quantite_stock")
	private int quantite;
	@Column(name="reference")
	private String reference;
	@ManyToOne(cascade = CascadeType.DETACH)
	private  User user;
	@Column(name="product_image")
	private byte[] imageP;
	public Produit() {
	}
	public Produit(int id, String nameP, double prixAchat, double prixVente, int quantite, String reference, User user,
			byte[] imageP) {
		this.id = id;
		this.nameP = nameP;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.quantite = quantite;
		this.reference = reference;
		this.user = user;
		this.imageP = imageP;
	}
	public Produit(String nameP, double prixAchat, double prixVente, int quantite, String reference, User user,
			byte[] imageP) {
		this.nameP = nameP;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.quantite = quantite;
		this.reference = reference;
		this.user = user;
		this.imageP = imageP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public byte[] getImageP() {
		return imageP;
	}
	public void setImageP(byte[] imageP) {
		this.imageP = imageP;
	}
	
}

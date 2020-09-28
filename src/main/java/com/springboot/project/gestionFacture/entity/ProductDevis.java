package com.springboot.project.gestionFacture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productDevis")
public class ProductDevis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne(cascade = CascadeType.DETACH)
	private Produit produit;
	@Column(name="quantite")
	private double quantite;
	@Column(name="unite")
	private String unite;
	public ProductDevis() {
	}
	public ProductDevis(int id, Produit produit, double quantite, String unite) {
		this.id = id;
		this.produit = produit;
		this.quantite = quantite;
		this.unite = unite;
	}
	public ProductDevis(Produit produit, double quantite, String unite) {
		this.produit = produit;
		this.quantite = quantite;
		this.unite = unite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}

}

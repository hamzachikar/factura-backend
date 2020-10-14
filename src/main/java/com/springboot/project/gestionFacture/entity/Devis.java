package com.springboot.project.gestionFacture.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="devis")
public class Devis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="resolve_date")
	private Date resolveDate;
	@ManyToOne(cascade = CascadeType.DETACH)
	private Client client;
	@ManyToOne(cascade = CascadeType.DETACH)
	private User user;
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<ProductDevis> products;
	@Column(name="reference")
	private String reference;
	@Column(name="tva")
	private double tva;
	@Column(name="total_ht")
	private double totalHT;
	@Column(name="total_ttc")
	private double totalTTC;
	@Column(name="status")
	private String status;
	public Devis() {
	}

	public Devis(Date createDate,Date resolveDate, Client client, User user, List<ProductDevis> products, String reference, double tva, String status) {
		this.createDate = createDate;
		this.client = client;
		this.user = user;
		this.products = products;
		this.reference = reference;
		this.tva = tva;
		this.status = status;
		this.resolveDate=resolveDate;
		this.calculateTotals();
	}

	public Devis(int id, Date createDate,Date resolveDate, Client client, User user, List<ProductDevis> products, String reference,
			double tva, String status) {
		this.id = id;
		this.createDate = createDate;
		this.client = client;
		this.user = user;
		this.products = products;
		this.reference = reference;
		this.tva = tva;
		this.status = status;
		this.resolveDate=resolveDate;
		this.calculateTotals();
	}

	private void calculateTotals() {
		double totalTTC=0;
		double totalHT=0;
		for(ProductDevis p:this.products) {
			totalHT=totalHT+(p.getProduit().getPrixVente()*p.getQuantite());
		}
		totalTTC=totalHT+(totalHT*(this.tva/100));
		this.totalHT=totalHT;
		this.totalTTC=totalTTC;
	}
	public void addProduct(ProductDevis p) {
		this.products.add(p);
		this.calculateTotals();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ProductDevis> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDevis> products) {
		this.products = products;
		this.calculateTotals();
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
		this.calculateTotals();
	}
	public double getTotalHT() {
		return totalHT;
	}
	public void setTotalHT(double totalHT) {
		this.totalHT = totalHT;
	}
	public double getTotalTTC() {
		return totalTTC;
	}
	public void setTotalTTC(double totalTTC) {
		this.totalTTC = totalTTC;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}
}

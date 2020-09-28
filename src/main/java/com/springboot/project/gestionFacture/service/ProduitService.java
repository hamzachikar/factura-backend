package com.springboot.project.gestionFacture.service;

import java.util.List;
import java.util.Optional;

import com.springboot.project.gestionFacture.entity.Produit;


public interface ProduitService {
	List<Produit> getProduits();
	Optional<Produit> getProduitById(int theId);
	void deleteProduit(int theId);
	Produit save(Produit produit);
}

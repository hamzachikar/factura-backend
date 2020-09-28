package com.springboot.project.gestionFacture.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.gestionFacture.entity.Produit;
import com.springboot.project.gestionFacture.entity.User;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	public List<Produit> findByUser(User user);
}

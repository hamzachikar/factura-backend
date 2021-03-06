package com.springboot.project.gestionFacture.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.Produit;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.entity.UserAuthS;
import com.springboot.project.gestionFacture.jparepo.ProduitRepository;
import com.springboot.project.gestionFacture.security.MyUserDetails;
import com.springboot.project.gestionFacture.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{
	@Autowired
	private ProduitRepository repo;
	@Override
	public List<Produit> getAllProduits() {
		List<Produit> products=new ArrayList<Produit>();
		if(UserAuthS.getAuthUser().getRole().equals("admin")) {
			products=this.repo.findByUser(UserAuthS.getAuthUser());
		}
		else {
			products=this.repo.findByUser(UserAuthS.getAuthUser().getAdminUser());
		}
		return products;
	}

	@Override
	public Optional<Produit> getProduitById(int theId) {
		return this.repo.findById(theId);
	}

	@Override
	public void deleteProduit(int theId) {
		User adminUser =this.getAdminUser();
		Produit prod=this.repo.findById(theId).get();
		if(prod!=null) {
			if(prod.getUser().getId()==adminUser.getId()) {
				this.repo.delete(prod);
			}
		}
		
	}

	@Override
	public Produit save(Produit produit) {
		produit.setUser(this.getAdminUser());
		return this.repo.save(produit);
	}
	private User getAdminUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User adminUser=null;
		if(((MyUserDetails) auth.getPrincipal()).getUser().getRole().equals("admin")) {
			adminUser=((MyUserDetails) auth.getPrincipal()).getUser();
		}
		else {
			adminUser=((MyUserDetails) auth.getPrincipal()).getUser().getAdminUser();
		}
		return adminUser;
	}
}

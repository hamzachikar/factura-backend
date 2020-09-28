package com.springboot.project.gestionFacture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.ProductDevis;
import com.springboot.project.gestionFacture.jparepo.ProductDevisRepository;
import com.springboot.project.gestionFacture.service.ProductDevisService;

@Service
public class ProductDevisServiceImpl implements ProductDevisService{
	@Autowired
	private ProductDevisRepository repo;
	@Override
	public ProductDevis save(ProductDevis p) {
		return this.repo.save(p);
	}

}

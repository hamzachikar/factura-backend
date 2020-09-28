package com.springboot.project.gestionFacture.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.Devis;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.jparepo.DevisRepository;
import com.springboot.project.gestionFacture.jparepo.ParameterRepository;
import com.springboot.project.gestionFacture.jparepo.ProduitRepository;
import com.springboot.project.gestionFacture.service.ActivityLogService;
import com.springboot.project.gestionFacture.service.DevisService;
import com.springboot.project.gestionFacture.service.LoggerService;

@Service
public class DevisServiceImpl implements DevisService{
	@Autowired
	private LoggerService loggerService;
	@Autowired
	private DevisRepository repo;
	@Autowired
	private ParameterRepository detailS;
	@Autowired
	private ProduitRepository produitS;
	@Autowired
	private ActivityLogService logS;
	@Override
	public List<Devis> getDevis() {
		this.loggerService.logData("get all devis");
		return this.repo.findAll();
	}

	@Override
	public Devis getDevisById(int theId) {
		Devis devis=this.repo.findById(theId).get();
		this.loggerService.logData("get devis "+devis.toString());
		return devis;
	}

	@Override
	public List<Devis> getDevisByClient(Client client) {
		return this.repo.findByClient(client);
	}

	@Override
	public List<Devis> getDevisByUser(User user) {
		return this.repo.findByUser(user);
	}

	@Override
	public void deleteDevis(int theId) {
		this.repo.deleteById(theId);
	}

	@Override
	public Devis save(Devis devis) {
		return this.repo.save(devis);
	}

}

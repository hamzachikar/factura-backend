package com.springboot.project.gestionFacture.service;

import java.util.List;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.Devis;
import com.springboot.project.gestionFacture.entity.User;

public interface DevisService {
	public List<Devis> getAllDevis();
	public Devis getDevisById(int theId);
	public List<Devis> getDevisByClient(Client client);
	public List<Devis> getDevisByUser(User user);
	public void deleteDevis(int theId);
	public Devis save(Devis devis);
}

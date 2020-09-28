package com.springboot.project.gestionFacture.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.Devis;
import com.springboot.project.gestionFacture.entity.User;

public interface DevisRepository extends JpaRepository<Devis, Integer>{
	public List<Devis> findByClient(Client client);
	public List<Devis> findByUser(User user);
}

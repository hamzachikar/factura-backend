package com.springboot.project.gestionFacture.service;

import java.util.List;
import java.util.Optional;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.User;


public interface ClientService {
	List<Client> getClients();
	Optional<Client> getClient(int theId);
	void deleteClient(int theId);
	Client save(Client client);
}

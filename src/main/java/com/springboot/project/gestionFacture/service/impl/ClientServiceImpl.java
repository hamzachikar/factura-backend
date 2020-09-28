package com.springboot.project.gestionFacture.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.jparepo.ClientRepository;
import com.springboot.project.gestionFacture.service.ActivityLogService;
import com.springboot.project.gestionFacture.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository repo;
	@Autowired
	private ActivityLogService logS;
	@Override
	public List<Client> getClients() {
		return repo.findAll();
	}

	@Override
	public Optional<Client> getClient(int theId) {
		return repo.findById(theId);
	}

	@Override
	public void deleteClient(int theId) {
		Client client =this.repo.findById(theId).get();
		this.logS.saveLog("delete", "delete client name:"+client.getName());
		repo.deleteById(theId);
		
	}

	@Override
	public Client save(Client client) {
		if(client.getId()==0) {
			this.logS.saveLog("save", "save new client");
		}
		else {
			this.logS.saveLog("update", "update client id:"+client.getId());
		}
		return repo.save(client);
	}

	@Override
	public List<Client> getClientsByUser(User user) {
		if(user.getRole().equals("admin")) {
			return this.repo.findByAdminUser(user);
		}
		else {
			return this.repo.findByAdminUser(user.getAdminUser()); 
		}
	}
	

}

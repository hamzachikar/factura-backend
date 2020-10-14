package com.springboot.project.gestionFacture.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.Produit;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.entity.UserAuthS;
import com.springboot.project.gestionFacture.jparepo.ClientRepository;
import com.springboot.project.gestionFacture.security.MyUserDetails;
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
		List<Client> clients=new ArrayList<Client>();
		if(UserAuthS.getAuthUser().getRole().equals("admin")) {
			clients=this.repo.findByAdminUser(UserAuthS.getAuthUser());
		}
		else {
			clients=this.repo.findByAdminUser(UserAuthS.getAuthUser().getAdminUser()); 
		}
		return clients;
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
		return repo.save(client);
	}

	
	

}

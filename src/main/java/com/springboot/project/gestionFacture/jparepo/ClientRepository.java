package com.springboot.project.gestionFacture.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.User;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	public List<Client> findByAdminUser(User user);
}

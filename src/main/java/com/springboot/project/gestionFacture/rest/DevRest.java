package com.springboot.project.gestionFacture.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.gestionFacture.entity.Client;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.service.ClientService;
import com.springboot.project.gestionFacture.service.UserService;
@CrossOrigin(origins="*",allowedHeaders = "*",allowCredentials ="true")
@RestController
@RequestMapping("/dev")
public class DevRest {
	@Autowired
	private UserService userService ;
	@Autowired
	private ClientService clientService;
	
	//user management part
	@PostMapping("/saveUser")
	public User saveUsers(@RequestBody User theUser) {
		return userService.save(theUser);
	}
	@GetMapping("/getAllUsers")
	public List <User> getUsers() {
	 	return userService.getUsers();
	}
	@GetMapping("/getUsersOfAdmin")
	public List <User> getUsersByAdminUser(@RequestBody User user) {
	 	return userService.getUsersByAdminUser(user);
	}
	@GetMapping("/getUser/{theUserId}")
	public Optional <User> getUser(@PathVariable int theUserId){
		return userService.getUserById(theUserId);
	}
	@DeleteMapping("/deleteUser/{theUserId}")
	public void deleteUser(@PathVariable int theUserId) {
		userService.deleteUser(theUserId);
	}
	
	//client management part
	@GetMapping("/getAllClients")
	public List<Client> getClients(){
		return this.clientService.getClients();
	}

}

package com.springboot.project.gestionFacture.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.project.gestionFacture.entity.Parameter;
import com.springboot.project.gestionFacture.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.gestionFacture.entity.ActivityLog;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.service.ActivityLogService;
import com.springboot.project.gestionFacture.service.ClientService;
import com.springboot.project.gestionFacture.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminUserRest {
	@Autowired
	private UserService userService ;
	@Autowired
	private ActivityLogService log;
	@Autowired
	private ParameterService parameterService;
	//user management part
	//change when adding the auth module
	@PostMapping("/saveUser")
	public User saveUsers(@RequestBody User theUser) {
		return userService.save(theUser);
	}
	//change it when adding the auth module 
	@GetMapping("/getAllUsers")
	public List <User> getUsersByAdminUser() {
	 	return userService.getUsers();
	}
	@GetMapping("/getUser/{theUserId}")
	public Optional <User> getUserById(@PathVariable int theUserId){
		return userService.getUserById(theUserId);
	}
	@DeleteMapping("/deleteUser/{theUserId}")
	public void deleteUserById(@PathVariable int theUserId) {
		userService.deleteUser(theUserId);
	}
	// facture details management part
	@PostMapping("/saveFactureDetail")
	public Parameter saveFactureDetails(@RequestBody  Parameter parameter) {
		return this.parameterService.saveParam(parameter);
	}

	//activity log managements
	
	@GetMapping("/logs")
	public List<ActivityLog> getAllLogs(){
		return this.log.getAllLog();
	}
	@GetMapping("/logs/user")
	public List<ActivityLog> getAllLogsUser(@RequestBody User user){
		return this.log.getAllLogByUser(user);
	}
	@GetMapping("/logs/date")
	public List<ActivityLog> getAllLogsUser(@RequestBody Date date){
		return this.log.getAllLogByDate(date);
	}
}

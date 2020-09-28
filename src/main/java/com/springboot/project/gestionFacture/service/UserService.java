package com.springboot.project.gestionFacture.service;

import java.util.List;
import java.util.Optional;

import com.springboot.project.gestionFacture.entity.User;

public interface UserService {
	List<User> getUsers();
	User getUserByEmail(String email);
	List<User>getUsersByAdminUser(User user);
	Optional<User> getUserById(int theId);
	void deleteUser(int theId);
	User save(User user);
}

package com.springboot.project.gestionFacture.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.project.gestionFacture.entity.User;

public interface UserService {
	List<User> getUsers();
	User getUserByEmail(String email);
	List<User>getUsersByAdminUser(User user);
	Optional<User> getUserById(int theId);
	void deleteUser(int theId);
	User save(User user);
	User updateProfile(User user,MultipartFile file) throws IOException;
}

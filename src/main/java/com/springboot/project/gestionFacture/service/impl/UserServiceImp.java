package com.springboot.project.gestionFacture.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.entity.UserAuthS;
import com.springboot.project.gestionFacture.jparepo.UserRepository;
import com.springboot.project.gestionFacture.security.MyUserDetails;
import com.springboot.project.gestionFacture.service.UserService;


@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public List<User> getUsers() {
		return userRepository.findByAdminUser(UserAuthS.getAuthUser());
	}

	
	@Override
	@Transactional
	public void deleteUser(int theId) {
		userRepository.deleteById(theId);

	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);

	}

	@Override
	public Optional<User> getUserById(int theId) {
		// TODO Auto-generated method stub
		return userRepository.findById(theId);
	}


	@Override
	public List<User> getUsersByAdminUser(User user) {
		return this.userRepository.findByAdminUser(user);
	}


	@Override
	public User getUserByEmail(String email) {
		return this.userRepository.findByEmail(email).get();
	}


	@Override
	public User updateProfile(User user,MultipartFile file) throws IOException {
		byte[] compress=ImageService.compressBytes(file.getBytes());
		user.setAvatar(compress);
		User userS=this.userRepository.save(user);
		userS.setName("tset");
		userS.setAvatar(ImageService.decompressBytes(user.getAvatar()));;
		return userS;
	}

}

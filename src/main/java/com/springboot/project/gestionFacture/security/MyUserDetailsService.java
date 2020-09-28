package com.springboot.project.gestionFacture.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.jparepo.UserRepository;
import com.springboot.project.gestionFacture.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> compte=repo.findByEmail(email);
		compte.orElseThrow(()->new UsernameNotFoundException("not found"));
		return compte.map(MyUserDetails::new).get();
	}
	
}

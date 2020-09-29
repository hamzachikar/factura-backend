package com.springboot.project.gestionFacture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.gestionFacture.entity.AuthResponse;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.security.JwtUtil;
import com.springboot.project.gestionFacture.security.MyUserDetailsService;
import com.springboot.project.gestionFacture.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthRest {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserService userService;
	@PostMapping("")
	public ResponseEntity<?>createAuthenticationToken(@RequestParam String email, @RequestParam String password)throws Exception{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		final UserDetails userDetails=userDetailsService.loadUserByUsername(email);
		final User user=userService.getUserByEmail(email);
		user.setPassword(null);
		user.setAdminUser(null);
		final String jwt=jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(user,jwt));
	}
}

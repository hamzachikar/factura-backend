package com.springboot.project.gestionFacture.jparepo;

import com.springboot.project.gestionFacture.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.gestionFacture.entity.User;

public interface ParameterRepository extends JpaRepository<Parameter, Integer> {
	public Parameter findByAdminUser(User user);
}

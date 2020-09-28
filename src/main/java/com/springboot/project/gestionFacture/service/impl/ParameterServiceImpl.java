package com.springboot.project.gestionFacture.service.impl;

import com.springboot.project.gestionFacture.entity.Parameter;
import com.springboot.project.gestionFacture.jparepo.ParameterRepository;
import com.springboot.project.gestionFacture.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterRepository repo;
    @Override
    public Parameter saveParam(Parameter parameter) {
        return this.repo.save(parameter);
    }
}

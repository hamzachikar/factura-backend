package com.springboot.project.gestionFacture.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService{
	private static final Logger LOGGER =LogManager.getLogger(LoggerServiceImpl.class.getName());
	@Override
	public void logData(String msg) {
		LOGGER.info(msg);
	}
	
}

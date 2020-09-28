package com.springboot.project.gestionFacture.service;

import java.util.Date;
import java.util.List;

import com.springboot.project.gestionFacture.entity.ActivityLog;
import com.springboot.project.gestionFacture.entity.User;

public interface ActivityLogService {
	public List<ActivityLog> getAllLog();
	public List<ActivityLog> getAllLogByUser(User user);
	public List<ActivityLog> getAllLogByDate(Date date);
	public void saveLog(String act,String msg);
}

package com.springboot.project.gestionFacture.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springboot.project.gestionFacture.entity.UserAuthS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.gestionFacture.entity.ActivityLog;
import com.springboot.project.gestionFacture.entity.User;
import com.springboot.project.gestionFacture.jparepo.ActivityLogRepository;
import com.springboot.project.gestionFacture.service.ActivityLogService;

@Service
public class ActivityLogServiceImpl implements ActivityLogService{
	@Autowired
	private ActivityLogRepository repo;
	
	@Override
	public List<ActivityLog> getAllLog() {
		List<ActivityLog> activities=this.getLogActLogUser(this.repo.findAll());
		return activities;
	}
	private List<ActivityLog> getLogActLogUser(List<ActivityLog> activities){
		List<ActivityLog> acts=new ArrayList<>();
		for(ActivityLog act:activities){
			if(act.getUser().getAdminUser()==null){
				if(act.getUser().getId()== UserAuthS.getAuthUser().getId()){
					acts.add(act);
				}
			}
			else{
				if(act.getUser().getAdminUser().getId()== UserAuthS.getAuthUser().getId()){
					acts.add(act);
				}
			}
		}
		return acts;
	}
	@Override
	public List<ActivityLog> getAllLogByUser(User user) {
		return this.repo.findByUser(user);
	}

	@Override
	public List<ActivityLog> getAllLogByDate(Date date) {
		return this.repo.findByDate(date);
	}

	@Override
	public void saveLog(String act,String msg) {
		ActivityLog log=new ActivityLog(new Date(),null,act,msg);
		this.repo.save(log);
	}
}

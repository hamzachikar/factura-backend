package com.springboot.project.gestionFacture.jparepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.gestionFacture.entity.ActivityLog;
import com.springboot.project.gestionFacture.entity.User;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer>{
	public List<ActivityLog> findByUser(User user);
	public List<ActivityLog> findByDate(Date date);
}

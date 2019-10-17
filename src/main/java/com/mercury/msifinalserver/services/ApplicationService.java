package com.mercury.msifinalserver.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Application;
import com.mercury.msifinalserver.beans.User;
import com.mercury.msifinalserver.daos.ApplicationDao;
import com.mercury.msifinalserver.daos.UserDao;
import com.mercury.msifinalserver.http.Response;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationDao applicationDao;
	
	@Autowired
	private UserDao userDao;
	
	public List<Application> getApplications(Authentication authentication) {
		User user = userDao.findByUsername(authentication.getName());
		return user.getApplications();
	}
	
	public Application getApplicationById(int id) {
		return applicationDao.findById(id).get();
	}
	
	public Response addApplication(Application application, Authentication authentication) {
		try {
			application.setUser(userDao.findByUsername(authentication.getName()));
			applicationDao.save(application);
			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}
	
	public Response updateApplication(Application newApplication, int id, Authentication authentication) {
		try {
			Application oldApplication = applicationDao.getOne(id);
			newApplication.setUser(userDao.findByUsername(authentication.getName()));
			BeanUtils.copyProperties(newApplication, oldApplication);
			applicationDao.save(newApplication);
			return new Response(true);
		} catch (Exception e) {
			//e.printStackTrace();
			return new Response(false);
		}
	}
	
	public Response deleteApplication(int id) {
		try {
			applicationDao.delete(id);
			System.out.println("delete success: " + id);
			return new Response(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false);
		}
	}
}

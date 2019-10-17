package com.mercury.msifinalserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.Application;
import com.mercury.msifinalserver.http.Response;
import com.mercury.msifinalserver.services.ApplicationService;

@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/applications") 
	public List<Application> getApplications(Authentication authentication) {
		return applicationService.getApplications(authentication);
	}
	
	@GetMapping("/applications/{id}")
	public Application getApplicationById(@PathVariable int id) {
		return applicationService.getApplicationById(id);
	}
	
	@PostMapping
	public Response postApplication(@RequestBody Application application, Authentication authentication) {
		return applicationService.addApplication(application, authentication);
	}
	
	@PutMapping("/applications/{id}")
	public Response putApplication(@RequestBody Application application, @PathVariable int id, Authentication authentication) {
		return applicationService.updateApplication(application, id, authentication);
	}
	
	@DeleteMapping("/applications/{id}")
	public Response deleteApplication(@PathVariable int id) {
		return applicationService.deleteApplication(id);
	}
}

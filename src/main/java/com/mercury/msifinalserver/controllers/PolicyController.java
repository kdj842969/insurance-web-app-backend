package com.mercury.msifinalserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.Policy;
import com.mercury.msifinalserver.services.PolicyService;

@RestController
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	
	@GetMapping("/policies/{id}")
	public Policy getPolicy(@PathVariable int id) {
		return policyService.getPolicyById(id);
	}
	
}

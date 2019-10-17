package com.mercury.msifinalserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.Claim;
import com.mercury.msifinalserver.services.ClaimService;

@RestController
public class ClaimController {
	@Autowired
	private ClaimService claimService;
	
	@GetMapping("/claims")
	public List<Claim> getAll() {
		return claimService.getAll();
	}
}

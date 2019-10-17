package com.mercury.msifinalserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.Client;
import com.mercury.msifinalserver.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> getAll() {
		return clientService.getAll();
	}
}

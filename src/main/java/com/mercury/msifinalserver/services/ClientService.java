package com.mercury.msifinalserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Client;
import com.mercury.msifinalserver.daos.ClientDao;

@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;
	
	public List<Client> getAll() {
		return clientDao.findAll();
	}
}

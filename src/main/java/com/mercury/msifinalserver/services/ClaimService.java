package com.mercury.msifinalserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Claim;
import com.mercury.msifinalserver.daos.ClaimDao;

@Service
public class ClaimService {
	@Autowired
	private ClaimDao claimDao;
	
	public List<Claim> getAll() {
		return claimDao.findAll();
	}
}

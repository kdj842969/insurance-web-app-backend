package com.mercury.msifinalserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Policy;
import com.mercury.msifinalserver.daos.PolicyDao;

@Service
public class PolicyService {
	@Autowired
	private PolicyDao policyDao;
	
	public Policy getPolicyById(int id) {
		return policyDao.findById(id).get();
	}
}

package com.mercury.msifinalserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.msifinalserver.beans.Car;
import com.mercury.msifinalserver.daos.CarDao;

@Service
public class CarService {
	@Autowired
	private CarDao carDao;
	
	public List<Car> getAll() {
		return carDao.findAll();
	}
}

package com.mercury.msifinalserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.msifinalserver.beans.Car;
import com.mercury.msifinalserver.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<Car> getAll() {
		return carService.getAll();
	}
}

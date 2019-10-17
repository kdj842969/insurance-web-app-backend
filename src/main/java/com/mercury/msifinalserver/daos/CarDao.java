package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.Car;

public interface CarDao extends JpaRepository<Car, Integer> {

}

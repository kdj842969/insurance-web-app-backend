package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.Policy;

public interface PolicyDao extends JpaRepository<Policy, Integer> {

}

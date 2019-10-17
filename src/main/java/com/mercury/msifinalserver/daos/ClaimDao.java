package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.Claim;

public interface ClaimDao extends JpaRepository<Claim, Integer> {

}

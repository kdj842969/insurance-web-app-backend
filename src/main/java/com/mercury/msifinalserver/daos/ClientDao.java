package com.mercury.msifinalserver.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.msifinalserver.beans.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {

}
